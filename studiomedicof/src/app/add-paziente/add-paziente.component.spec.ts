import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPazienteComponent } from './add-paziente.component';

describe('AddPazienteComponent', () => {
  let component: AddPazienteComponent;
  let fixture: ComponentFixture<AddPazienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddPazienteComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddPazienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
