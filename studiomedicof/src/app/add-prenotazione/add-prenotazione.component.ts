import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ApiService } from '../services/api.service';
import { DropdownFilterOptions, DropdownModule } from 'primeng/dropdown';
import { CalendarModule } from 'primeng/calendar';
import { ButtonModule } from 'primeng/button';
import { CommonModule } from '@angular/common';
import { firstValueFrom } from 'rxjs';
import { AutoCompleteCompleteEvent, AutoCompleteModule } from 'primeng/autocomplete';
import { InputMaskModule } from 'primeng/inputmask';
import { InputNumberModule } from 'primeng/inputnumber';
import { DatePickerModule } from 'primeng/datepicker';
import { RadioButtonModule } from 'primeng/radiobutton';
import { TextareaModule } from 'primeng/textarea';

@Component({
  selector: 'app-add-prenotazione',
  templateUrl: './add-prenotazione.component.html',
  imports: [
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
  ],
})
export class AddPrenotazioneComponent implements OnInit {

  pazienti: any[] = [];
  medici: any[] = [];
  prenotazioneForm: FormGroup;
  filterValue: string | undefined = '';
  filteredPazienti: any[] = [];
  filteredMedici: any[] = [];
  filteredTipi: any[] = [];
  items: any[] = [];


  async ngOnInit(): Promise<void> {
    this.pazienti = await firstValueFrom(this.service.getPazienti());
    this.medici = await firstValueFrom(this.service.getMedici());
  }

  tipoVisita = [
    { label: 'Infiltrazione', value: 'INFLITRAZIONE' },
    { label: 'Controllo', value: 'CONTROLLO' },
    { label: 'Ecografia', value: 'ECOGRAFIA' },
    { label: 'Visita', value: 'VISITA' },
  ];
  status = [
    { label: 'In sospeso', value: 'IN_SOSPESO' },
    { label: 'Confermata', value: 'CONFERMATA' },
    { label: 'Disdetta', value: 'DISDETTA' },
  ];

  constructor(
    private fb: FormBuilder,
    private service: ApiService,
  ) {
    this.prenotazioneForm = this.fb.group({
      idPaziente: [],
      idMedico: [],
      tipoVisita: [''],
      status: ['IN_SOSPESO'],
      costo: [''],
      data: [''],
      orario: [''],
      durata: [''],
      note: [''],
    })
  }

  onSubmit() {
    let prenotazione = this.prenotazioneForm.value;

    let data = prenotazione.data.toISOString().split('T')[0];

    let orario = prenotazione.orario.toTimeString().split(' ')[0];


    prenotazione = {
      ...prenotazione,
      data,
      orario
    };
    console.log(prenotazione);


    this.service.createPrenotazione(prenotazione).subscribe({
      next: () => {
        console.log(this.prenotazioneForm.value);
        console.log('Prenotazione creata con successo');
        this.prenotazioneForm.reset();
      },
      error: (err) => {
        console.error('Errore durante il salvataggio:', err);
      }
    });
  }

  searchPaziente(event: AutoCompleteCompleteEvent) {
    let filtered: any[] = [];
    let query = event.query;

    for (let i = 0; i < (this.pazienti as any[]).length; i++) {
      let paziente = (this.pazienti as any[])[i];
      if (paziente.nome.toLowerCase().indexOf(query.toLowerCase()) == 0 || paziente.cognome.toLowerCase().indexOf(query.toLowerCase()) == 0) {
        filtered.push(paziente);
      }
    }
    this.filteredPazienti = filtered;
  }

  searchMedico(event: AutoCompleteCompleteEvent) {
    let filtered: any[] = [];
    let query = event.query;

    for (let i = 0; i < (this.medici as any[]).length; i++) {
      let medico = (this.medici as any[])[i];
      if (medico.nome.toLowerCase().indexOf(query.toLowerCase()) == 0) {
        filtered.push(medico);
      }
    }
    this.filteredMedici = filtered;
  }

  searchTipo(event: AutoCompleteCompleteEvent) {
    let _items = [this.tipoVisita];
    let query = event.query;

    this.filteredTipi = this.tipoVisita.filter(tipo =>
      tipo.label.toLowerCase().includes(query)
    );
  }
}