import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Game } from 'src/app/model/Game';
import { GameService } from 'src/app/service/game.service';
import { CreateGameDialogComponent } from '../create-game-dialog/create-game-dialog.component';

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.css']
})
export class GameListComponent implements OnInit {

  games!: Array<Game>;

  constructor(private dialog: MatDialog, private gameService: GameService) { }

  ngOnInit(): void {
    this.gameService.getGames().subscribe(val => {this.games = val;
      console.log(this.games);
    });
  }

  openCreateGameDialog(): void {
    const dialogRef = this.dialog.open(CreateGameDialogComponent, {
      width: '250px',
      data: {},
    });
  }
}
