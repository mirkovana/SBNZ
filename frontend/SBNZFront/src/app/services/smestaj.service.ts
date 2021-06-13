import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Putovanje } from '../models/Putovanje';
import { Smestaj } from '../models/Smestaj';

@Injectable({
  providedIn: 'root'
})
export class SmestajService {
  bear  = localStorage.getItem("token");
  headers: HttpHeaders = new HttpHeaders({"Authorization": "Bearer " + this.bear, 'content-type': 'application/json'})
  constructor(private http: HttpClient) { }


  dobaviSveSmestaje():Observable<Smestaj[]>{
    var korisnik = localStorage.getItem('id')
    return this.http.get<Smestaj[]>("http://localhost:8080/smestaj/svi/" + korisnik, {headers:this.headers});
  
   }

   dobaviSmestajePreporuka():Observable<Smestaj[]>{
    var korisnik = localStorage.getItem('id')
    return this.http.get<Smestaj[]>("http://localhost:8080/smestaj/ocena/" + korisnik, {headers:this.headers});
  
   }

   napadNaSmestaj(smestajId:number){
   var korisnik = localStorage.getItem('id')
   return this.http.post<any>("http://localhost:8080/cep/napadNaSmestaj/" + korisnik + "/" + smestajId, null);
 
  }

  getAllPutovanja():Observable<Putovanje[]>{
    var korisnik = localStorage.getItem('id')
    return this.http.get<Putovanje[]>("http://localhost:8080/putovanja/svaPutovanja/" + korisnik, {headers:this.headers});
  }

  oceni(idPutovanja:number, selectedItem:number){
    return this.http.put<any>("http://localhost:8080/putovanja/oceni/" + idPutovanja + "/" + selectedItem, {headers:this.headers});
  }

  dodajSmestaj(smestaj:Smestaj){
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(smestaj);
    return this.http.post<any>('http://localhost:8080/smestaj/novSmestaj',body, {headers: this.headers}).subscribe(
      (val) => {
          console.log("POST call successful value returned in body", 
                      val);
      },
      response => {
          console.log("POST call in error", response);
      },
      () => {
          console.log("The POST observable is now completed.");
          window.location.replace("http://localhost:4200/homeAdmin")
      });
      
  }

}
