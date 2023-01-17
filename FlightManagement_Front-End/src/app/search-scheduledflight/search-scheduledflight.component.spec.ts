import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchScheduledflightComponent } from './search-scheduledflight.component';

describe('SearchScheduledflightComponent', () => {
  let component: SearchScheduledflightComponent;
  let fixture: ComponentFixture<SearchScheduledflightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchScheduledflightComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchScheduledflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
