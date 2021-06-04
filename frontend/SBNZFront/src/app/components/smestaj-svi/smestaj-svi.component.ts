import { Component, OnInit } from '@angular/core';
import { Smestaj } from 'src/app/models/Smestaj';
import { SmestajService } from 'src/app/services/smestaj.service';

@Component({
  selector: 'app-smestaj-svi',
  templateUrl: './smestaj-svi.component.html',
  styleUrls: ['./smestaj-svi.component.scss']
})
export class SmestajSviComponent implements OnInit {
  smestaji: Array<Smestaj> = [];
  constructor(private service : SmestajService) { }

  ngOnInit() {
    this.dobaviSveSmestaje();
  }
  dobaviSveSmestaje(){


    this.service.dobaviSveSmestaje().subscribe((data: any)  => {
      ;
      this.smestaji = data;
    });
  }
}
