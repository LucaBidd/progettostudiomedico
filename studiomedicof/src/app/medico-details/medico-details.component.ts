import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../services/api.service';
import { firstValueFrom } from 'rxjs';
import { CardModule } from 'primeng/card';
import { TableModule } from 'primeng/table';
import { CommonModule, DatePipe } from '@angular/common';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { GiornoPipe } from "../giorno.pipe";
import { OrarioPipe } from "../orario.pipe";
import { ButtonModule } from 'primeng/button';
import { GoBackService } from '../services/go-back.service';
import { DialogModule } from 'primeng/dialog';
import { DatePickerModule } from 'primeng/datepicker';
import { DropdownModule } from 'primeng/dropdown';
import { SpeedDialModule } from 'primeng/speeddial';
import { ToastModule } from 'primeng/toast';
import { MenuItem, MessageService } from 'primeng/api';

@Component({
  selector: 'app-medico-details',
  imports: [CardModule,
    TableModule,
    DatePipe,
    FormsModule,
    CommonModule,
    GiornoPipe,
    OrarioPipe,
    ButtonModule,
    DialogModule,
    DatePickerModule,
    ReactiveFormsModule,
    DropdownModule, 
    SpeedDialModule, 
    ToastModule
  ],
  providers: [MessageService],
  templateUrl: './medico-details.component.html',
  styleUrl: './medico-details.component.scss'
})
export class MedicoDetailsComponent implements OnInit {

  visible: boolean = false;
  medico: any;
  prenotazioni: any[] = [];
  turni: any[] = [];
  nomePaziente: string = "";
  turnoForm: FormGroup;
  giorni = [
    { label: 'Lunedì', value: 'MONDAY' },
    { label: 'Martedì', value: 'TUESDAY' },
    { label: 'Mercoledì', value: 'WEDNESDAY' },
    { label: 'Giovedì', value: 'THURSDAY' },
    { label: 'Venerdì', value: 'FRIDAY' },
  ];
    items: MenuItem[] = [];
  


  constructor(private route: ActivatedRoute, private service: ApiService, private serviceBack: GoBackService, private fb: FormBuilder, private messageService: MessageService,) {
    this.turnoForm = this.fb.group({
      idMedico: [],
      giorno: [''],
      orarioInizio: [''],
      orarioFine: [''],
    })
  }

  async ngOnInit(): Promise<void> {
    let id = this.route.snapshot.paramMap.get('id');
    console.log(id);


    this.turnoForm = this.fb.group({
      idMedico: [id],
      giorno: [''],
      orarioInizio: [''],
      orarioFine: [''],
    })
    if (id) {
      let result
      try {
        result = await firstValueFrom(this.service.getMedicoDetail(id));
        this.medico = result;
        let turniMedico
        try {
          turniMedico = await firstValueFrom(this.service.getTurniPerMedico(id));
          this.turni = turniMedico;
          console.log(this.turni)
          let prenotazioniMedico
          try {
            prenotazioniMedico = await firstValueFrom(this.service.getPrenotazioniPerMedico(id));
            this.prenotazioni = prenotazioniMedico;
            console.log(this.prenotazioni)
          } catch (error) { }
        } catch (error) { }
      } catch (error) { }
    }
    this.items = [
      {
          label: 'Edit',
          icon: 'pi pi-pencil',
          command: () => {
              this.messageService.add({ severity: 'info', summary: 'Add', detail: 'Data Added' });
          },
      },
      {
          label: 'Delete',
          icon: 'pi pi-trash',
          command: () => {
              this.messageService.add({ severity: 'error', summary: 'Delete', detail: 'Data Deleted' });
          },
      },
  ];
  }

  mostraForm() {
    this.visible = true;
  }

  aggiungiTurno() {
    let turno = this.turnoForm.value;
    console.log(turno);
    let orarioInizio = turno.orarioInizio.toTimeString().split(' ')[0];
    let orarioFine = turno.orarioFine.toTimeString().split(' ')[0];

    turno = {
      ...turno,
      orarioInizio,
      orarioFine
    };
    console.log(turno);

    this.service.createTurno(turno).subscribe({
      next: () => {
        console.log(this.turnoForm.value);
        console.log('Turno creato con successo');
        this.turnoForm.reset();
      },
      error: (err) => {
        console.error('Errore durante il salvataggio:', err);
      }
    });
  }

  async deleteMedico(id: string) {
    try {
      await firstValueFrom(this.service.deleteMedico(id));
    } catch (error) { }
    this.serviceBack.goBack();
  }
}