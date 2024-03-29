import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Airport } from '../airport';
import { AirportService } from '../airport.service';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-create-flight',
  templateUrl: './create-flight.component.html',
  styleUrls: ['./create-flight.component.css']
})
export class CreateFlightComponent implements OnInit {

  flight : Flight =new Flight();
  submitted=false;
    constructor(private flightService: FlightService,
      private router: Router) { }
  
    ngOnInit(){
    }
    newFlight(): void{
      this.submitted=false;
      this.flight=new Flight();
    }
    save() {
      this.flightService.addFlight(this.flight)
        .subscribe(data => console.log(data), error => console.log(error));
      this.flight= new Flight();
      this.gotoList();
    }
  
    onSubmit() {
      this.submitted=true;
      this.save();
    }
  
    gotoList() {
      this.router.navigate(['/flights']);
    }
}
