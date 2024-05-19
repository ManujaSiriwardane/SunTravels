import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators, AbstractControl, ValidatorFn, ValidationErrors  } from '@angular/forms';
import { ContractService } from '../service/contract.service';
import { Contract,Hotel,RoomType } from '../contract';
import { Observer } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';

function atLeastOneRoomType(control: AbstractControl): ValidationErrors | null {
  const roomTypesArray = control as FormArray;
  if (roomTypesArray && roomTypesArray.length > 0) {
    return null; // At least one room type is added, so validation passes.
  } else {
    return { atLeastOneRoomType: true }; // Validation fails, no room type is added.
  }
}
@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit{ 
  //  mainForm!: FormGroup;
 
  newContractListRequestbody;
  constructor(
    private fb: FormBuilder,
    private contractService: ContractService
    ) { }

  ngOnInit() {
    
}

  mainForm = this.fb.group({
  // Your main form controls here
  start_date: ['', Validators.required],
  end_date: ['', Validators.required, ],
  hotel_name: ['', Validators.required],
  address: ['', Validators.required],
  city: ['', Validators.required],
  roomTypes: this.fb.array([],atLeastOneRoomType)
});
get roomTypes() {
  return this.mainForm.get('roomTypes') as FormArray;
}

addRoomType() {
  this.roomTypes.push(this.createRoomType());
}


createRoomType(): FormGroup {
  return this.fb.group({
    type_name: ['', Validators.required],
    price: ['', Validators.required],
    no_of_rooms: ['', Validators.required],
    max_adults: ['', Validators.required],
    markupPercentage: [15, Validators.required]
    
  });
}





removeRoomType(index: number) {
  this.roomTypes.removeAt(index);
}

createContract(data){
  this.markAllFormControlsAsTouched();
  console.log('Form Data:', this.mainForm.value);
  const roomTypesArray = [];
    for (const roomType of data.roomTypes) {
      roomTypesArray.push({
        type_name: roomType.type_name,
        price: roomType.price,
        no_of_rooms: roomType.no_of_rooms,
        max_adults: roomType.max_adults,
        markupPercentage: roomType.markupPercentage
      });
    }
  this.newContractListRequestbody = {
    "hotels": {
      "hotel_name": data?.hotel_name,
      "address": data?.address,
      "city": data?.city
    },
    "roomTypes": roomTypesArray,
   
    "start_date": data?.start_date,
    "end_date": data?.end_date
  
  
  }

  if (this.mainForm.valid) {
    
    this.contractService.createContract(this.newContractListRequestbody)
      .subscribe((response) => {
        
        alert('Contract created successfully!');
     
      },
      (error: HttpErrorResponse) => {
        // Handle error response (status other than 200)
        alert('Failed to create contract');
        console.log("error",error);
      }
       
      );
    }

  }
  markAllFormControlsAsTouched() {
    Object.values(this.mainForm.controls).forEach(control => {
      control.markAsTouched();
    });

 }

 
}
