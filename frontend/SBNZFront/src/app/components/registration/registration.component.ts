import { Component, OnInit } from '@angular/core';
import {FormControl,FormBuilder, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  loading = false;
  firstName1:string;
  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  matcher = new MyErrorStateMatcher();
  constructor(
    private formBuilder: FormBuilder,
    private userService:AuthenticationService
  ) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],
      surname: ['', Validators.required],
      username: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      pol: ['', Validators.required],
      godiste: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(4)]],
      radniStatus: ['', Validators.required],
      tipLjubimca: ['', Validators.required],
      vakcinacija: ['', Validators.required]
  });
  }
  get f() { return this.registerForm.controls; }
  
  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
  }
  // location.replace("http://localhost:4200/home");

  console.log(this.registerForm.value);
  this.userService.addUser(this.registerForm.value);
  }

}
