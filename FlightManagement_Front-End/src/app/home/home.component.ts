import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Airport } from '../airport';
import { AirportService } from '../airport.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 airports:Airport[]=[];

 srch:any;
 dest:any;
 journeyDate:any;

 minDate:any;
 maxDate:any;

 errorFlag:boolean=  false;


  constructor(private router:Router,private airportService:AirportService) { 
this.minDate= new Date();
this.maxDate= new Date();
this.maxDate.setMonth(this.maxDate.getMonth()+2)

  }

  ngOnInit(){
    this.airportService.getAllAirports().subscribe((data:Airport[])=>this.airports=data);
}

}
