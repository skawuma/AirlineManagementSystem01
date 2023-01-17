import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyScheduledflightComponent } from './modify-scheduledflight.component';

describe('ModifyScheduledflightComponent', () => {
  let component: ModifyScheduledflightComponent;
  let fixture: ComponentFixture<ModifyScheduledflightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyScheduledflightComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifyScheduledflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
