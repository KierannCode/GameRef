import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { AgeRating } from '../model/AgeRating';

import { AgeRatingService } from './age-rating.service';

describe('AgeRatingService', () => {
  let ageRatingservice: AgeRatingService;
  let httpClientSpy: jasmine.SpyObj<HttpClient>;

  beforeEach(() => {
    // TODO: spy on other methods too
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    ageRatingservice = new AgeRatingService(httpClientSpy);
  });

  it('should be created', () => {
    expect(ageRatingservice).toBeTruthy();
  }); 


  
it('should return expected ageRatings (HttpClient called once)', (done: DoneFn) => {
  
  const expectedAgeRatings: AgeRating[] =
    [{ id: 1, name: 'PEGI 3'}, { id: 2, name: 'PEGI 7'},{ id: 3, name: 'PEGI 12'},
    { id: 4, name: 'PEGI 16'}, { id: 5, name: 'PEGI 18'}
    ];

  httpClientSpy.get.and.returnValue(of(expectedAgeRatings));

  ageRatingservice.getAgeRatings().subscribe({
    next: ageRatings => {
      expect(ageRatings)
        .withContext('expected ageRatings')
        .toEqual(expectedAgeRatings);
      done();
    },
    error: done.fail
  });
  expect(httpClientSpy.get.calls.count())
    .withContext('one call')
    .toBe(1);
});
 

})