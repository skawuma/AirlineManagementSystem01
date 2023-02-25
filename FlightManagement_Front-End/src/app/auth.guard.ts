import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, CanDeactivate, CanLoad, Route, Router, RouterStateSnapshot, UrlSegment, UrlTree } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';
import { UsersService } from './users.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router, private authSerivce: AuthenticationService,private toast:NgToastService,private userService:UsersService){ }

  // Routes to error page if user is not logged in
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.authSerivce.getToken() !== null) {
      const role = route.data['roles'] as Array<string>;

      if (role) {
        const match = this.userService.roleMatch(role);

        if (match) {
          return true;
        } else {
  
          this.router.navigate(['/forbidden']);
          return false;
        }
      }
    }
            // //Give error  ifnotlogged in first
            //this.toast.error({detail: "Error",summary: "Please Login First!"});
// not logged in so redirect to login page with the return url
    this.router.navigate(['/login']);
    return false;
  }

  // canActivateChild(
  //   next: ActivatedRouteSnapshot,
  //   state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
  //   return this.canActivate(next, state);
  // }


  // canDeactivate(
  //   component: unknown,
  //   currentRoute: ActivatedRouteSnapshot,
  //   currentState: RouterStateSnapshot,
  //   nextState?: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
  //   return true;
  // }
  // canLoad(
  //   route: Route,
  //   segments: UrlSegment[]): Observable<boolean> | Promise<boolean> | boolean {
  //   return true;
  // }


}
// if(this.authSerivce.isLoggedIn()) {
//   // logged in so return true
//  return true;
// }
// //Give error  ifnotlogged in first
// this.toast.error({detail: "Error",summary: "Please Login First!"});
// // not logged in so redirect to login page with the return url
// this.router.navigate(['/login']);
// return false;