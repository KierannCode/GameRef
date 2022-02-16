import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes} from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MenuPrincipalComponent } from './menu-principal/menu-principal.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ReviewListComponent } from './review/review-list/review-list.component';
import { ReviewItemComponent } from './review/review-item/review-item.component';
import { GameItemComponent } from './game/game-item/game-item.component';

const routes: Routes = [
  { path: '', component: LoginComponent },  // ce qui correspond http://localhost:4200
  { path: 'avis', component: ReviewListComponent },   // ce qui correspond http://localhost:4200/avis
  { path: 'jeux' , component: GameListComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    MenuPrincipalComponent,
    LoginComponent,
    NavbarComponent,
    ReviewListComponent,
    ReviewItemComponent,
    GameItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
    RouterModule.forRoot(routes)
    

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
