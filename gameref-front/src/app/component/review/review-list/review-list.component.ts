import { Component, Injectable, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PageEvent } from '@angular/material/paginator';
import { Review } from 'src/app/model/Review';
import { User } from 'src/app/model/User';
import { ReviewService } from 'src/app/service/review.service';
import { UserService } from 'src/app/service/user.service';
import { CreateReviewDialogComponent } from '../create-review-dialog/create-review-dialog.component';

@Component({
  selector: 'app-review-list',
  templateUrl: './review-list.component.html',
  styleUrls: ['./review-list.component.css']
})
@Injectable({
  providedIn: 'root'
})
export class ReviewListComponent implements OnInit {
  displayedColumns: string[] = ['submitDate', 'player', 'game', 'rating', 'description', 'status', 'actions'];
  dataSource!: Array<Review>;
  totalElements!: number;
  sort!: string;
  descending: string = "true";
  filter: string = "all";

  user!: User;

  constructor(private dialog: MatDialog,
    private reviewService: ReviewService,
    userService: UserService) {
    userService.getSessionUser().subscribe(user => {
      this.user = user;
      this.loadPage();
    });
  }

  ngOnInit(): void { }

  openCreateReviewDialog(): void {
    const dialogRef = this.dialog.open(CreateReviewDialogComponent, {
      width: '500px',
      data: {},
    }).afterClosed().subscribe(() => this.loadPage());
  }

  loadPage(): void {
    this.reviewService.getReviews().subscribe(val => {
      this.dataSource = val.content;
      this.totalElements = val.totalElements;
    });
  }

  nextPage(event: PageEvent) {
    this.reviewService.getReviews(event.pageIndex, this.sort, this.descending, this.filter).subscribe(val => {
      this.dataSource = val.content;
      this.totalElements = val.totalElements;
    });
  }

  sortReviews(): void {
    this.reviewService.getReviews(0, this.sort, this.descending, this.filter).subscribe(val => {
      this.dataSource = val.content;
      this.totalElements = val.totalElements;
    });
  }

  delete(reviewId: number): void {
    this.reviewService.delete(reviewId).subscribe(() => this.loadPage());
  }

  validate(review: Review): void {
    this.reviewService.validate(review.id).subscribe(val => Object.assign(review, val));
  }
}
