import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {MatSnackBar} from '@angular/material/snack-bar';
import { HttpClient , HttpHeaders} from '@angular/common/http';
import { User } from '../models/User';
import { UserTokenState } from '../models/UserTokenState';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private http: HttpClient,  private _snackBar: MatSnackBar) {
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
   }

   public get currentUserValue(): User {
    return this.currentUserSubject.value;
}

login(username: string, password: string) {
    return this.http.post<any>('http://localhost:8080/auth/log-in', { 'username':username,'password': password })
        .pipe(map(userTokenState => {
            if (userTokenState.accessToken) {
                localStorage.setItem('token', userTokenState.accessToken);
                localStorage.setItem('username', username);
                console.log(userTokenState.accessToken)
            }
            else{
              console.log("nema tokena")
            }

            return userTokenState.accessToken;
        }));
}

logout() {
  // remove user from local storage to log user out
  localStorage.removeItem('token');
  localStorage.removeItem('username');
}

isLoggedIn(): boolean {
  if (!localStorage.getItem('username')) {
      return false;
  }
  return true;
}

addUser(user:User)  {
  const headers = { 'content-type': 'application/json'}  
  const body=JSON.stringify(user);
  return this.http.post<any>('http://localhost:8080/auth/sign-up',body, {headers: this.headers}).subscribe(
    (val) => {
        console.log("POST call successful value returned in body", 
                    val);
                    location.replace("http://localhost:4200/login");
    },
    response => {
        console.log("POST call in error", response);
        this.openSnackBarUS();
    },
    () => {
        console.log("The POST observable is now completed.");
        this.openSnackBarS();
    });
    
}

openSnackBarS() {
  this._snackBar.open("Uspesna registracija.", "OK", {
    duration: 4000,
  });
}

openSnackBarUS() {
  this._snackBar.open("Doslo je do greske!", "OK", {
    duration: 2000,
  });
}

}
