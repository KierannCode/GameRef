import { Component, Injectable, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PageEvent } from '@angular/material/paginator';
import { Game } from 'src/app/model/Game';
import { User } from 'src/app/model/User';
import { GameService } from 'src/app/service/game.service';
import { UserService } from 'src/app/service/user.service';
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

  games: Array<Game> = [];
  totalElements!: number;
  sort!: string;
  descending!: string;

  user!: User;

  constructor(private dialog: MatDialog,
    private gameService: GameService,
    userService: UserService) {
      userService.getSessionUser().subscribe(user => {
        this.user = user;
        this.loadPage();
      });
  }

  ngOnInit(): void {
  }

  openCreateGameDialog(): void {
    const dialogRef = this.dialog.open(CreateGameDialogComponent, {
      width: '450px',
      data: {},
    }).afterClosed()
    .subscribe(() => this.loadPage());
  }

  loadPage(): void {
    this.gameService.getGames().subscribe(val => {
      this.games = val.content;
      this.totalElements = val.totalElements;
      console.log(this.games);
    });
  }

  nextPage(event: PageEvent) {
    this.gameService.getGames(event.pageIndex).subscribe(val => {
      this.games = val.content;
      this.totalElements = val.totalElements;
    });
  }

  sortGames(): void {
    this.gameService.getGames(0, this.sort, this.descending).subscribe(val => {this.games = val.content;
      console.log(this.games);
    });
  }
}
