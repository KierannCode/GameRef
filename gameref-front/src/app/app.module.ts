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
import { AvisComponent } from './avis/avis.component';
import { EditeursComponent } from './editeurs/editeurs.component';
import { PlateformesComponent } from './plateformes/plateformes.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { JeuxComponent } from './jeux/jeux.component';

const routes: Routes = [
  { path: '', component: ConnexionComponent },  // ce qui correspond http://localhost:4200
  { path: 'avis', component: AvisComponent },   // ce qui correspond http://localhost:4200/avis
  {path: 'jeux' , component: JeuxComponent },
  { path: 'editeurs', component: EditeursComponent },
  { path: 'plateformes', component: PlateformesComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    MenuPrincipalComponent,
    AvisComponent,
    EditeursComponent,
    JeuxComponent,
    PlateformesComponent,
    ConnexionComponent
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
