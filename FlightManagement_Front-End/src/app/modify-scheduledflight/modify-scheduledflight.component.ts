import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Scheduledflight } from '../scheduledflight';
import { ScheduledflightService } from '../scheduledflight.service';

@Component({
  selector: 'app-modify-scheduledflight',
  templateUrl: './modify-scheduledflight.component.html',
  styleUrls: ['./modify-scheduledflight.component.css']
})
export class ModifyScheduledflightComponent implements OnInit {

  scheduleFlight:Scheduledflight | any;
  scheduleFlightId:any;
  show:boolean=false;
  //  modifyScheduleFlight: ScheduledFlight;
  //  mScheduleFlightId: number;
  //  mFlight: number;
  //  mAvailableSeats: number;
  //  mSchedule: number;
  mScheduleFlight:Scheduledflight | any;


  constructor(private service: ScheduledflightService, private router: Router) { }

  ngOnInit(): void {
    this.scheduleFlight=new Scheduledflight();
  }
  searchScheduleFlight(scheduleFlightId:number):any{
    this.show=true;
    console.log(scheduleFlightId);
    this.service.searchScheduledFlight(this.scheduleFlightId).subscribe((scheduleFlight:any)=>this.scheduleFlight=scheduleFlight);
  }

  modifyScheduledFlight(sId: any, aSeats: any, schedule: any,flight: any){
    this.mScheduleFlight={
      scheduleFlightId: sId,
      availableSeats: aSeats,
      flight: flight,
      schedule: schedule};
      console.log(this.mScheduleFlight);
      if(this.mScheduleFlight==null){
        alert("Scheduled Flight hnot modified");
      }
      this.service.modifyScheduledFlight(this.mScheduleFlight).subscribe();
      alert("Scheduled Flight Modified!");
  }

  idValid:boolean=false;
validateId(){
    if(this.scheduleFlightId>999){
        this.idValid=true;
    }
    else if(this.scheduleFlightId<1){
        this.idValid=true;
    }else{
        this.idValid=false;
    }
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
