import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Scheduledflight } from './scheduledflight';

@Injectable({
  providedIn: 'root'
})
export class ScheduledflightService {

  private SFurl: any;
  constructor(private http: HttpClient) { 
  }

  addScheduleFlight(scheduleFlight:Scheduledflight,srcAirport:any,dstnAirport: any,deptDateTime: any,arrDateTime:any){
    let form=new FormData();
    form.append("scheduleFlightId", String(scheduleFlight.scheduleFlightId))
    form.append("availableSeats",String(scheduleFlight.availableSeats))
    form.append("flight",String(scheduleFlight.flight))
    form.append("schedule",String(scheduleFlight.schedule));
    let params = new HttpParams()
    .set('srcAirport', srcAirport)
    .set('dstnAirport', dstnAirport)
    .set('deptDateTime', deptDateTime)
    .set('arrDateTime', arrDateTime);
    console.log(scheduleFlight);
    console.log(params.toString());
   // console.log(form);
    return this.http.post('http://localhost:8080/scheduledFlight/add?',form,{params});
  }

  searchScheduledFlight(scheduledFlightId: number) {
    return this.http.get('http://localhost:8080/scheduledFlight/search?flightId='+scheduledFlightId);
  }

  showScheduleFlights(): Observable<any> {
    return this.http.get('http://localhost:8080/scheduledFlight/viewAll');
  }

  removeScheduleFlight(scheduleFlightId:number){
    return this.http.delete('http://localhost:8080/scheduledFlight/delete?flightId='+scheduleFlightId);
 }

 modifyScheduledFlight(scheduleFlight:Scheduledflight){
   let mForm= new FormData();
   mForm.append("scheduleFlightId",String(scheduleFlight.scheduleFlightId))
   mForm.append("schedule",String(scheduleFlight.schedule))
   mForm.append("flight",String(scheduleFlight.flight))
   mForm.append("availableSeats",String(scheduleFlight.availableSeats))
   return this.http.put('http://localhost:8080/scheduledFlight/modify?',mForm);
 }




 
}
