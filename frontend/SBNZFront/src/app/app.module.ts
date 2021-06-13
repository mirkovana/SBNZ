import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatIconModule } from '@angular/material/icon';
import { NgbModule, NgbToastModule } from '@ng-bootstrap/ng-bootstrap';
import { MatFormFieldModule  } from '@angular/material/form-field';
import { RegistrationComponent } from './components/registration/registration.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material';
import { HomeComponent } from './components/home/home.component';
import {MatRadioModule} from '@angular/material/radio';
import {CdkTableModule} from '@angular/cdk/table';
import {MatButtonModule} from '@angular/material/button';
import { DestinacijaComponent } from './components/destinacija/destinacija.component';
import {MatCardModule} from '@angular/material/card';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SmestajPreporukaComponent } from './components/smestaj-preporuka/smestaj-preporuka.component';
import { SmestajSviComponent } from './components/smestaj-svi/smestaj-svi.component';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { NavbarAdminComponent } from './components/navbar-admin/navbar-admin.component';
import { PremiumKorisniciComponent } from './components/premium-korisnici/premium-korisnici.component';
import { NeaktivniKorisniciComponent } from './components/neaktivni-korisnici/neaktivni-korisnici.component';
import { PutovanjaComponent } from './components/putovanja/putovanja.component';
import {MatSelectModule} from '@angular/material/select';
import { DodavanjeSmestajaComponent } from './components/dodavanje-smestaja/dodavanje-smestaja.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomeComponent,
    DestinacijaComponent,
    NavbarComponent,
    SmestajPreporukaComponent,
    SmestajSviComponent,
    AdminHomeComponent,
    NavbarAdminComponent,
    PremiumKorisniciComponent,
    NeaktivniKorisniciComponent,
    PutovanjaComponent,
    DodavanjeSmestajaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSnackBarModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatIconModule,
    NgbModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRadioModule,
    CdkTableModule,
    MatButtonModule,
    MatCardModule,
    MatSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
