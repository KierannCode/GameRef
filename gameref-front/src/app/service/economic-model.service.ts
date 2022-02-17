import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EconomicModel } from '../model/EconomicModel';

@Injectable({
  providedIn: 'root'
})
export class EconomicModelService {

  private API_URL = "http://localhost:8080/api";

  constructor(private http: HttpClient) { }

  getCategories(): Observable<Array<EconomicModel>> {
    let url = `${this.API_URL}/economicModels`;
    return this.http.get<Array<EconomicModel>>(url);
  }
}
