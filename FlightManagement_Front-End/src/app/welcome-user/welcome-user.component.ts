import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-welcome-user',
  templateUrl: './welcome-user.component.html',
  styleUrls: ['./welcome-user.component.css']
})
export class WelcomeUserComponent implements OnInit {
  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  bookFlight(): void{
    this.router.navigate(['addBooking']);
  }


  addScheduledFlight(): void{
    this.router.navigate(['scheduledFlight/add']);
  }

  viewScheduledFlight(): void{
    this.router.navigate(['scheduledFlight/show']);
  }

  searchScheduledFlight(): void{
      this.router.navigate(['scheduledFlight/search']);
  }

  modifyScheduledFlight(): void{
    this.router.navigate(['scheduledFlight/modify']);
  }

  addFlight(): void{
    this.router.navigate(['addFlight']);
  }

  viewFlight(): void{
    this.router.navigate(['flights']);
  }

  addAirport(): void{
    this.router.navigate(['addAirport']);
  }

  viewAirport(): void{
    this.router.navigate(['airports']);
  }

}
