import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Game } from 'src/app/model/Game';
import { UpdateGameDialogComponent } from '../update-game-dialog/update-game-dialog.component';
import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';
registerLocaleData(localeFr, 'fr');

@Component({
  selector: 'app-game-item',
  templateUrl: './game-item.component.html',
  styleUrls: ['./game-item.component.css']
})
export class GameItemComponent implements OnInit {
  @Input() game!: Game;

  constructor(private dialog: MatDialog) { }

  ngOnInit(): void {
  }

  openModifyGameDialog(): void {
    const dialogRef = this.dialog.open(UpdateGameDialogComponent, {
      width: '500px',
      data: this.game
    });
  }

  deleteGame(): void {}
}
