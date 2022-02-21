import { HttpErrorResponse } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ReviewDto } from 'src/app/dto/ReviewDto';
import { Game } from 'src/app/model/Game';
import { GameService } from 'src/app/service/game.service';
import { ReviewService } from 'src/app/service/review.service';

@Component({
  selector: 'app-create-review-dialog',
  templateUrl: './create-review-dialog.component.html',
  styleUrls: ['./create-review-dialog.component.css']
})
export class CreateReviewDialogComponent implements OnInit {
  games!: Array<Game>;

  errorMap: Map<string, Array<string>> = new Map();

  constructor(
    private reviewService: ReviewService,
    gameService: GameService,
    @Inject(MAT_DIALOG_DATA) public reviewDto: ReviewDto,
    public dialogRef: MatDialogRef<CreateReviewDialogComponent>
  ) {
    gameService.getAllGames().subscribe(val => this.games = val);
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.reviewService.create(this.reviewDto)
      .subscribe({
        next: () => {
          this.closeDialog();
        },
        error: (response: HttpErrorResponse) => this.errorMap = new Map(Object.entries(response.error))
      });
  }

  closeDialog(): void {
    this.dialogRef.close();
  }
}
