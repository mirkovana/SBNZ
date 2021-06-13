import { Component, OnInit } from '@angular/core';
import {FormControl,FormBuilder, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import { SmestajService } from 'src/app/services/smestaj.service';

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-dodavanje-smestaja',
  templateUrl: './dodavanje-smestaja.component.html',
  styleUrls: ['./dodavanje-smestaja.component.scss']
})
export class DodavanjeSmestajaComponent implements OnInit {

  novSmestajForm: FormGroup;
  submitted = false;
  loading = false;

  matcher = new MyErrorStateMatcher();

  constructor(private formBuilder: FormBuilder, private service: SmestajService) { }

  ngOnInit(): void {
    this.novSmestajForm = this.formBuilder.group({
      naziv: ['', Validators.required],
      lokacija: ['', Validators.required],
      opis: ['', Validators.required],
      destinacija: ['', Validators.required]
  });
  }

  get f() { return this.novSmestajForm.controls; }
  
  onSubmit() {
    this.submitted = true;
    if (this.novSmestajForm.invalid) {
      return;
  }

  this.service.dodajSmestaj(this.novSmestajForm.value);
  }


}
