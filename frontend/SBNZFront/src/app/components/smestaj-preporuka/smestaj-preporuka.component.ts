import { Component, OnInit } from '@angular/core';
import { Smestaj } from 'src/app/models/Smestaj';
import { SmestajService } from 'src/app/services/smestaj.service';

@Component({
  selector: 'app-smestaj-preporuka',
  templateUrl: './smestaj-preporuka.component.html',
  styleUrls: ['./smestaj-preporuka.component.scss']
})
export class SmestajPreporukaComponent implements OnInit {
  smestaji: Array<Smestaj> = [];
  constructor(private service : SmestajService) { }

  ngOnInit() {
    
    this.dobaviSmestajePreporuka();
    console.log("VRATIO SAM SE" + this.smestaji.length)
  }
  dobaviSmestajePreporuka(){


    this.service.dobaviSmestajePreporuka().subscribe((data: any)  => {
      ;
      this.smestaji = data;
    });
  }

  napadNaSmestaj(smestajId:number){
    this.service.napadNaSmestaj(smestajId).subscribe((val) => {console.log("IZVRSIO POSETU")});
  }

}
