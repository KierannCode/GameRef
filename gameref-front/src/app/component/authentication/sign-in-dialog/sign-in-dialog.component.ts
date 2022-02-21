import { HttpErrorResponse } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PlayerDto } from 'src/app/dto/PlayerDto';
import { UserDto } from 'src/app/dto/UserDto';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-sign-in-dialog',
  templateUrl: './sign-in-dialog.component.html',
  styleUrls: ['./sign-in-dialog.component.css']
})
export class SignInDialogComponent implements OnInit {
  playerDto: PlayerDto = {};

  errorMap: Map<string, Array<string>> = new Map();

  constructor(private userService: UserService,
    private dialogRef: MatDialogRef<SignInDialogComponent>,
    @Inject(MAT_DIALOG_DATA) private loginDto: UserDto) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.userService.signIn(this.playerDto).subscribe({
      next: user => {
        this.loginDto.pseudo = user.pseudo;
        this.loginDto.password = '';
        this.closeDialog();
      }, error: (response: HttpErrorResponse) => this.errorMap = new Map(Object.entries(response.error))
    });
  }

  closeDialog(): void {
    this.dialogRef.close();
  }
}
