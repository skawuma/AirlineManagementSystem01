import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  buttonFlag: any;
  username:any;
  user:any;
  admin:any;


  constructor(private loginServive:AuthenticationService) { }

  ngOnInit() {


    this.user=false;
    this.admin= false;
    if(sessionStorage.getItem('role')=='user'){
      this.user = true;
    }else if(sessionStorage.getItem('role')=='admin'){
      this.admin=true;
    }
    this.username=sessionStorage.getItem('username');
    if(this.username!=null)
    this.username=this.username.toUpperCase();

    }
    logout(){
sessionStorage.removeItem('userid');
sessionStorage.removeItem('user');
sessionStorage.removeItem('adminid');
sessionStorage.removeItem('admin');
    }
  

}
