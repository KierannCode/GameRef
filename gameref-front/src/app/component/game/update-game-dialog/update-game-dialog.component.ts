import { HttpErrorResponse } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { GameDto } from 'src/app/dto/GameDto';
import { AgeRating } from 'src/app/model/AgeRating';
import { Category } from 'src/app/model/Category';
import { EconomicModel } from 'src/app/model/EconomicModel';
import { Editor } from 'src/app/model/Editor';
import { Game } from 'src/app/model/Game';
import { Platform } from 'src/app/model/Platform';
import { AgeRatingService } from 'src/app/service/age-rating.service';
import { CategoryService } from 'src/app/service/category.service';
import { EconomicModelService } from 'src/app/service/economic-model.service';
import { EditorService } from 'src/app/service/editor.service';
import { GameService } from 'src/app/service/game.service';
import { PlatformService } from 'src/app/service/platform.service';

@Component({
  selector: 'app-update-game-dialog',
  templateUrl: './update-game-dialog.component.html',
  styleUrls: ['./update-game-dialog.component.css']
})
export class UpdateGameDialogComponent implements OnInit {

  gameDto: GameDto = {};

  public gamePlatformIds!: Array<number>;

  public editors!: Array<Editor>;
  public platforms!: Array<Platform>;
  public categories!: Array<Category>;
  public economicModels!: Array<EconomicModel>;
  public ageRatings!: Array<AgeRating>;

  public errorMap: Map<string, Array<string>> = new Map();

  constructor(private gameService: GameService, private editorService: EditorService,
    private platformService: PlatformService, private categoryService: CategoryService,
    private economicModelService: EconomicModelService, private ageRatingService: AgeRatingService,
    private dialogRef: MatDialogRef<UpdateGameDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public game: Game) {
    this.gamePlatformIds = game.platforms.map(platform => platform.id);

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
    this.gameService.updateGame(this.game.id, this.gameDto).subscribe({
      next: val => {
        Object.assign(this.game, val);
        this.dialogRef.close();
      },
      error: (response: HttpErrorResponse) => this.errorMap = new Map(Object.entries(response.error))
    });
  }
}
