import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Airport } from '../airport';
import { AirportService } from '../airport.service';

@Component({
  selector: 'app-create-airport',
  templateUrl: './create-airport.component.html',
  styleUrls: ['./create-airport.component.css']
})
export class CreateAirportComponent implements OnInit {

  airport: Airport=new Airport();
  submitted=false;
  constructor(private airportService: AirportService,private router: Router) { }

  ngOnInit(){
  }
  newEmployee(): void {
    this.submitted = false;
    this.airport = new Airport();
  }

  save() {
    this.airportService.addAirport(this.airport)
      .subscribe(data => console.log(data), error => console.log(error));
    this.airport = new Airport();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
  gotoList() {
    this.router.navigate(['/airports']);
  }


}
