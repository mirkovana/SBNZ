import { Component, OnInit } from '@angular/core';
import { Putovanje } from 'src/app/models/Putovanje';
import { SmestajService } from 'src/app/services/smestaj.service';

@Component({
  selector: 'app-putovanja',
  templateUrl: './putovanja.component.html',
  styleUrls: ['./putovanja.component.scss']
})
export class PutovanjaComponent implements OnInit {

  putovanja: Array<Putovanje> = [];
  selectedItem:number;
  constructor(private service:SmestajService) { }

  ngOnInit() {
    this.getAllPutovanja();
  }

  getAllPutovanja(){
    this.service.getAllPutovanja().subscribe((data: any)  => {
      ;
      this.putovanja = data;
    }, error => {
       
    });
  }

  oceniPutovanje(idPutovanja:number){
    this.service.oceni(idPutovanja, this.selectedItem).subscribe(
      (val) => {
          console.log("PUT call successful value returned in body", 
                      val);
      },
      response => {
          console.log("PUT call in error", response);
      },
      () => {
          console.log("The PUT observable is now completed.");
      });
  
   
  ;
  }

}
