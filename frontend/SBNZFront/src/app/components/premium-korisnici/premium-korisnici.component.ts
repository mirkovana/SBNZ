import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-premium-korisnici',
  templateUrl: './premium-korisnici.component.html',
  styleUrls: ['./premium-korisnici.component.scss']
})
export class PremiumKorisniciComponent implements OnInit {
  users: Array<User> = [];
  constructor(private service:AuthenticationService) { }

  ngOnInit() {
    this.getAllUsers();
  }
  
  getAllUsers(){


    this.service.izvestajPremium().subscribe((data: any)  => {
      ;
      this.users = data;
    }, error => {
       
    });
  }

}
