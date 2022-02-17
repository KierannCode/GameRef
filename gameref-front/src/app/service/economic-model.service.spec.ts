import { TestBed } from '@angular/core/testing';

import { EconomicModelService } from './economic-model.service';

describe('EconomicModelService', () => {
  let service: EconomicModelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EconomicModelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
