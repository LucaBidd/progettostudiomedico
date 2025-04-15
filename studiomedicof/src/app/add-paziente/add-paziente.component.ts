import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { ApiService } from '../services/api.service';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-add-paziente',
  templateUrl: './add-paziente.component.html',
  imports: [ButtonModule],
  providers: [MessageService]
})
export class AddPazienteComponent {
}