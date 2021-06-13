import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PutovanjaComponent } from './putovanja.component';

describe('PutovanjaComponent', () => {
  let component: PutovanjaComponent;
  let fixture: ComponentFixture<PutovanjaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PutovanjaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PutovanjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
