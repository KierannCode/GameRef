import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Router } from '@angular/router';

import { GameListComponent } from './game-list.component';

describe('GameListComponent', () => {
  let component: GameListComponent;
  let fixture: ComponentFixture<GameListComponent>;
  const routerSpy = jasmine.createSpyObj('Router', ['navigateByUrl']);


  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GameListComponent ],
      providers: [
        {
          provide: Router, useValue: routerSpy
        }
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GameListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });


it('should navigate to GameList page', () => {      
  //component.openCreateGameDialog();
  const navArgs = routerSpy.navigateByUrl.calls.first.args[1];
  console.log(navArgs);
  expect(navArgs).toEqual("/jeux");
});


it('should create', () => {
  expect(component).toBeTruthy();
});

});

