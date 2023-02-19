import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { WelcomeAdminComponent } from './welcome-admin/welcome-admin.component';

const routes: Routes = [

  {path: 'home', component: HomeComponent},
  {path: 'welcome-admin', component:WelcomeAdminComponent},
 // {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'login', component: LoginComponent}
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
