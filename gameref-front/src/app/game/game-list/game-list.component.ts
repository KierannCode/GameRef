import { Component, Injectable, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PageEvent } from '@angular/material/paginator';
import { Game } from 'src/app/model/Game';
import { GameService } from 'src/app/service/game.service';
import { CreateGameDialogComponent } from '../create-game-dialog/create-game-dialog.component';

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.css']
})
@Injectable({
  providedIn: 'root'
})
export class GameListComponent implements OnInit {

  games!: Array<Game>;
  totalElements!: number;

  constructor(private dialog: MatDialog, private gameService: GameService) {
    this.loadPage();
  }

  ngOnInit(): void {
  }

  openCreateGameDialog(): void {
    const dialogRef = this.dialog.open(CreateGameDialogComponent, {
      width: '450px',
      data: {},
    });
  }

  loadPage(): void {
    this.gameService.getGames().subscribe(val => {
      this.games = val.content;
      this.totalElements = val.totalElements;
      console.log(this.games);
    });
  }

  nextPage(event: PageEvent) {
    this.gameService.getGames(event.pageIndex).subscribe(val => {this.games = val.content;
      console.log(this.games);
    });
  }
}
