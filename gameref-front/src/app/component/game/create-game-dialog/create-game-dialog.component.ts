import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

import { MatDialogRef } from '@angular/material/dialog';
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

  public gameDto: GameDto = {};

  public editors!: Array<Editor>;
  public ageRatings!: Array<AgeRating>;
  public platforms!: Array<Platform>;
  public categories!: Array<Category>;
  public economicModels!: Array<EconomicModel>;

  public errorMap: Map<string, Array<string>> = new Map();

  constructor(private gameService: GameService,
    private editorService: EditorService,
    private ageRatingService: AgeRatingService,
    private platformService: PlatformService,
    private categoryService: CategoryService,
    private economicModelService: EconomicModelService,
    public dialogRef: MatDialogRef<CreateGameDialogComponent>) {

    this.editorService.getEditors().subscribe(val => this.editors = val);
    this.platformService.getPlatforms().subscribe(val => this.platforms = val);
    this.categoryService.getCategories().subscribe(val => this.categories = val);
    this.economicModelService.getEconomicModels().subscribe(val => this.economicModels = val);
    this.ageRatingService.getAgeRatings().subscribe(val => this.ageRatings = val);
  }

  ngOnInit(): void {
  }

  closeDialog(): void {
    this.dialogRef.close();
  }

  onSubmit(): void {
    this.gameService.create(this.gameDto)
      .subscribe({
        next: () => {
          this.closeDialog();
        },
        error: (response: HttpErrorResponse) => this.errorMap = new Map(Object.entries(response.error))
      });
  }
}




