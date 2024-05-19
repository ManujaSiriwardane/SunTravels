import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray } from '@angular/forms';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-search-contract',
  templateUrl: './search-contract.component.html',
  styleUrls: ['./search-contract.component.css']
})
export class SearchContractComponent implements OnInit {
  searchForm: FormGroup;
  searchResults: any[] = [];
  room: FormArray;

  constructor(private fb: FormBuilder, private hotelService: HotelService) { }

  ngOnInit() {
    this.searchForm = this.fb.group({
      checkinDate: [null], // The date input will be validated in the HTML template
      numberOfNights: [1],
      room: this.fb.array([])
    });

    this.room = this.searchForm.get('room') as FormArray;
    this.addRoom();
  }

  addRoom() {
    this.room.push(this.fb.group({
      numberOfAdults: [1]
    }));
  }

  search() {
    // Call the backend service to get the search results
    const searchParams = this.searchForm.value;
    this.hotelService.searchHotels(searchParams).subscribe(
      (response: any[]) => {
        this.searchResults = response;
      },
      (error) => {
        console.error('Error occurred during search:', error);
      }
    );
  }
}
