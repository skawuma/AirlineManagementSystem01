import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Users } from './users';

import { BehaviorSubject, map, Observable } from 'rxjs';




//Description: Performs Authentication and user management operations



@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private currentUserSubject: BehaviorSubject<any>;
  public currentUser: Observable<any>;
private baseUrl:  string ='http://localhost:8080/user';
  constructor(private httpClient: HttpClient) 
  {
    this.currentUserSubject = new BehaviorSubject<any> (JSON.parse(localStorage.getItem('currentUser') || '{}'));
    this.currentUser = this.currentUserSubject.asObservable();
   }

   public get currentUserValue(): any {    //:User
    return this.currentUserSubject.value;
  }
  //Retrieves user token and checks authentication
  authenticate(username: string, password: string) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let url = this.baseUrl + '/login';
    const data = {
      username,
      password
    };

    return this.httpClient.post<any>(url, data, { headers }).pipe(
      map(user => {
        localStorage.setItem('currentUser', JSON.stringify(user));
        this.currentUserSubject.next(user);
        return user;
      })
    );
  }

  // Checks whether the user is logged in
  isUserLoggedIn():boolean {
    let user = sessionStorage.getItem('userName')
    console.log(!(user===null))
    return !(user === null)
  }

  // Removes user session(logout)
  logOut() {
    sessionStorage.removeItem('userName');
  }
  getuserList(): Observable<any> {

    return this.httpClient.get(`${this.baseUrl}` + '/readAllUsers=');

  }
  // Retrives role of user(customer/admin)
  getRole(username:String) {
    return this.httpClient.get('http://localhost:8080/getRole?username='+ username);
  }

  // Adds a new User
  signUp(user: Users) {
    return this.httpClient.post(this.baseUrl+"/signup", user);
  }


}