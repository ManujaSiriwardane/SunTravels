import { Data } from "popper.js";

export interface Contract {
  id:number;
  hotels: Hotel;
  roomTypes: RoomType[];
  start_date: Date;
  end_date: Date;
}

export interface Hotel {
  hotel_name: string;
  address: string;
  city: string;
}

export interface RoomType {
  type_name: string;
  price: number;
  no_of_rooms: number;
  max_adults: number;
  markupPercentage:number;
}
