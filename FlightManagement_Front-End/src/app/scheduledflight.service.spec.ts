import { TestBed } from '@angular/core/testing';

import { ScheduledflightService } from './scheduledflight.service';

describe('ScheduledflightService', () => {
  let service: ScheduledflightService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScheduledflightService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
