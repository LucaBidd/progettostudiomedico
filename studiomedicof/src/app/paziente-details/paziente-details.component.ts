import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../services/api.service';
import { CardModule } from 'primeng/card';
import { TableModule } from 'primeng/table';
import { CommonModule, DatePipe } from '@angular/common';
import { firstValueFrom } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';


@Component({
  selector: 'app-paziente-dettagli',
  imports : [ CardModule, TableModule, DatePipe, FormsModule, CommonModule, ButtonModule],
  templateUrl: './paziente-details.component.html',
  styleUrls: ['./paziente-details.component.scss']
})
export class PazienteDetailsComponent implements OnInit {
  paziente: any;
  prenotazioni: any[] = [];
  serviceBack: any;

  constructor(private route: ActivatedRoute, private service: ApiService) {}

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
  }

  async deletePaziente(id: string) {
    try{
      await firstValueFrom(this.service.deletePaziente(id));
    } catch(error){}
    this.serviceBack.goBack();
  }
}
