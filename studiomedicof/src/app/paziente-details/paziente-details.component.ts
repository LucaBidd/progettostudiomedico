import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../services/api.service';
import { CardModule } from 'primeng/card';
import { TableModule } from 'primeng/table';
import { CommonModule, DatePipe } from '@angular/common';
import { firstValueFrom } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { SpeedDialModule } from 'primeng/speeddial';
import { ToastModule } from 'primeng/toast';
import { MenuItem, MessageService } from 'primeng/api';

@Component({
  selector: 'app-paziente-dettagli',
  imports : [ CardModule, TableModule, DatePipe, FormsModule, CommonModule, ButtonModule, SpeedDialModule, ToastModule],
  providers: [MessageService],
  templateUrl: './paziente-details.component.html',
  styleUrls: ['./paziente-details.component.scss']
})
export class PazienteDetailsComponent implements OnInit {
  paziente: any;
  prenotazioni: any[] = [];
  serviceBack: any;
  items: MenuItem[] = [];


  constructor(private route: ActivatedRoute, private service: ApiService, private router: Router, private messageService: MessageService,) {}

  async ngOnInit(): Promise<void> {
    const id = this.route.snapshot.paramMap.get('id');
    console.log(id)
    if (id) {
      let result
      try{
        result = await firstValueFrom(this.service.getPazienteDetail(id));
        this.paziente = result;
        let prenotazioniPaziente
          try {
            prenotazioniPaziente = await firstValueFrom(this.service.getPrenotazioniPerPaziente(id));
            this.prenotazioni = prenotazioniPaziente;
            console.log(this.prenotazioni)
          } catch (error) { }
      }catch(error){}
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

  async deletePaziente(id: string) {
    try{
      await firstValueFrom(this.service.deletePaziente(id));
    } catch(error){}
    this.serviceBack.goBack();
  }

  goto(url : string){
    this.router.navigateByUrl(url);
  }
}
