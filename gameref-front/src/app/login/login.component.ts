import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  pseudo!: string;
  password!: string;
  
  birthDate!: Date;
  email!: string;
  phoneNumber!: string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.userService.login(this.pseudo, this.password)
    .then(() => this.router.navigate(['nav/jeux']));
  }

  toggleForm():void {
    document.querySelectorAll('.toggle-form').forEach((el) => {
      el.classList.toggle('none');
    })
  }
}
