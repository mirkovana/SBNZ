import { Component, OnInit } from '@angular/core';
import { Destinacija } from 'src/app/models/Destinacija';
import { HomeService } from 'src/app/services/home.service';

@Component({
  selector: 'app-destinacija',
  templateUrl: './destinacija.component.html',
  styleUrls: ['./destinacija.component.scss']
})
export class DestinacijaComponent implements OnInit {
  destinacija: Destinacija;
  constructor(private service:HomeService) { }

  ngOnInit() {
    this.zaPozivMetoda()
  }

  zaPozivMetoda(){
    this.service.prikaziDestinaciju().subscribe(des=>{
      this.destinacija = des;
      console.log(this.destinacija.naziv);
    });
  }

}
