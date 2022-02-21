import { HttpClient } from '@angular/common/http';
import { ThisReceiver } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  

  private API_URL = "http://localhost:8080/api";

  private currentUser!: User | null;

  constructor(private http: HttpClient) {

  }
  

  login(pseudo: string, password: string): Promise<void> {
    console.log(this.http);
    let url = `${this.API_URL}/login/${pseudo}/${password}`;
    return this.http.get<User>(url, {withCredentials: true}).forEach(user => this.currentUser = user);
  }

  logout(): Promise<void> {
    let url = `${this.API_URL}/logout`
    return this.http.post<void>(url, {withCredentials: true}).forEach(() => this.currentUser = null);
  }

  getCurrentUser(): User | null {
    return this.currentUser;
  }
}
