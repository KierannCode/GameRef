import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Game } from 'src/app/model/Game';
import { UpdateGameDialogComponent } from '../update-game-dialog/update-game-dialog.component';
import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';
import { GameService } from 'src/app/service/game.service';
import { GameListComponent } from '../game-list/game-list.component';
registerLocaleData(localeFr, 'fr');

@Component({
  selector: 'app-game-item',
  templateUrl: './game-item.component.html',
  styleUrls: ['./game-item.component.css']
})
export class GameItemComponent implements OnInit {
  @Input() game!: Game;
  @Input() parent!: GameListComponent;
  
  constructor(private dialog: MatDialog, private gameService: GameService
    ) { }

  ngOnInit(): void {
  }

  openModifyGameDialog(): void {
    const dialogRef = this.dialog.open(UpdateGameDialogComponent, {
      width: '500px',
      data: this.game
    });
  }

  deleteGame(): void {
    this.gameService.delete(this.game.id).subscribe(() => this.parent.loadPage());
  }
}
