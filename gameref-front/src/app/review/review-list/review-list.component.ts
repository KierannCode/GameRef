import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PageEvent } from '@angular/material/paginator';
import { Review } from 'src/app/model/Review';
import { ReviewService } from 'src/app/service/review.service';

@Component({
  selector: 'app-review-list',
  templateUrl: './review-list.component.html',
  styleUrls: ['./review-list.component.css']
})
export class ReviewListComponent implements OnInit {

  reviews!: Array<Review>;
  totalElements!: number;

  constructor(private dialog: MatDialog, private reviewService: ReviewService) {
    this.loadPage();
  }

  ngOnInit(): void {
  }

  loadPage(): void {
    this.reviewService.getReviews().subscribe(val => {
      this.reviews = val.content;
      this.totalElements = val.totalElements;
      console.log(this.reviews);
    });
  }
}
