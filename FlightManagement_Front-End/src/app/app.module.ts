import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddScheduledflightComponent } from './add-scheduledflight/add-scheduledflight.component';
import { AirportDetailsComponent } from './airport-details/airport-details.component';
import { AirportListComponent } from './airport-list/airport-list.component';
import { BookingConfirmedComponent } from './booking-confirmed/booking-confirmed.component';
import { BookingDetailsComponent } from './booking-details/booking-details.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { CreateAirportComponent } from './create-airport/create-airport.component';
import { CreateBookingComponent } from './create-booking/create-booking.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { ListUserComponent } from './list-user/list-user.component';
import { LogoutComponent } from './logout/logout.component';
import { ModelComponent } from './model/model.component';
import { ModifyScheduledflightComponent } from './modify-scheduledflight/modify-scheduledflight.component';
import { SearchScheduledflightComponent } from './search-scheduledflight/search-scheduledflight.component';
import { ServicesComponent } from './services/services.component';
import { ShowScheduledflightsComponent } from './show-scheduledflights/show-scheduledflights.component';
import { SignupComponent } from './signup/signup.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { UpdateBookingComponent } from './update-booking/update-booking.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { WelcomeAdminComponent } from './welcome-admin/welcome-admin.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgToastModule } from 'ng-angular-popup';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from 'src/material.module';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    AppComponent,
    
    AddScheduledflightComponent,
    AirportDetailsComponent,
    AirportListComponent,
    BookingConfirmedComponent,
    BookingDetailsComponent,
    BookingListComponent,
    CreateAirportComponent,
    CreateBookingComponent,
    CreateFlightComponent,
    CreateUserComponent,
    FlightDetailsComponent,
    FlightListComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    ListUserComponent,
    LoginComponent,
    LogoutComponent,
    ModelComponent,
    ModifyScheduledflightComponent,
    SearchScheduledflightComponent,
    ServicesComponent,
    ShowScheduledflightsComponent,
    SignupComponent,
    UpdateAirportComponent,
    UpdateBookingComponent,
    UpdateFlightComponent,
    UpdateUserComponent,
    UserDetailsComponent,
    WelcomeAdminComponent,
    ForbiddenComponent,
   

  ],
  imports: [
    BrowserModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    NgToastModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    RouterModule
  ],
  providers: [
   

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
