import { Component, OnInit } from '@angular/core';

import { ActivatedRouteSnapshot, Router } from '@angular/router';

import { Users } from '../users';
import { AuthenticationService } from '../authentication.service';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  ack: any;
  // ack:any;
  // username = "";
  // password = '';
  //user: Users={"userId": 0, "userName":"", "userPassword":"", "userPhone": 0, "userEmail":"", "active": null, "role":""};
  //invalidLogin!: false;
 
 
  
  // invalidLogin = false;
  //  users:any;
  constructor(
    private authservice: AuthenticationService,
    private usersService: UsersService,
    private router:Router
    ) { }


    // profileForm = new FormGroup({
    //   username: new FormControl('', [Validators.required]),
    //   password: new FormControl('', [Validators.required])
    // });
    
    // get f(){
    //   return this.profileForm.controls;
    // }


  ngOnInit(): void {

  }
  login(loginForm: NgForm) {
    this.usersService.login(loginForm.value).subscribe(
      (response:any)=> {
        console.log(response)
       this.authservice.setRoles(response.user.role);
       this.authservice.setToken(response.jwtToken);
       
       const role = response.user.role[0].roleName;
       if(role === 'User') {

        sessionStorage.setItem('role', 'User');
         sessionStorage.setItem('userId', String(response.user.userId));
        this.ack = "Login Successful"
         //  this.invalidLogin = false;
         this.router.navigate(["/home"]);
        
       }
       else if(role === 'Admin') {// In Role Entity Use this naming convention for role_id
         sessionStorage.setItem('role', 'Admin');
          sessionStorage.setItem('userId', String(response.user.userId));
          this.ack = "Login Successful"
          //  this.invalidLogin = false;
         this.router.navigate(["/home"]);
       }

      }, 
      (error)=> {
        console.log(error);
      }
      
    );
  }

  // redirect() {

  // const role = this.user.role[0].roleName;
  //   if(role === 'User') {
  //     sessionStorage.setItem('role', 'user');
  //     sessionStorage.setItem('userId', String(this.user.userId));
  //     this.invalidLogin = false;
  //     this.router.navigate(["userpanel"]).then(()=> {
  //       window.location.reload();
  //     });
  //   }
  //   else if(role === 'Admin') {// In Role Entity Use this naming convention for role_id
  //     sessionStorage.setItem('role', 'admin');
  //     sessionStorage.setItem('userId', String(this.user.userId));
  //     this.invalidLogin = false;
  //     this.router.navigate(["adminpanel"]).then(()=> {
  //       window.location.reload();
  //     });
  //   }
  // }


  // checkUserLogin(route: ActivatedRouteSnapshot, url: any): boolean {
  //   if (this.loginservice.isLoggedIn()) {
  //     const userRole = this.loginservice.getRole();
  //     if (route.data['role'] && route.data['role'].indexOf(userRole) === -1) {
  //       this.router.navigate(['/home']);
  //       return false;
  //     }
  //     return true;
  //   }

  //   this.router.navigate(['/home']);
  //   return false;
  // }
  

  // // Check user for authenticatoin
  // checkLogin() {
  //   if(this.loginservice.authenticate(this.username, this.password)) { 
  //     this.loginservice.getRole1(this.username).subscribe((data:any)=> {
  //       this.user = data;
  //       this.redirect();
  //     });
  //   }
  //   else {
  //     console.log("Invalid Login Credentials..");
  //     this.invalidLogin = true;
  //   }
  // }

  // login1() {
  //   this.user.userName = this.f['username'].value; 
  //   this.user.userPassword = this.f['password'].value;
    
  //   if(this.user.userName!='' && this.user.userPassword !=null){
  //     this.loginservice.getuserList().subscribe(data=>{this.users=data;
  //       for(let i=0; i<data.length; i++){
  //         console.log(this.users)
  //         console.log(this.user)

  //         if(this.user.userName == this.users[i].userName && this.user.userPassword == this.users[i].userPassword){
  //           this.ack = "Login successful";
  //           //sessionStorage.setItem('custid', this.users[i].customerId);
  //          // sessionStorage.setItem('custname', this.users[i].fullName);
  //          // this.router.navigate(['/profile']);
  //          this.redirect();
  //         }
  //       }
  //     },error=>console.log(error));

  
  //   }

  // }

  // Redirect based on the user role

  // Us e this Link to refer to the role based and Authentication
  // https://www.youtube.com/watch?v=VZjs6-_yccw&t=6094s
  //focus on (>42:00)
  // redirect() {
  //   if(this.user.roles === 'ROLE_CUSTOMER') {
  //     sessionStorage.setItem('role', 'customer');
  //     sessionStorage.setItem('userId', String(this.user.userId));
  //     this.invalidLogin = false;
  //     this.router.navigate(["/userpanel"]).then(()=> {
  //       window.location.reload();
  //     });
  //   }
  //   else if(this.user.roles === 'ROLE_ADMIN') {// In Role Entity Use this naming convention for role_id
  //     sessionStorage.setItem('role', 'admin');
  //     sessionStorage.setItem('userId', String(this.user.userId));
  //     this.invalidLogin = false;
  //     this.router.navigate(["/adminpanel"]).then(()=> {
  //       window.location.reload();
  //     });
  //   }
  // }

}