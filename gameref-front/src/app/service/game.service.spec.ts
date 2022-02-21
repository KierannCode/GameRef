import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { GameService } from './game.service';

describe('GameService', () => {
  let gameService: GameService;
  let httpClientSpy: jasmine.SpyObj<HttpClient>;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    gameService = new GameService(httpClientSpy);
    TestBed.configureTestingModule({
      providers: [GameService]
   });
  });

  it('should be created', () => {
    expect(gameService).toBeTruthy();
  });
});
