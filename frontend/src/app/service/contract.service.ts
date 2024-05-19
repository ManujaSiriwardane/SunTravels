import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'; // Import Observable
import { Contract } from '../contract';

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  private baseUrl = 'http://localhost:8080'; 

  constructor(private http: HttpClient) {}

  getAllContracts(): Observable<Contract[]> { // Return Observable<Contract[]>
    return this.http.get<Contract[]>(`${this.baseUrl}/contracts/all`);
  }

  createContract(contract: Contract): Observable<any> {
    console.log("running create contract",contract);
    return this.http.post(`${this.baseUrl}/contracts`, contract);
    
  }
}
