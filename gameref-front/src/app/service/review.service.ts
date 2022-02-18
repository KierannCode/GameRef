import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from '../model/Review';
import { Page } from './Page';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  private API_URL = "http://localhost:8080/api";
  private pageSize = 10;

  constructor(private http: HttpClient) { }

  getReviews(page: number = 0, sort: string = "id", descending: boolean = true): Observable<Page<Review>> {
    let url = `${this.API_URL}/reviews?page=${encodeURIComponent(page)}&size=${encodeURIComponent(this.pageSize)}&sort=${encodeURIComponent(sort)}`;
    if (descending) {
      url += `,${encodeURIComponent('desc')}`;
    }
    return this.http.get<Page<Review>>(url);
  }

  create(data: any): Observable<any> {
    return this.http.post(`${this.API_URL}/review`, data);
  }
}
