import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PasswordStrengthMeterModule } from 'angular-password-strength-meter';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { WelcomeAdminComponent } from './welcome-admin/welcome-admin.component';
import { AddScheduledflightComponent } from './add-scheduledflight/add-scheduledflight.component';
import { SearchScheduledflightComponent } from './search-scheduledflight/search-scheduledflight.component';
import { ShowScheduledflightsComponent } from './show-scheduledflights/show-scheduledflights.component';
import { ModifyScheduledflightComponent } from './modify-scheduledflight/modify-scheduledflight.component';
import { LogoutComponent } from './logout/logout.component';
import { AirportDetailsComponent } from './airport-details/airport-details.component';
import { AirportListComponent } from './airport-list/airport-list.component';
import { BookingDetailsComponent } from './booking-details/booking-details.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { CreateAirportComponent } from './create-airport/create-airport.component';
import { CreateBookingComponent } from './create-booking/create-booking.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { ListUserComponent } from './list-user/list-user.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { UpdateBookingComponent } from './update-booking/update-booking.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { WelcomeUserComponent } from './welcome-user/welcome-user.component';

const routes: Routes = [

  {path: '', redirectTo: 'booking',pathMatch: 'full'},
  {path: 'bookings', component: BookingListComponent},
  {path: 'addBooking', component: CreateBookingComponent},
  {path: 'updateBooking/:id', component: UpdateBookingComponent},
  {path: 'bookingDetails/:id', component: BookingDetailsComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'airports', component: AirportListComponent },
  {path: 'addAirport', component: CreateAirportComponent },
  {path: 'update/:airportCode', component: UpdateAirportComponent },
  {path: 'details/:airportCode', component: AirportDetailsComponent },
  {path: 'flights', component: FlightListComponent },
  {path: 'addFlight', component: CreateFlightComponent },
  {path: 'updateFlight/:flightNo', component: UpdateFlightComponent },
  {path: 'flightDetails/:flightNo', component: FlightDetailsComponent },
  {path: 'scheduledFlight/add', component:AddScheduledflightComponent},
  {path: 'scheduledFlight/show', component:ShowScheduledflightsComponent},
  {path: 'scheduledFlight/search', component:SearchScheduledflightComponent},
  {path: 'welcomeAdmin', component:WelcomeAdminComponent},
  {path: 'scheduledFlight/modify', component: ModifyScheduledflightComponent},
  {path: 'addUser', component: CreateUserComponent},
  {path: 'updateUser/:id', component: UpdateUserComponent},
  {path: 'userDetails/:id', component: UserDetailsComponent},
  {path: 'users', component: ListUserComponent},
  {path: 'welcomeUser',component:WelcomeUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), PasswordStrengthMeterModule.forRoot()],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents= [
  AddScheduledflightComponent,
  SearchScheduledflightComponent,
  ShowScheduledflightsComponent,
  WelcomeAdminComponent,
  ModifyScheduledflightComponent
]