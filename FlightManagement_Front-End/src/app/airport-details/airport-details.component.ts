import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Airport } from '../airport';
import { AirportService } from '../airport.service';

@Component({
  selector: 'app-airport-details',
  templateUrl: './airport-details.component.html',
  styleUrls: ['./airport-details.component.css']
})
export class AirportDetailsComponent implements OnInit {

  airportCode:any;
  airport!: Airport;
  constructor(private route: ActivatedRoute,private router: Router,
    private airportService: AirportService) { }

  ngOnInit(){
    this.airport = new  Airport();

    this.airportCode = this.route.snapshot.params['airportCode'];

    this.airportService.viewAirport(this.airportCode)
      .subscribe(data => {
        console.log(data)
        this.airport = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['airports']);
  }

}
