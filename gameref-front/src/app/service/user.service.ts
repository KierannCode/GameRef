import { HttpClient } from '@angular/common/http';
import { ThisReceiver } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { PlayerDto } from '../dto/PlayerDto';
import { UserDto } from '../dto/UserDto';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  

  private API_URL = "http://localhost:8080/api";

  constructor(private http: HttpClient) {

  }
  

  login(dto: UserDto): Observable<User> {
    let url = `${this.API_URL}/login`;
    return this.http.post<User>(url, dto, { withCredentials: true });
  }

  logout(): Observable<void> {
    let url = `${this.API_URL}/logout`
    return this.http.post<void>(url, {}, { withCredentials: true });
  }

  signIn(dto: PlayerDto): Observable<User> {
    let url = `${this.API_URL}/signIn`;
    return this.http.post<User>(url, dto, { withCredentials: true });
  }

  getSessionUser(): Observable<User> {
    let url = `${this.API_URL}/user`;
    return this.http.get<User>(url, { withCredentials: true });
  }
}
