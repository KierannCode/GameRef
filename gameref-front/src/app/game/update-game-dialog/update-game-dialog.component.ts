import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { GameDto } from 'src/app/dto/GameDto';
import { Game } from 'src/app/model/Game';
import { GameService } from 'src/app/service/game.service';

@Component({
  selector: 'app-update-game-dialog',
  templateUrl: './update-game-dialog.component.html',
  styleUrls: ['./update-game-dialog.component.css']
})
export class UpdateGameDialogComponent implements OnInit {

  dto: GameDto = {};

  constructor(private gameService: GameService,
    private dialogRef: MatDialogRef<UpdateGameDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public game: Game) { }

  ngOnInit(): void {
  }

  onClose(): void {
    this.dialogRef.close();
  }

  onSubmit(): void {
    console.log('modifications enregistrées :');
    console.log(this.dto);
    this.gameService.updateGame(this.game.id, this.dto).subscribe(val => console.log(val));
  }

  setName(event: Event) {
    this.dto.name = (event.target as HTMLInputElement).value;
  }
}
