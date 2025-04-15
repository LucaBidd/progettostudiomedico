import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';
import { firstValueFrom } from 'rxjs';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pazienti-list',
  imports: [TableModule, ButtonModule],
  templateUrl: './pazienti-list.component.html',
  styleUrl: './pazienti-list.component.scss'
})
export class PazientiListComponent implements OnInit {

  pazienti : any = [];
  constructor(
    private service : ApiService,
    private router : Router
  ){}

  async ngOnInit(): Promise<void> {
    let result 
    try{
      result = await firstValueFrom(this.service.getPazienti());
      console.log(result)
      this.pazienti = result;
    } catch(error){

    }
  }

  goto(url : string){
    this.router.navigateByUrl(url);
  }

  async apriDettagli(id: string) {
    this.router.navigateByUrl("paziente-details/" + id);
  }

}
