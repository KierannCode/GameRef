import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { Platform } from '../model/Platform';

import { PlatformService } from './platform.service';

describe('PlatformService', () => {
  let service: PlatformService;
  let httpClientSpy: jasmine.SpyObj<HttpClient>

  beforeEach(() => {
   /* TestBed.configureTestingModule({});
    service = TestBed.inject(PlatformService); */
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    service = new PlatformService(httpClientSpy);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });


  it('should return expected platforms (HttpClient called once)', (done: DoneFn) => {
    const expectedPlatforms: Platform[] =
      [{ id: 1, name: 'Switch' }, { id: 2, name: 'Pc' },{ id: 3, name: 'Playstation' }, { id: 4, name: 'Xbox' },{ id: 5, name: 'Android' }
    ];
  
    httpClientSpy.get.and.returnValue(of(expectedPlatforms));
  
    service.getPlatforms().subscribe({
      next: platforms => {
        expect(platforms)
          .withContext('expected platforms')
          .toEqual(expectedPlatforms);
        done();
      },
      error: done.fail
    });
    expect(httpClientSpy.get.calls.count())
      .withContext('one call')
      .toBe(1);
  });


});
