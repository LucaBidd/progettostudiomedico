import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PazienteDetailsComponent } from './paziente-details.component';

describe('PazienteDetailsComponent', () => {
  let component: PazienteDetailsComponent;
  let fixture: ComponentFixture<PazienteDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PazienteDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PazienteDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
