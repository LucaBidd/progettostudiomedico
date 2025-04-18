import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { ApiService } from '../services/api.service';
import { firstValueFrom } from 'rxjs';
import { CommonModule, DatePipe } from '@angular/common';

@Component({
  selector: 'app-home',
  imports: [
    ButtonModule,
    TableModule,
    DatePipe,
    CommonModule,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit{

  prenotazioni: any[] = [];
  giorni: any[] = ['Ora','Lunedì', 'Martedì', 'Mercoledì', 'Giovedì', 'Venerdì'];
  orari: any[] = ['8.00', '9.00', '10.00', '11.00', '12.00', '13.00', '14.00', '15.00', '16.00', '17.00'];
  slots: any[] = [' ',];


  constructor(private router : Router, private service : ApiService){}

  async ngOnInit(): Promise<void> {
    let prenotazioniSettimana
    try {
      prenotazioniSettimana = await firstValueFrom(this.service.getPrenotazioni());
      this.prenotazioni = prenotazioniSettimana;
      console.log(this.prenotazioni)
    } catch (error) { }
  }

  goto(url : string){
    this.router.navigateByUrl(url)
  }
  
  
}
