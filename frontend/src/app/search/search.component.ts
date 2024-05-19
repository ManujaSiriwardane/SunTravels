import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Contract } from '../contract'

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit{
  searchQuery: string;
  searchResults: Contract[];

  constructor(private http: HttpClient) { }

  ngOnInit() {
}

searchContracts() {
  this.http.post<Contract[]>('http://localhost:8080/contracts/search', { hotel_name: this.searchQuery })
    .subscribe(data => {
      this.searchResults = data;
    });
}

deleteContract(contractId: number) {
  this.http.delete(`http://localhost:8080/contracts/${contractId}`)
    .subscribe(
      () => {
        // On successful deletion, update the search results
        this.searchResults = this.searchResults.filter(contract => contract.id !== contractId);
      },
      (error) => {
        console.error('Error occurred during contract deletion:', error);
      }
    );
}
}
