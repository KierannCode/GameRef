import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ReviewDto } from '../dto/ReviewDto';
import { Review } from '../model/Review';
import { Page } from './Page';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  private API_URL = "http://localhost:8080/api";
  private pageSize = 5;

  constructor(private http: HttpClient) { }

  getReviews(page: number = 0, sort: string = "id", descending: string = "true", filter: string = "all"): Observable<Page<Review>> {
    let url = `${this.API_URL}/reviews/${filter}?page=${encodeURIComponent(page)}&size=${encodeURIComponent(this.pageSize)}&sort=${encodeURIComponent(sort)}`;
    if (String(descending).toLowerCase() == "true") {
      url += `,${encodeURIComponent('desc')}`;
    }
    return this.http.get<Page<Review>>(url, {withCredentials: true});
  }

  create(data: ReviewDto): Observable<Review> {
    return this.http.post<Review>(`${this.API_URL}/review`, data, {withCredentials: true});
  }

  delete(reviewId: number): Observable<Review> {
    let url = `${this.API_URL}/review/${reviewId}`
    return this.http.delete<Review>(url, {withCredentials: true});
  }

  validate(reviewId: number): Observable<Review> {
    let url = `${this.API_URL}/review/${reviewId}/validate`
    return this.http.patch<Review>(url, {}, {withCredentials: true});
  }
}
