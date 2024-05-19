import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HotelService {
  private apiUrl = 'http://localhost:8080'
  constructor(private http: HttpClient) { }

  searchHotels(searchParams: any) {
    return this.http.post(`${this.apiUrl}/reservation/reservation`, searchParams);
  }
}
