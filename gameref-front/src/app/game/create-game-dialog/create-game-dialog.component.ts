import { Component, Inject, OnInit } from '@angular/core';

import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { GameDto } from 'src/app/dto/GameDto';
import { AgeRating } from 'src/app/model/AgeRating';
import { Category } from 'src/app/model/Category';
import { EconomicModel } from 'src/app/model/EconomicModel';
import { Editor } from 'src/app/model/Editor';
import { Platform } from 'src/app/model/Platform';
import { AgeRatingService } from 'src/app/service/age-rating.service';
import { CategoryService } from 'src/app/service/category.service';
import { EconomicModelService } from 'src/app/service/economic-model.service';
import { EditorService } from 'src/app/service/editor.service';
import { GameService } from 'src/app/service/game.service';
import { PlatformService } from 'src/app/service/platform.service';

@Component({
  selector: 'app-create-game-dialog',
  templateUrl: './create-game-dialog.component.html',
  styleUrls: ['./create-game-dialog.component.css']
})
export class CreateGameDialogComponent implements OnInit {

  ageratings?: AgeRating[];
  editors?: Editor[];
  categories?: Category[];
  economicModels? : EconomicModel[];
  platforms? : Platform[];
  
  submitted = false ;

  constructor(private gameService: GameService,
    private editorService : EditorService,
    private categoryService : CategoryService,
    private ageRatingService : AgeRatingService,
    private economicModelService : EconomicModelService,
    private platformService : PlatformService,
    public dialogRef: MatDialogRef<CreateGameDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public gamedto: GameDto
  ) {}

  ngOnInit(): void {
    this.listedesEditeurs();
    this.listedesCategories();
    this.listedesClassifications();
    this.listedesModelsEco();
    this.listedesPlatformes();
  }

  onClose(): void {
    this.dialogRef.close();
  }

  onSubmit():void {
    //console.log(`Envoi de la requête de création du jeu "${this.game.name}"`);
    
    this.gameService.create(this.gamedto)
     .subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
      },
      error: (e) => console.error(e)
     });
  }

  listedesEditeurs(): void{
    this.editorService.getEditors()
      .subscribe({
        next: (data) => {
          this.editors = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });

  }

  listedesPlatformes(): void {

    this.platformService.getPlatforms()
      .subscribe({
        next: (data) => {
          this.platforms = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });

  }

  listedesCategories(): void {
    this.categoryService.getCategories()
      .subscribe({
        next: (data) => {
          this.categories = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
    
  }

  listedesClassifications(): void {
    this.ageRatingService.getAgeRatings()
      .subscribe({
        next: (data) => {
          this.ageratings = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
    
  }

  listedesModelsEco(): void {
    this.economicModelService.getEconomicModels()
      .subscribe({
        next: (data) => {
          this.economicModels = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
    
  }

  
}




