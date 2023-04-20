import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FormService {

  private url:string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080"
   }

   submitForm(form: any) {
    return this.http.post<any>(`${this.url}/submit`,form);
   }
}
