import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';
import { firstValueFrom } from 'rxjs';
import { CardModule } from 'primeng/card';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { Router } from '@angular/router';

@Component({
  selector: 'app-medici-list',
  imports: [CardModule, CommonModule, ButtonModule],
  templateUrl: './medici-list.component.html',
  styleUrl: './medici-list.component.scss'
})
export class MediciListComponent implements OnInit {

  medici : any = [];
  constructor(private service : ApiService,
    private router : Router
  ){}

  async ngOnInit(): Promise<void> {
    let result 
    try{
      result = await firstValueFrom(this.service.getMedici());
      console.log(result)
      this.medici = result;
    } catch(error){
    }
  }

  goto(url : string){
    this.router.navigateByUrl(url);
  }

  async apriDettagli(id: string) {
    this.router.navigateByUrl("medico-details/" + id);
  }

}
