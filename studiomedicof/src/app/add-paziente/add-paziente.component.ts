import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { ApiService } from '../services/api.service';
import { ButtonModule } from 'primeng/button';
import { CommonModule } from '@angular/common';
import { InputMaskModule } from 'primeng/inputmask';
import { InputNumberModule } from 'primeng/inputnumber';
import { DatePickerModule } from 'primeng/datepicker';
import { RadioButtonModule } from 'primeng/radiobutton';
import { TextareaModule } from 'primeng/textarea';
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-paziente',
  templateUrl: './add-paziente.component.html',
  imports: [
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
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
export class AddPazienteComponent {
  pazienteForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private apiService: ApiService,
    private messageService: MessageService,
    private router: Router,
  ) {
    this.pazienteForm = this.fb.group({
      nome: [''],
      cognome: [''],
      codFiscale: [''],
      telefono: [''],
      email: [''],
      indirizzo: [''],
    });
  }

  onSubmit() {
    let medico = this.pazienteForm.value;
  
    this.apiService.createMedico(medico).subscribe({
      next: () => {
        console.log(this.pazienteForm.value);
        console.log('Paziente creato con successo');
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
    this.pazienteForm.reset();
  }
}