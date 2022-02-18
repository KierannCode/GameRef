import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Platform } from '../model/Platform';

@Injectable({
  providedIn: 'root'
})
export class PlatformService {


  private API_URL = "http://localhost:8080/api";

  constructor(private http: HttpClient) {
  
   }

  getPlatforms(): Observable<Array<Platform>> {
    let url = `${this.API_URL}/platforms`;
    return this.http.get<Array<Platform>>(url);
  }
}
