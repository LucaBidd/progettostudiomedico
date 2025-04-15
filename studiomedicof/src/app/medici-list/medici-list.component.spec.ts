import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MediciListComponent } from './medici-list.component';

describe('MediciListComponent', () => {
  let component: MediciListComponent;
  let fixture: ComponentFixture<MediciListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MediciListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MediciListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
