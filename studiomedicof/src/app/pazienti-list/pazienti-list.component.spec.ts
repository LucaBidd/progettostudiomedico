import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PazientiListComponent } from './pazienti-list.component';

describe('PazientiListComponent', () => {
  let component: PazientiListComponent;
  let fixture: ComponentFixture<PazientiListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PazientiListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PazientiListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
