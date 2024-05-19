import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ContractListComponent } from './contract-list/contract-list.component';
import { SearchContractComponent } from './search-contract/search-contract.component';
import { SearchComponent } from './search/search.component';
const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'create-contract', component:ContractListComponent},
  {path:'search-contract',component:SearchContractComponent},
  {path:'search-by-hotelname',component:SearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
