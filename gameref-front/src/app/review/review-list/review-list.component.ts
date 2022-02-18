import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PageEvent } from '@angular/material/paginator';
import { Review } from 'src/app/model/Review';
import { ReviewService } from 'src/app/service/review.service';
import { CreateReviewDialogComponent } from '../create-review-dialog/create-review-dialog.component';

@Component({
  selector: 'app-review-list',
  templateUrl: './review-list.component.html',
  styleUrls: ['./review-list.component.css']
})
export class ReviewListComponent implements OnInit {
  displayedColumns: string[] = ['player', 'game', 'submitDate', 'moderator', 'rating', 'description', 'action'];

  dataSource!: Array<Review>;
  totalElements!: number;

  constructor(private dialog: MatDialog, private reviewService: ReviewService) {
    this.loadPage();
  }

  ngOnInit(): void {
  }

  loadPage(): void {
    this.reviewService.getReviews().subscribe(val => {
      this.dataSource = val.content;
      this.totalElements = val.totalElements;
      console.log(this.dataSource);
    });
  }

  openCreateReviewDialog(): void {
    const dialogRef = this.dialog.open(CreateReviewDialogComponent, {
      width: '500px',
      data: {},
    });
  }

  nextPage(event: PageEvent) {
    this.reviewService.getReviews(event.pageIndex).subscribe(val => this.dataSource = val.content);
  }
}
