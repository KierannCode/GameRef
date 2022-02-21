import { AppComponent } from './app.component';
import { LoginComponent } from './component/authentication/login/login.component';
import { SignInDialogComponent } from './component/authentication/sign-in-dialog/sign-in-dialog.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { ReviewListComponent } from './component/review/review-list/review-list.component';
import { CreateReviewDialogComponent } from './component/review/create-review-dialog/create-review-dialog.component';
import { GameListComponent } from './component/game/game-list/game-list.component';
import { GameItemComponent } from './component/game/game-item/game-item.component';
import { CreateGameDialogComponent } from './component/game/create-game-dialog/create-game-dialog.component';
import { UpdateGameDialogComponent } from './component/game/update-game-dialog/update-game-dialog.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule } from '@angular/material/card';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatSliderModule } from '@angular/material/slider';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from '@angular/cdk/layout';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http'

const routes: Routes = [
  { path: '', component: LoginComponent },
  {
    path: 'avis', component: NavbarComponent, children: [{
      path: '', component: ReviewListComponent
    }]
  },
  {
    path: 'jeux', component: NavbarComponent, children: [{
      path: '', component: GameListComponent
    }]
  }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignInDialogComponent,
    NavbarComponent,
    ReviewListComponent,
    CreateReviewDialogComponent,
    GameListComponent,
    GameItemComponent,
    CreateGameDialogComponent,
    UpdateGameDialogComponent
  ],
  imports: [
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
    MatTableModule,
    MatSliderModule,
    MatSidenavModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatPaginatorModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
