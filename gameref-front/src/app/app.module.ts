import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';
import { GameListComponent } from './game/game-list/game-list.component';
import { CreateGameDialogComponent } from './game/create-game-dialog/create-game-dialog.component';
import { LoginComponent } from './login/login.component';
import { ReviewListComponent } from './review/review-list/review-list.component';
import { HttpClientModule } from '@angular/common/http'
import { GameItemComponent } from './game/game-item/game-item.component';
import { MatCardModule } from '@angular/material/card';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatPaginatorModule }from '@angular/material/paginator';
import { UpdateGameDialogComponent } from './game/update-game-dialog/update-game-dialog.component';
import { NavbarComponent } from './navbar/navbar.component';


const routes: Routes = [
  { path: '', component: LoginComponent },  // ce qui correspond http://localhost:4200
  { path: 'avis', component: ReviewListComponent },   // ce qui correspond http://localhost:4200/avis
  { path: 'jeux', component: GameListComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ReviewListComponent,
    LoginComponent,
    GameListComponent,
    GameItemComponent,
    CreateGameDialogComponent,
    UpdateGameDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
    MatFormFieldModule,
    MatInputModule,
    MatDialogModule,
    MatCardModule,
    MatSelectModule,
    MatSidenavModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatPaginatorModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
