import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrenotazioniDetailsComponent } from './prenotazioni-details.component';

describe('PrenotazioniDetailsComponent', () => {
  let component: PrenotazioniDetailsComponent;
  let fixture: ComponentFixture<PrenotazioniDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrenotazioniDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrenotazioniDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
