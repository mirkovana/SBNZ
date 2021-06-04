import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AlertService } from 'src/app/services/alert.service';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;

  constructor( private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService,
    private alertService: AlertService,  private _snackBar: MatSnackBar) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
  });
  }

  get f() { return this.loginForm.controls; }

  onSubmit() {
      this.submitted = true;

      // stop here if form is invalid
      if (this.loginForm.invalid) {
          return;
      }

      this.loading = true;
      this.authenticationService.login(this.f.username.value, this.f.password.value)
          .subscribe(
              data => {
                  // this.router.navigate([this.returnUrl]);
                  var user = localStorage.getItem('username');
                  if(user == "admin@nesto.com"){
                    location.replace("http://localhost:4200/homeAdmin");

                  }
                  else{
                    location.replace("http://localhost:4200/home");

                  }
              },
              error => {
                this.openSnackBarSE();
                  this.alertService.error(error);
                  this.loading = false;
              });
  }

  openSnackBarSE() {
    this._snackBar.open("Invalid username or password.", "OK", {
      duration: 2000,
    });
  }
}
