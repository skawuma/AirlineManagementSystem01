import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAirportComponent } from './create-airport.component';

describe('CreateAirportComponent', () => {
  let component: CreateAirportComponent;
  let fixture: ComponentFixture<CreateAirportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateAirportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateAirportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
