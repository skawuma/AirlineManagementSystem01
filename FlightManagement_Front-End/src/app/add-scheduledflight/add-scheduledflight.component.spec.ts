import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddScheduledflightComponent } from './add-scheduledflight.component';

describe('AddScheduledflightComponent', () => {
  let component: AddScheduledflightComponent;
  let fixture: ComponentFixture<AddScheduledflightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddScheduledflightComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddScheduledflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
