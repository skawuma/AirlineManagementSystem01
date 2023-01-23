import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

import { Users } from '../users';
import { AuthenticationService } from '../authentication.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  ack:any;
  username = 'admin';
  password = '';
  user: Users={"userId": 0, "userName":"", "userPassword":"", "userPhone": 0, "userEmail":"", "active": null, "roles":""};
  invalidLogin = false;
   users:any;
  constructor(private router: Router,
    private loginservice: AuthenticationService) { }


    profileForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    });
    
    get f(){
      return this.profileForm.controls;
    }


  ngOnInit(): void {
  }

  // Check user for authenticatoin
  checkLogin() {
    if(this.loginservice.authenticate(this.username, this.password)) {
      this.loginservice.getRole(this.username).subscribe((data)=> {
        this.users = data;
        this.redirect();
      });
    }
    else {
      console.log("Invalid Login Credentials..");
      this.invalidLogin = true;
    }
  }

  login() {
    this.user.userName = this.f['username'].value; 
    this.user.userPassword = this.f['password'].value;
    
    if(this.loginservice.authenticate(this.username, this.password)){
      this.loginservice.getuserList().subscribe(data=>{
        this.users=data;
        for(let i=0; i<data.length; i++){
          console.log(this.users)
          console.log(this.user)

          if(this.user.userName == this.users[i].userName && this.user.userPassword == this.users[i].password){
            this.ack = "Login successful";
            //sessionStorage.setItem('custid', this.users[i].customerId);
           // sessionStorage.setItem('custname', this.users[i].fullName);
           // this.router.navigate(['/profile']);
           this.redirect();
          }
        }
      },error=>console.log(error));

  
    }

  }

  // Redirect based on the user role
  redirect() {
    if(this.user.roles === 'ROLE_CUSTOMER') {
      sessionStorage.setItem('role', 'customer');
      sessionStorage.setItem('userId', String(this.user.userId));
      this.invalidLogin = false;
      this.router.navigate(["/userpanel"]).then(()=> {
        window.location.reload();
      });
    }
    else if(this.user.roles === 'ROLE_ADMIN') {
      sessionStorage.setItem('role', 'admin');
      sessionStorage.setItem('userId', String(this.user.userId));
      this.invalidLogin = false;
      this.router.navigate(["/adminpanel"]).then(()=> {
        window.location.reload();
      });
    }
  }

}