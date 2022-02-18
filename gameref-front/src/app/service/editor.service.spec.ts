import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { Editor } from '../model/Editor';

import { EditorService } from './editor.service';

describe('EditorService', () => {
  let editorservice: EditorService;
  let httpClientSpy: jasmine.SpyObj<HttpClient>

  beforeEach(() => {
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    editorservice = new EditorService(httpClientSpy);
  });

  it('should be created', () => {
    expect(editorservice).toBeTruthy();
  });

  it('should return expected editors (HttpClient called once)', (done: DoneFn) => {
    const expectedEditors: Editor[] =
      [{ id: 1, name: 'Epic games' }, { id: 2, name: 'Blizzard' },{ id: 3, name: 'Microsoft' }, { id: 4, name: 'Square Enix' },{ id: 5, name: 'Moon Studios'},
      { id: 6, name: 'Nintendo' }, { id: 7, name: 'Extremely OK Games' },{ id: 8, name: 'Mojang Studios' }, { id: 9, name: 'Team Cherry' },{ id: 10, name: 'Bandai Namco'}
    ];
  
    httpClientSpy.get.and.returnValue(of(expectedEditors));
  
    editorservice.getEditors().subscribe({
      next: editors => {
        expect(editors)
          .withContext('expected editors')
          .toEqual(expectedEditors);
        done();
      },
      error: done.fail
    });
    expect(httpClientSpy.get.calls.count())
      .withContext('one call')
      .toBe(1);
  });


});
