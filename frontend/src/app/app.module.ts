import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HotelService } from './hotel.service';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ContractListComponent } from './contract-list/contract-list.component';
import { ReactiveFormsModule } from '@angular/forms'; 
import { ContractService } from './service/contract.service';
import { SearchContractComponent } from './search-contract/search-contract.component';
import { SearchComponent } from './search/search.component';


@NgModule({
  declarations: [
    AppComponent,
    ContractListComponent,
    HomeComponent,
    SearchContractComponent,
    SearchComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,
    FormsModule
  ],
  providers: [ContractService,HotelService],
  bootstrap: [AppComponent]
})
export class AppModule { }
