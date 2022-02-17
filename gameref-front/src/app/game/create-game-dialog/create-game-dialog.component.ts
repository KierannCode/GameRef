import { Component, Inject, OnInit } from '@angular/core';

import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { GameService } from 'src/app/service/game.service';
import { Game } from '../../model/Game';

@Component({
  selector: 'app-create-game-dialog',
  templateUrl: './create-game-dialog.component.html',
  styleUrls: ['./create-game-dialog.component.css']
})
export class CreateGameDialogComponent {
  
  submitted = false ;
  constructor(private gameService: GameService,
    public dialogRef: MatDialogRef<CreateGameDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public game: Game,
  ) {}

  onClose(): void {
    this.dialogRef.close();
  }

  onSubmit():void {
    //console.log(`Envoi de la requête de création du jeu "${this.game.name}"`);
    const data = {
      id: this.game.id,
      name: this.game.name,
      description: this.game.description,
      releaseDate: this.game.releaseDate
    };
    this.gameService.create(data)
     .subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
      },
      error: (e) => console.error(e)
     });
  }

  
}