import { Injectable } from '@angular/core';
import { Router, CanActivate,ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthenticationService } from './authentication.service';



@Injectable({
  providedIn: 'root'
})
export class AuthguardService  implements CanActivate  {

  constructor(private router: Router, private authSerivce: AuthenticationService) { }

  // Routes to error page if user is not logged in
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if(this.authSerivce.isUserLoggedIn()) {
       // logged in so return true
      return true;
    }
     // not logged in so redirect to login page with the return url
    this.router.navigate(['/login']);
    return false;
  }
}