import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PremiumKorisniciComponent } from './premium-korisnici.component';

describe('PremiumKorisniciComponent', () => {
  let component: PremiumKorisniciComponent;
  let fixture: ComponentFixture<PremiumKorisniciComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PremiumKorisniciComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PremiumKorisniciComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
