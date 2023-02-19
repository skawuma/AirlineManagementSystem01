import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
// buttonFlag: any;
username: any;
  user: any;
  admin: any;
  constructor(
    private authAuthService: AuthenticationService,
    private router: Router,
    public userService: UsersService
  ) {}

  

  public isLoggedIn() {
    return this.authAuthService.isLoggedIn();
  }

  public logout() {
    this.authAuthService.clear();
    this.router.navigate(['/home']);
  }
  ngOnInit(){
    this.user=false;
    this.admin=false;
    if(sessionStorage.getItem('role')==='User'){
        this.user=true;
    }else if(sessionStorage.getItem('role')==='Admin'){
        this.admin=true;
    }
    // this.buttonFlag=this.authenticationService.isUserLoggedIn();
    this.username=sessionStorage.getItem('username');
    if(this.username!=null)
        this.username=this.username.toUpperCase();
}


}
