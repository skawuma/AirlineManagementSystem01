import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';
import { Airport } from './airport';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AirportService {
private baseUrl = 'http://localhost:8080/api/aiport';
  constructor(private http:HttpClient) { }
  //Returns list of all airports
  getAllAirports():Observable<Airport[]>{
    return this.http.get<Airport[]>(`${this.baseUrl}/allAirport`);
}
viewAirport(airportCode: string): Observable<any> {
  return this.http.get(`${this.baseUrl}/viewAirport/${airportCode}`);
}

addAirport(airport: Object): Observable<Object> {
  return this.http.post(`${this.baseUrl}/addAirport`,airport);
}

modifyAirport(airportCode: string, value: any): Observable<Object> {
  return this.http.put(`${this.baseUrl}/updateAirport`, value);
}

removeAirport(airportCode: string): Observable<any> {
  return this.http.delete(`${this.baseUrl}/deleteAirport/${airportCode}`, { responseType: 'text' });
}

viewAllAirport(): Observable<any> {
  return this.http.get(`${this.baseUrl}/allAirport`);
}
}
