import { Component, Injectable, OnInit, ViewChild } from '@angular/core';
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
@Injectable({
  providedIn: 'root'
})
export class ReviewListComponent implements OnInit {
  displayedColumns: string[] = ['player', 'game', 'submitDate', 'moderator', 'description', 'rating', 'action'];
  dataSource!: Array<Review>;
  totalElements!: number;
  sort!: string;
  descending: string = "true";
  filter: string = "all";


  constructor(private dialog: MatDialog, private reviewService: ReviewService) {
    this.loadPage();
  }

  ngOnInit(): void { }

  loadPage(): void {
    this.reviewService.getReviews().subscribe(val => {
      this.dataSource = val.content;
      this.totalElements = val.totalElements;
    });
  }

  openCreateReviewDialog(): void {
    const dialogRef = this.dialog.open(CreateReviewDialogComponent, {
      width: '500px',
      data: {},
    }).afterClosed().subscribe(() => this.loadPage());
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
}
