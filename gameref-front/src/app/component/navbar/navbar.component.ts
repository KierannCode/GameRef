import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';
import { User } from 'src/app/model/User';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  user!: User;

  constructor(private breakpointObserver: BreakpointObserver,
    private router: Router,
    public userService: UserService) {
    userService.getSessionUser().subscribe({
      next: user => this.user = user,
      error: () => router.navigate([''])
    });
  }

  logout(): void {
    this.userService.logout().subscribe(() => this.router.navigate(['']));
  }
}
