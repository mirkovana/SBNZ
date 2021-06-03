import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SmestajPreporukaComponent } from './smestaj-preporuka.component';

describe('SmestajPreporukaComponent', () => {
  let component: SmestajPreporukaComponent;
  let fixture: ComponentFixture<SmestajPreporukaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SmestajPreporukaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SmestajPreporukaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
