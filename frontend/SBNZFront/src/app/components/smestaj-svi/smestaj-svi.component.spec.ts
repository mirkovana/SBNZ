import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SmestajSviComponent } from './smestaj-svi.component';

describe('SmestajSviComponent', () => {
  let component: SmestajSviComponent;
  let fixture: ComponentFixture<SmestajSviComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SmestajSviComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SmestajSviComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
