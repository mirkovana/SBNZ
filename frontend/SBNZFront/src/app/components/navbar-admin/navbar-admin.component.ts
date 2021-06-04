import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-navbar-admin',
  templateUrl: './navbar-admin.component.html',
  styleUrls: ['./navbar-admin.component.scss']
})
export class NavbarAdminComponent implements OnInit {

  constructor(private service: AuthenticationService) { }

  ngOnInit() {
  }
  logOut(){
    this.service.logout();
    window.location.replace("http://localhost:4200");
  }
}
