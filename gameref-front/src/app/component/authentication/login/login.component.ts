import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { UserDto } from 'src/app/dto/UserDto';
import { UserService } from '../../../service/user.service';
import { SignInDialogComponent } from '../sign-in-dialog/sign-in-dialog.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loginDto: UserDto = {};

  public errorMap: Map<string, Array<string>> = new Map();

  constructor(private dialog: MatDialog,
    private userService: UserService,
    private router: Router) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.userService.login(this.loginDto).subscribe({
      next: () => this.router.navigate(['avis']),
      error: (response: HttpErrorResponse) => this.errorMap = new Map(Object.entries(response.error))
    });
  }

  openSignInDialog(): void {
    const dialogRef = this.dialog.open(SignInDialogComponent, {
      width: '400px',
      data: this.loginDto
    });
  }
}
