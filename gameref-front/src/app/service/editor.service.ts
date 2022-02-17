import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Editor } from '../model/Editor';

@Injectable({
  providedIn: 'root'
})
export class EditorService {

  private API_URL = "http://localhost:8080/api";

  constructor(private http: HttpClient) { }

  getEditors(): Observable<Array<Editor>> {
    let url = `${this.API_URL}/editors`;
    return this.http.get<Array<Editor>>(url);
  }
}
