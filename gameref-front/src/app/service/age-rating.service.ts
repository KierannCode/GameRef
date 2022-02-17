import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AgeRating } from '../model/AgeRating';

@Injectable({
  providedIn: 'root'
})
export class AgeRatingService {

  private API_URL = "http://localhost:8080/api";

  constructor(private http: HttpClient) { }

  getAgeRatings(): Observable<Array<AgeRating>> {
    let url = `${this.API_URL}/ageRatings`;
    return this.http.get<Array<AgeRating>>(url);
  }
}
