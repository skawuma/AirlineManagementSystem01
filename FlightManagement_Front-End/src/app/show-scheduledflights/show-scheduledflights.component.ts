import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Scheduledflight } from '../scheduledflight';
import { ScheduledflightService } from '../scheduledflight.service';

@Component({
  selector: 'app-show-scheduledflights',
  templateUrl: './show-scheduledflights.component.html',
  styleUrls: ['./show-scheduledflights.component.css']
})
export class ShowScheduledflightsComponent implements OnInit {

  public confirmClicked: boolean = false;
  public cancelClicked: boolean = false;
  scheduledflights: Observable<Scheduledflight[]> | any;

  constructor(private router: Router, private service: ScheduledflightService) { }

  ngOnInit(): void {
    this.service.showScheduleFlights().subscribe(
      (data:Observable<Scheduledflight[]>)=>this.scheduledflights=data
    );
  }

  removeScheduleFlight(scheduleFlightId:number){
    this.service.removeScheduleFlight(scheduleFlightId).subscribe();
    alert("Deleted");
    location.reload();
}

  add(){

    this.router.navigate(['/scheduledFlight/add']);

  }

  view(){

    this.router.navigate(['/scheduledFlight/show']);

  }

  search(){

    this.router.navigate(['/scheduledFlight/search']);

  }
}
