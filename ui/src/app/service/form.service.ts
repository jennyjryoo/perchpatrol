import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Bird } from '../model/bird';

@Injectable({
  providedIn: 'root'
})
export class FormService {

  private url:string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080"
   }

   submitForm(form: any) {
    return this.http.post<Bird[]>(`${this.url}/submit`,form);
   }
   
}
