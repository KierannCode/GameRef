import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../model/Category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private API_URL = "http://localhost:8080/api";

  constructor(private http: HttpClient) { }

  getCategories(): Observable<Array<Category>> {
    let url = `${this.API_URL}/categories`;
    return this.http.get<Array<Category>>(url);
  }
}
