import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CreateGameDialogComponent } from '../create-game-dialog/create-game-dialog.component';

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.css']
})
export class GameListComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  openCreateGameDialog(): void {
    const dialogRef = this.dialog.open(CreateGameDialogComponent, {
      width: '250px',
      data: {},
    });
  }
}
