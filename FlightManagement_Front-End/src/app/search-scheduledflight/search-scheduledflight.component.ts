import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Scheduledflight } from '../scheduledflight';
import { ScheduledflightService } from '../scheduledflight.service';

@Component({
  selector: 'app-search-scheduledflight',
  templateUrl: './search-scheduledflight.component.html',
  styleUrls: ['./search-scheduledflight.component.css']
})
export class SearchScheduledflightComponent implements OnInit {

  scheduleflight: Scheduledflight | any; 
  scheduleFlightId:any;
  show:boolean=false;


  constructor(private service: ScheduledflightService, private router: Router) { }

  ngOnInit(): void {
    this.scheduleflight=new Scheduledflight()
  }

  searchScheduledFlight(scheduleFlightId:any):any{
    this.show=true;
    console.log(scheduleFlightId);
    this.service.searchScheduledFlight(scheduleFlightId).subscribe((scheduleflight:any)=>this.scheduleflight=scheduleflight);
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
