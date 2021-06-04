import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private service: AuthenticationService) { }

  ngOnInit() {
  }

  logOut(){
    this.service.logout();
    window.location.replace("http://localhost:4200");
  }
}
