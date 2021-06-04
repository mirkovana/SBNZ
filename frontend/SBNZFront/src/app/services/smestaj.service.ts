import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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
     console.log("evo me u servisu")
    var korisnik = localStorage.getItem('id')
    return this.http.get<Smestaj[]>("http://localhost:8080/smestaj/ocena/" + korisnik, {headers:this.headers});
  
   }
}
