import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, pluck } from 'rxjs';
import { GameDto } from '../dto/GameDto';
import { Game } from '../model/Game';
import { Page } from './Page';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  private API_URL = "http://localhost:8080/api";
  private pageSize = 5;


  constructor(private http: HttpClient) {
  }

  getGames(page: number = 0, sort: string = "id", descending: boolean = true): Observable<Page<Game>> {
    console.log(this.http);
    let url = `${this.API_URL}/games?page=${encodeURIComponent(page)}&size=${encodeURIComponent(this.pageSize)}&sort=${encodeURIComponent(sort)}`;
    if (descending) {
      url += `,${encodeURIComponent('desc')}`;
    }
    return this.http.get<Page<Game>>(url, {withCredentials: true});
  }

  create(data: any): Observable<any> {
    return this.http.post(`${this.API_URL}/game`, data, {withCredentials: true});
  }
  delete(id: any): Observable<any> {
    return this.http.delete(`${this.API_URL}/game/${encodeURIComponent(id)}`, {withCredentials: true});
  }
  
  updateGame(id: number, dto: GameDto): Observable<any> {
    dto.releaseDate?.setHours(dto.releaseDate?.getUTCHours());
    return this.http.patch(`${this.API_URL}/game/${encodeURIComponent(id)}`, dto, {withCredentials: true});
  }
}
