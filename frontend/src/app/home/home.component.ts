import { Component,OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DatePipe } from '@angular/common'; 
import { ContractService } from '../service/contract.service'
import { Contract } from '../contract';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [DatePipe] 
})
export class HomeComponent implements OnInit {
  contracts: any;

  // constructor(private http: HttpClient, private datePipe: DatePipe) {} // Inject the DatePipe here
  constructor(private contractService: ContractService) {}
  ngOnInit() {
    this.fetchContracts();
  }

  fetchContracts() {
    console.log('Fetching contracts...');
    // 'backend_api_url' with actual Spring Boot backend API URL
    this.contractService.getAllContracts().pipe(
      catchError((error) => {
        console.error('Error fetching contracts:', error);
        // Handle the error here, e.g., display an error message in the UI
        // Return an observable with a default value or an empty array as per your requirement
        return throwError('Failed to fetch contracts. Please try again later.');
      })
    ).subscribe(
      (data: Contract[]) => {
        data.sort((a, b) => b.id - a.id);
        this.contracts = data.slice(0,10);
      }
    );
  }

  // Helper function to format dates
  // formatDate(date: string): string {
  //   return this.datePipe.transform(date, 'yyyy-MM-dd') || '';
  // }

}
