import { HttpClient } from "@angular/common/http";
import { TestBed } from "@angular/core/testing";
import { Review } from "../model/Review";
import { ReviewService } from "./review.service";

describe('ReviewService', () => {
  let reviewService: ReviewService;
  let httpSpy: jasmine.SpyObj<HttpClient>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        ReviewService,
        { provide: HttpClient, useValue: createSpyFromClass(HttpClient) }
      ]
    });

    reviewService = TestBed.inject(ReviewService);
    httpSpy = TestBed.inject<any>(HttpClient);
  });

  it('should create a new review', (done: DoneFn) => {

    var newReview = {
      description: "New Review from a player",
      submitDate: new Date("2019-01-16"),
      rating: 15,
      
    } as Review;

    httpSpy.post.and.nextWith(newReview);

    reviewService.create(newReview).subscribe(
      customer => {
        expect(customer).toEqual(newReview);
        done();
      },
      done.fail
    );
    expect(httpSpy.post.calls.count()).toBe(1);
  });
});











































/*import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { ReviewService } from './review.service';

describe('ReviewService', () => {
  let service: ReviewService;
  let httpClientSpy: jasmine.SpyObj<HttpClient>;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    service = new ReviewService(httpClientSpy);
    TestBed.configureTestingModule({
      providers: [
        ReviewService
        
      ]
   });
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
}); */
