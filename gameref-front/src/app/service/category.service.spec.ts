import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { inject, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { Category } from '../model/Category';

import { CategoryService } from './category.service';

describe('CategoryService', () => {
  let categoryService: CategoryService;
  let httpClientSpy: jasmine.SpyObj<HttpClient>;

  beforeEach(() => {
    // TODO: spy on other methods too
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    categoryService = new CategoryService(httpClientSpy);
    TestBed.configureTestingModule({
       providers: [CategoryService]
    });

  });

  it('should be created', () => {
    expect(categoryService).toBeTruthy();
  }); 

  

  it('Le service est bien injecté', inject([CategoryService],
    (categoryService: CategoryService) => {
        expect(categoryService).toBeTruthy();
    }));


 
it('should return expected categories (HttpClient called once)', (done: DoneFn) => {

  const expectedcategories: Category[] =
    [{ id: 1, name: 'Aventure'}, { id: 2, name: 'Fps'},{ id: 3, name: 'Metroidvania'},
    { id: 4, name: 'Rogue-like'}, { id: 5, name: 'RPG'},{ id: 5, name: 'RPG'},
    { id: 6, name: 'MmoRPG'}, { id: 7, name: 'Combat'},{ id: 8, name: 'Plateforme'},
    { id: 9, name: 'Bac à sable'}, { id: 10, name: 'Course'}
    ];

  httpClientSpy.get.and.returnValue(of(expectedcategories));

  categoryService.getCategories().subscribe({
    next: categories => {
      expect(categories)
        .withContext('expected categories')
        .toEqual(expectedcategories);
      done();
    },
    error: done.fail
  });
  expect(httpClientSpy.get.calls.count())
    .withContext('one call')
    .toBe(1);
});

it('should return an error when the server returns a 404', (done: DoneFn) => {

  const expectedcategories: Category[] =
  [{ id: 1, name: 'Aventure'}, { id: 2, name: 'Fps'},{ id: 3, name: 'Metroidvania'},
  { id: 4, name: 'Rogue-like'}, { id: 5, name: 'RPG'},{ id: 5, name: 'RPG'},
  { id: 6, name: 'MmoRPG'}, { id: 7, name: 'Combat'},{ id: 8, name: 'Plateforme'},
  { id: 9, name: 'Bac à sable'}, { id: 10, name: 'Course'}
  ];


  const errorResponse = new HttpErrorResponse({
    error: 'Not Found',
    status: 404, statusText: 'Not Found'
  });

  httpClientSpy.get.and.returnValue(of(errorResponse));

  categoryService.getCategoriesError().subscribe({
    next: expectedcategories => done.fail('expected an error, not categories'),
    error: error  => {
      expect(error.message).toContain('404 error');
      done();
    }
  });

});
  

})