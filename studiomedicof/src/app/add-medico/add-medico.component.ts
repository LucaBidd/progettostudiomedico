import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { ApiService } from '../services/api.service';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';
import { InputMask } from 'primeng/inputmask';

@Component({
  selector: 'app-add-medico',
  templateUrl: './add-medico.component.html',
  imports:[
    DropdownModule, 
    ButtonModule,
    InputMask,
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
    private messageService: MessageService
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
  

  resetForm() {
  }
}