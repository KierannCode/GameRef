import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { EconomicModel } from '../model/EconomicModel';

import { EconomicModelService } from './economic-model.service';


describe('EconomicModelService', () => {
  let economicModelService: EconomicModelService;
  let httpClientSpy: jasmine.SpyObj<HttpClient>;

  beforeEach(() => {
    // TODO: spy on other methods too
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    economicModelService = new EconomicModelService(httpClientSpy);
  });

  it('should be created', () => {
    expect(economicModelService).toBeTruthy();
  }); 

it('should return expected economicsModels (HttpClient called once)', (done: DoneFn) => {

  const expectedeconomicModels: EconomicModel[] =
    [{ id: 1, name: 'Free to play' }, 
    { id: 2, name: 'Buy to play' },
    { id: 3, name: 'Abonnement' }
  ];

  httpClientSpy.get.and.returnValue(of(expectedeconomicModels));

  economicModelService.getEconomicModels().subscribe({
    next: economicsModels => {
      expect(economicsModels)
        .withContext('expected economicsModels')
        .toEqual(expectedeconomicModels);
      done();
    },
    error: done.fail
  });
  expect(httpClientSpy.get.calls.count())
    .withContext('one call')
    .toBe(1);
});

it('should return an error when the server returns a 404', (done: DoneFn) => {
  const errorResponse = new HttpErrorResponse({
    error: 'test 404 error',
    status: 404, statusText: 'Not Found'
  });

  httpClientSpy.get.and.returnValue(of(errorResponse));

  economicModelService.getEconomicModels().subscribe({
    next: _ageRatings => done.fail('expected an error, not economicModels'),
    error: error  => {
      expect(error.message).toContain('test 404 error');
      done();
    }
  });

});
  

})













