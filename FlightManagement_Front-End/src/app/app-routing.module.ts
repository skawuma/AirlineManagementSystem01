import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PasswordStrengthMeterModule } from 'angular-password-strength-meter';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { WelcomeAdminComponent } from './welcome-admin/welcome-admin.component';

const routes: Routes = [

  {path: 'home', component: HomeComponent},
  {path: 'welcome-admin', component:WelcomeAdminComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes), PasswordStrengthMeterModule.forRoot()],
  exports: [RouterModule]
})
export class AppRoutingModule { }
