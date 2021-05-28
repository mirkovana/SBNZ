import { Component, OnInit } from '@angular/core';
import { Destinacija } from 'src/app/models/Destinacija';
import { Odgovor } from 'src/app/models/Odgovor';
import { HomeService } from 'src/app/services/home.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  mir:string;
  sunce:string;
  voda:string;
  aktivanOdmor:string;
  individualniObilazak:string;
  znamenitosti:string;
  dugPut:string;
  svezVazduh:string;
  medNadzor:string;

  constructor(private service:HomeService) { }

  ngOnInit() {
    
  }

  posaljiOdgovore(){
    const odgovor:Odgovor=new Odgovor();
    if(this.mir == 'da'){
      odgovor.mir = true;
    }else{ odgovor.mir = false}

    if(this.sunce == 'da'){
      odgovor.sunce = false;
    }else{ odgovor.sunce = true}

    if(this.voda == 'da'){
      odgovor.voda = true;
    }else{ odgovor.voda = false}

    if(this.aktivanOdmor == 'da'){
      odgovor.aktivanOdmor = true;
    }else{ odgovor.aktivanOdmor = false}

    if(this.individualniObilazak == 'da'){
      odgovor.individualniObilazak = false;
    }else{ odgovor.individualniObilazak = true}

    if(this.znamenitosti == 'da'){
      odgovor.znamenitosti = true;
    }else{ odgovor.znamenitosti = false}

    if(this.dugPut == 'da'){
      odgovor.dugPut = false;
    }else{ odgovor.dugPut = true}

    if(this.svezVazduh == 'da'){
      odgovor.svezVazduh = true;
    }else{ odgovor.svezVazduh = false}

    if(this.medNadzor == 'da'){
      odgovor.medNadzor = true;
    }else{ odgovor.medNadzor = false}

    this.service.posaljiOdgovor(odgovor);
  }
}
