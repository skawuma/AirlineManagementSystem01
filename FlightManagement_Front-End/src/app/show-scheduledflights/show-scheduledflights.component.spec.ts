import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowScheduledflightsComponent } from './show-scheduledflights.component';

describe('ShowScheduledflightsComponent', () => {
  let component: ShowScheduledflightsComponent;
  let fixture: ComponentFixture<ShowScheduledflightsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowScheduledflightsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowScheduledflightsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
