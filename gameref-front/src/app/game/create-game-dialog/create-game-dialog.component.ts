import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { GameData } from '../../model/GameData';

@Component({
  selector: 'app-create-game-dialog',
  templateUrl: './create-game-dialog.component.html',
  styleUrls: ['./create-game-dialog.component.css']
})
export class CreateGameDialogComponent {
  constructor(
    public dialogRef: MatDialogRef<CreateGameDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public game: GameData,
  ) {}

  onClose(): void {
    this.dialogRef.close();
  }

  onSubmit() {
    console.log(`Envoi de la requête de création du jeu "${this.game.name}"`);
  }
}