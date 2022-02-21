
import { HttpClient } from '@angular/common/http';
import { inject, TestBed } from '@angular/core/testing';


import { UserService } from './user.service';

describe('UserService', () => {
  let service: UserService;
  let httpClientSpy: jasmine.SpyObj<HttpClient>;
  
 
  beforeEach(() => {
    TestBed.configureTestingModule({});
    //service = TestBed.inject(UserService);
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    service = new UserService(httpClientSpy);
    TestBed.configureTestingModule({
      providers: [UserService]
   });
  }); 



  it('Le service est bien injecté', inject([UserService],
    (service: UserService) => {
        expect(service).toBeTruthy();
    }));




  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
