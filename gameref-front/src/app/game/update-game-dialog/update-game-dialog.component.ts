import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { GameDto } from 'src/app/dto/GameDto';
import { Editor } from 'src/app/model/Editor';
import { Game } from 'src/app/model/Game';
import { Platform } from 'src/app/model/Platform';
import { EditorService } from 'src/app/service/editor.service';
import { GameService } from 'src/app/service/game.service';
import { PlatformService } from 'src/app/service/platform.service';

@Component({
  selector: 'app-update-game-dialog',
  templateUrl: './update-game-dialog.component.html',
  styleUrls: ['./update-game-dialog.component.css']
})
export class UpdateGameDialogComponent implements OnInit {

  dto: GameDto = {};

  public gamePlatformIds!: Array<number>;

  public editors!: Array<Editor>;
  public platforms!: Array<Platform>;

  constructor(private gameService: GameService, private editorService: EditorService, private platformService: PlatformService,
    private dialogRef: MatDialogRef<UpdateGameDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public game: Game) {
      this.gamePlatformIds = game.platforms.map(platform => platform.id);

      this.editorService.getEditors().subscribe(val => this.editors = val);
      this.platformService.getPlatforms().subscribe(val => this.platforms = val);
      this.platforms=[{id:1, name:"ps1"}, {id:2, name:"ps2"}];
    }

  ngOnInit(): void {
  }

  onClose(): void {
    this.dialogRef.close();
  }

  onSubmit(): void {
    console.log('modifications enregistrées :');
    console.log(this.dto);
    this.gameService.updateGame(this.game.id, this.dto).subscribe(val => {
      Object.assign(this.game, val);
      this.dialogRef.close();
    });
  }
}
