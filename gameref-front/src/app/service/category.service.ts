import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../model/Category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {


  private API_URL = "http://localhost:8080/api";
  private API_URLerror = "http://localhost:8080/aprili";

  constructor(private httpClient: HttpClient) {
    
   }

  getCategories(): Observable<Array<Category>> {
    let url = `${this.API_URL}/categories`;
    return this.httpClient.get<Array<Category>>(url);
  }


  getCategoriesError(): Observable<Array<Category>> {
    let url = `${this.API_URLerror}/categories`;
    return this.httpClient.get<Array<Category>>(url);
  }
}
