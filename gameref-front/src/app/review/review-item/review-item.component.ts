import { Component, Input, OnInit } from '@angular/core';
import { Review } from 'src/app/model/Review';
import { ReviewService } from 'src/app/service/review.service';
import { ReviewListComponent } from '../review-list/review-list.component';

@Component({
  selector: 'app-review-item',
  templateUrl: './review-item.component.html',
  styleUrls: ['./review-item.component.css']
})
export class ReviewItemComponent implements OnInit {
  @Input() review!: Review;
  @Input() parent!: ReviewListComponent;
  constructor(private reviewService: ReviewService) { }

  ngOnInit(): void {
  }

}
