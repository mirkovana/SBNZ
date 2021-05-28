import { Injectable } from '@angular/core';
import { Odgovor } from '../models/Odgovor';
import { HttpClient , HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Destinacija } from '../models/Destinacija';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient) { }

  posaljiOdgovor(odgovor: Odgovor){
  const headers = { 'content-type': 'application/json'}  
  const body=JSON.stringify(odgovor);
  return this.http.post<any>('http://localhost:8080/odgovor/nesto',body, {headers: headers}).subscribe(
    (val) => {
        console.log("POST call successful value returned in body", 
                    val);
                    location.replace("http://localhost:4200/destinacija");
    });
  }

  prikaziDestinaciju():Observable<Destinacija>{
    return this.http.get<Destinacija>("http://localhost:8080/destinacija/nesto");
  }

}
