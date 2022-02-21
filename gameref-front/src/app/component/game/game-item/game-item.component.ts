import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Game } from 'src/app/model/Game';
import { UpdateGameDialogComponent } from '../update-game-dialog/update-game-dialog.component';
import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';
import { GameService } from 'src/app/service/game.service';
import { GameListComponent } from '../game-list/game-list.component';
import { User } from 'src/app/model/User';
import { CreateReviewDialogComponent } from '../../review/create-review-dialog/create-review-dialog.component';
registerLocaleData(localeFr, 'fr');

@Component({
  selector: 'app-game-item',
  templateUrl: './game-item.component.html',
  styleUrls: ['./game-item.component.css']
})
export class GameItemComponent implements OnInit {
  @Input() game!: Game;

  @Input() user!: User;
  
  constructor(private dialog: MatDialog, private gameService: GameService, private parent: GameListComponent) { }

  ngOnInit(): void {
  }

  openModifyGameDialog(): void {
    this.dialog.open(UpdateGameDialogComponent, {
      width: '500px',
      data: this.game
    });
  }

  openCreateReviewDialog(): void {
    this.dialog.open(CreateReviewDialogComponent, {
      width: '500px',
      data: {gameId: this.game.id}
    });
  }

  deleteGame(): void {
    this.gameService.delete(this.game.id).subscribe(() => this.parent.loadPage());
  }
}
