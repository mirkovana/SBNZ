import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-neaktivni-korisnici',
  templateUrl: './neaktivni-korisnici.component.html',
  styleUrls: ['./neaktivni-korisnici.component.scss']
})
export class NeaktivniKorisniciComponent implements OnInit {

  users: Array<User> = [];
  constructor(private service:AuthenticationService) { }

  ngOnInit() {
    this.getAllUsers();
  }

  getAllUsers(){


    this.service.izvestajNeaktivan().subscribe((data: any)  => {
      ;
      this.users = data;
    }, error => {
       
    });
  }

}
