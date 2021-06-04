import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NeaktivniKorisniciComponent } from './neaktivni-korisnici.component';

describe('NeaktivniKorisniciComponent', () => {
  let component: NeaktivniKorisniciComponent;
  let fixture: ComponentFixture<NeaktivniKorisniciComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NeaktivniKorisniciComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NeaktivniKorisniciComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
