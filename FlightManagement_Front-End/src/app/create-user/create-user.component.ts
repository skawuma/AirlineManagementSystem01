import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from '../users';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  user: Users = new Users();
  submitted=false;

  constructor(private userService: UsersService, private router: Router) { }

  ngOnInit(): void {
  }

    newUser(): void{
      this.submitted=false;
      this.user=new Users();
    }

    save(){
      this.userService.createUser(this.user).subscribe(data => console.log(data), error => console.log(error));
      this.user = new Users();
      this.gotoList();
    }

    onSubmit(){
      this.submitted=true;
      this.save();
    }

    gotoList(){
      this.router.navigate(['/addUser']);
    }
}
