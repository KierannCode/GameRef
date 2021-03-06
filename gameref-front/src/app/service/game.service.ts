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

  getAllGames(): Observable<Array<Game>> {
    let url = `${this.API_URL}/allGames`;
    return this.http.get<Array<Game>>(url, { withCredentials: true });
  }

  getGames(page: number = 0, sort: string = "id", descending: string = 'true'): Observable<Page<Game>> {
    let url = `${this.API_URL}/games?page=${encodeURIComponent(page)}&size=${encodeURIComponent(this.pageSize)}&sort=${encodeURIComponent(sort)}`;
    if (String(descending).toLowerCase() == "true") {
      url += `,${encodeURIComponent('desc')}`;
    }
    return this.http.get<Page<Game>>(url, { withCredentials: true });
  }

  create(data: any): Observable<Game> {
    return this.http.post<Game>(`${this.API_URL}/game`, data, { withCredentials: true });
  }

  delete(id: any): Observable<Game> {
    return this.http.delete<Game>(`${this.API_URL}/game/${encodeURIComponent(id)}`, { withCredentials: true });
  }

  updateGame(id: number, dto: GameDto): Observable<Game> {
    dto.releaseDate?.setHours(dto.releaseDate?.getUTCHours());
    return this.http.patch<Game>(`${this.API_URL}/game/${encodeURIComponent(id)}`, dto, { withCredentials: true });
  }
}
