import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Users } from './users';

import { BehaviorSubject, map, Observable, of } from 'rxjs';




//Description: Performs Authentication and user management operations



@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() {}

  public setRoles(roles: []) {
    localStorage.setItem('roles', JSON.stringify(roles));
  }

  public getRoles(): [] {
    return JSON.parse(localStorage.getItem('roles')|| 'null'); 
  }

  public setToken(jwtToken: string) {
    localStorage.setItem('jwtToken', jwtToken);
  }

  public getToken(): string {
    return localStorage.getItem('jwtToken')|| 'null' ;
  }
 
  public clear() {
 sessionStorage.removeItem('userName');
    localStorage.clear();
  }

  public isLoggedIn() {
    return this.getRoles() && this.getToken();
    // let user = sessionStorage.getItem('this.getRoles() && this.getToken()')
    // return !(user === null)
  }





















//   private currentUserSubject: BehaviorSubject<any>;
//   public currentUser: Observable<any>;
// private baseUrl:  string ='http://localhost:8080/user';


// isLogin = false;
    
// roleAs: any;


//   constructor(private httpClient: HttpClient) 
//   {
//     this.currentUserSubject = new BehaviorSubject<any> (JSON.parse(localStorage.getItem('currentUser') || '{}'));
//     this.currentUser = this.currentUserSubject.asObservable();
//    }

//    public get currentUserValue(): any {    //:User
//     return this.currentUserSubject.value;
//   }
//   //Retrieves user token and checks authentication
//   authenticate(userName:any, userPassword:any) {

//     return this.httpClient.post<any>('http://localhost:8080/authenticate',
//     {userName, userPassword}).subscribe(
//       userData => {
//         sessionStorage.setItem('username', userName);
//         let tokenStr = 'Bearer' +userData.token;
//         sessionStorage.setItem('token', tokenStr);
//         return userData;
//       }
//     );
//   }


//   login(value: string) {
//     this.isLogin = true;
//     this.roleAs = value;
//     localStorage.setItem('STATE', 'true');
//     localStorage.setItem('ROLE', this.roleAs);
//     return of({ success: this.isLogin, role: this.roleAs });
//   }


  
//   login1(username:string,password:string):Observable<any>{
//     return this.httpClient.post('http://localhost:8080/users/login',{username,password})
//   }



//   //Retrieves user token and checks authentication
//   // authenticate1(username: string, password: string) {
//   //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    
//   //   let url = this.baseUrl + '/login';
//   //   const data = {
//   //     username,
//   //     password
//   //   };

//   //   return this.httpClient.post<any>(url, data, { headers }).pipe(
//   //     map(user => {
//   //       localStorage.setItem('currentUser', JSON.stringify(user));
//   //       this.currentUserSubject.next(user);
//   //       return user;
//   //     })
//   //   );
//   // }

//   isLoggedIn() {
//     const loggedIn = localStorage.getItem('STATE');
//     if (loggedIn == 'true')
//       this.isLogin = true;
//     else
//       this.isLogin = false;
//     return this.isLogin;
//   }

//   // Checks whether the user is logged in
//   isUserLoggedIn():boolean {
//     let user = sessionStorage.getItem('userName')
//     console.log(!(user===null))
//     return !(user === null)
//   }
//   GetUserrole() {
//    return sessionStorage.getItem('userrole')!=null?sessionStorage.getItem('userole')?.toString(): '';
    
//   }
//   // Removes user session(logout)
//   logOut() {
//     sessionStorage.removeItem('userName');
//   }

//   Getall(){
//     return this.httpClient.get(this. baseUrl);
//   }
 
//   GetUserbyCode(id:any){
//     return this.httpClient.get(this.baseUrl+'/'+id);
//   }
 
//   getuserList(): Observable<any> {

//     return this.httpClient.get(`${this.baseUrl}` + '/readAllUsers ');

//   }
//   // Retrives role of user(customer/admin)
//   getRole1(username:String) {
//     return this.httpClient.get('http://localhost:8080/user'+ username);
//   }
//   getRole() {
//     this.roleAs = localStorage.getItem('ROLE');
//     return this.roleAs;
//   }

//   // Adds a new User
//   signUp(user: Users) {
//     return this.httpClient.post(this.baseUrl+"/signup", user);
//   }







}
