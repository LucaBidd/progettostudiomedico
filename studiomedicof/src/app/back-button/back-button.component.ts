import { Component } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { GoBackService } from '../services/go-back.service';

@Component({
  selector: 'app-back-button',
  imports: [ButtonModule],
  templateUrl: './back-button.component.html'
})
export class BackButtonComponent {
  constructor(private service : GoBackService) {}
  
  goBack(): void {
    this.service.goBack();
  }
      
}
