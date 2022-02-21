import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ReviewDto } from 'src/app/dto/ReviewDto';
import { Game } from 'src/app/model/Game';
import { GameService } from 'src/app/service/game.service';
import { ReviewService } from 'src/app/service/review.service';
import { ReviewListComponent } from '../review-list/review-list.component';

@Component({
  selector: 'app-create-review-dialog',
  templateUrl: './create-review-dialog.component.html',
  styleUrls: ['./create-review-dialog.component.css']
})
export class CreateReviewDialogComponent implements OnInit {
  games?: Game[];
  rating?: number;
  description?: string;
  
  submitted = false ;
  
  constructor(
    private reviewService: ReviewService,
    private gameService: GameService,
    private parent: ReviewListComponent,
    public dialogRef: MatDialogRef<CreateReviewDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public reviewdto: ReviewDto,
  ) {}

  ngOnInit(): void {
    this.gamesList();
  }

  onSubmit():void {
    const data = {
      description: this.reviewdto.description,
      rating: this.reviewdto.rating,
      gameId: this.reviewdto.gameId,
    };
    this.reviewService.create(data)
    .subscribe({
    next: (res) => {
      console.log(res);
      this.submitted = true;
      this.onClose();
      this.parent.loadPage();
    },
    error: (e) => console.error(e)
    });
  }

  gamesList(): void{
    this.gameService.getGames()
      .subscribe({
        next: (data) => {
          this.games = data.content;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  onClose(): void {
    this.dialogRef.close();
  }

  formatLabel(value: number) {
    return value;
  }
}