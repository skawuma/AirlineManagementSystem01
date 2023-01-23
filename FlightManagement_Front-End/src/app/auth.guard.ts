import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router, private authSerivce: AuthenticationService,private toast:NgToastService){ }

  // Routes to error page if user is not logged in
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if(this.authSerivce.isUserLoggedIn()) {
       // logged in so return true
      return true;
    }
    //Give error  ifnotlogged in first
    this.toast.error({detail: "Error",summary: "Please Login First!"});
     // not logged in so redirect to login page with the return url
    this.router.navigate(['/login']);
    return false;
  }
}
