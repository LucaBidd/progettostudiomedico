import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { ApiService } from '../services/api.service';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';
import { InputMask, InputMaskModule } from 'primeng/inputmask';
import { CardModule } from 'primeng/card';
import { Router } from '@angular/router';
import { AutoCompleteModule } from 'primeng/autocomplete';
import { InputNumberModule } from 'primeng/inputnumber';
import { CalendarModule } from 'primeng/calendar';
import { CommonModule } from '@angular/common';
import { DatePickerModule } from 'primeng/datepicker';
import { RadioButtonModule } from 'primeng/radiobutton';
import { TextareaModule } from 'primeng/textarea';
import { InputTextModule } from 'primeng/inputtext';

@Component({
  selector: 'app-add-medico',
  templateUrl: './add-medico.component.html',
  imports:[
    FormsModule,
    DropdownModule,
    CalendarModule,
    ButtonModule,
    ReactiveFormsModule,
    CommonModule,
    AutoCompleteModule,
    InputMaskModule,
    InputNumberModule,
    DatePickerModule,
    RadioButtonModule,
    TextareaModule,
    CardModule,
    InputTextModule,
  ],
  providers: [MessageService]
})
export class AddMedicoComponent {
  medicoForm: FormGroup;
  
  specializzazioni = [
    { label: 'Otornino', value: 'OTORINO' },
    { label: 'Cardiologo', value: 'CARDIOLOGO' },
    { label: 'Fisiatra', value: 'FISIATRA' },
    { label: 'Pediatra', value: 'PEDIATRA' }
  ];

  constructor(
    private fb: FormBuilder,
    private apiService: ApiService,
    private messageService: MessageService,
    private router: Router,
  ) {
    this.medicoForm = this.fb.group({
      nome: [''],
      telefono: [''],
      email: [''],
      specializzazione: [null]
    });
  }

  onSubmit() {
    let medico = this.medicoForm.value;
  
    this.apiService.createMedico(medico).subscribe({
      next: () => {
        console.log(this.medicoForm.value);
        console.log('Medico creato con successo');
        this.resetForm();
      },
      error: (err) => {
        console.error('Errore durante il salvataggio:', err);
      }
    });
  }
  
  goto(url : string){
    this.router.navigateByUrl(url);
  }

  resetForm() {
    this.medicoForm.reset();
  }
}