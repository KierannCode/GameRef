import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, pluck } from 'rxjs';
import { Game } from '../model/Game';
import { Page } from './page';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  private API_URL = "http://localhost:8080/api";
  private pageSize = 5;

  constructor(private http: HttpClient) { }

  getGames(page: number = 0, sort: string = "id", descending: boolean = true): Observable<Array<Game>> {
    let url = `${this.API_URL}/games?page=${encodeURIComponent(page)}&size=${encodeURIComponent(this.pageSize)}&sort=${encodeURIComponent(sort)}`;
    if (descending) {
      url += `,${encodeURIComponent('desc')}`;
    }
    return this.http.get<Page<Game>>(url).pipe(pluck('content'));
  }

  create(data: any): Observable<any> {
    return this.http.post(`${this.API_URL}/game`, data);
  }
  delete(id: any): Observable<any> {
    return this.http.delete(`${this.API_URL}/${id}`);
  }
}
