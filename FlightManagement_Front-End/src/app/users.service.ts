import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';
import { Users } from './users';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private baseUrl='http://localhost:8080';

  requestHeader = new HttpHeaders({ 'No-Auth': 'True' });

  constructor(private http: HttpClient,
    private authAuthservice: AuthenticationService
  
    )
  { }

  createUser(user: object): Observable<Object>{
    return this.http.post(`${this.baseUrl}/addUser`, user);
  }

  updateUser(user: object): Observable<Object>{
    return this.http.put(`${this.baseUrl}/updateUser/`, user);
  }

  deleteUser(id: number): Observable<any>{
    return this.http.delete(`${this.baseUrl}/deleteUser/${id}`,{ responseType: 'text'});
  }

  getUser(userId: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/searchUser/${userId}`);
  }

  getUserList(): Observable<any>{
    return this.http.get(`${this.baseUrl}/readAllUsers`)

  }

  public login(loginData: any) {
    return this.http.post(this.baseUrl + '/authenticate', loginData, {
      headers: this.requestHeader,
    });
  }

  public forUser() {
    return this.http.get(this.baseUrl + '/forUser', {
      responseType: 'text',
    });
  }


  public forAdmin() {
    return this.http.get(this.baseUrl + '/forAdmin', {
      responseType: 'text',
    });
  }

  public roleMatch(allowedRoles:any): boolean {
    let isMatch = false;
    const userRoles: any = this.authAuthservice.getRoles();

    if (userRoles != null && userRoles) {
      for (let i = 0; i < userRoles.length; i++) {
        for (let j = 0; j < allowedRoles.length; j++) {
          if (userRoles[i].roleName === allowedRoles[j]) {
            isMatch = true;
            return isMatch;
          } else {
            return isMatch;
          }
        }
      }
    }
    
    return isMatch;
  }
}
