import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Scheduledflight } from '../scheduledflight';
import { ScheduledflightService } from '../scheduledflight.service';

@Component({
  selector: 'app-add-scheduledflight',
  templateUrl: './add-scheduledflight.component.html',
  styleUrls: ['./add-scheduledflight.component.css']
})
export class AddScheduledflightComponent implements OnInit {

  srcAirport:any
  dstnAirport:any
  deptDateTime:any
  arrDateTime:any


  scheduleFlight:Scheduledflight={scheduleFlightId:null, availableSeats:null, flight:null,schedule:null};

  constructor(private scheduleflightService: ScheduledflightService, private router: Router, private route: ActivatedRoute) {

  }

  ngOnInit(): void {
  }

  addScheduleFlight(scheduleFlight: any,sa: any,da: any,ddt: any,adt: any){
   // alert(sa+da+ ddt+ adt);
    this.srcAirport=sa;
    this.dstnAirport=da;
    this.deptDateTime=ddt;
    this.arrDateTime=adt;
    this.scheduleflightService.addScheduleFlight( scheduleFlight,sa,da,ddt,adt).subscribe();
    alert("Schedule Flight added");
  }

  idValid:boolean=false;
    validateId(){
        if(this.scheduleFlight.scheduleFlightId>999){
            this.idValid=true;
        }
        else if(this.scheduleFlight.scheduleFlightId<1){
            this.idValid=true;
        }else{
            this.idValid=false;
        }
    }

  airportValid:boolean=false;
    validateAirports(a:string, b:string){
        if(a.toLowerCase()===b.toLowerCase()){
            this.airportValid=true;
        }else{
            this.airportValid=false;
        }
        this.enableButton();
  }

  buttonFlag:boolean=false;
    enableButton(){
        this.buttonFlag=!this.idValid&&!this.airportValid;
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
