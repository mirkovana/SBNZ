import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { DestinacijaComponent } from './components/destinacija/destinacija.component';
import { DodavanjeSmestajaComponent } from './components/dodavanje-smestaja/dodavanje-smestaja.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NeaktivniKorisniciComponent } from './components/neaktivni-korisnici/neaktivni-korisnici.component';
import { PremiumKorisniciComponent } from './components/premium-korisnici/premium-korisnici.component';
import { PutovanjaComponent } from './components/putovanja/putovanja.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { SmestajPreporukaComponent } from './components/smestaj-preporuka/smestaj-preporuka.component';
import { SmestajSviComponent } from './components/smestaj-svi/smestaj-svi.component';


const routes: Routes = [
  { path: '', component: LoginComponent},
  { path: 'login', component: LoginComponent},
  { path: 'registration', component: RegistrationComponent},
  { path: 'home', component: HomeComponent},
  { path: 'destinacija', component: DestinacijaComponent},
  { path: 'smestajPreporuka', component: SmestajPreporukaComponent},
  { path: 'smestajSvi', component: SmestajSviComponent},
  { path: 'homeAdmin', component: AdminHomeComponent},
  { path: 'premiumKorisnici', component: PremiumKorisniciComponent},
  { path: 'neaktivniKorisnici', component: NeaktivniKorisniciComponent},
  { path: 'poseceniSmestaji', component: PutovanjaComponent},
  { path: 'dodajSmestaj', component: DodavanjeSmestajaComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
