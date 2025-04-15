import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CalendarioComponent } from "./calendario/calendario.component";
import { FooterComponent } from "./footer/footer.component";
import { HeaderComponent } from "./header/header.component";
import { MediciListComponent } from "./medici-list/medici-list.component";
import { MedicoDetailsComponent } from "./medico-details/medico-details.component";
import { PazienteDetailsComponent } from "./paziente-details/paziente-details.component";
import { PazientiListComponent } from "./pazienti-list/pazienti-list.component";
import { PrenotazioniDetailsComponent } from "./prenotazioni-details/prenotazioni-details.component";
import { PrenotazioniListComponent } from "./prenotazioni-list/prenotazioni-list.component";
import { SidebarComponent } from "./sidebar/sidebar.component";
import { BreadcrumbModule } from 'primeng/breadcrumb';
import { BackButtonComponent } from "./back-button/back-button.component";

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    CalendarioComponent,
    FooterComponent,
    HeaderComponent,
    MediciListComponent,
    MedicoDetailsComponent,
    PazienteDetailsComponent,
    PazientiListComponent,
    PrenotazioniDetailsComponent,
    PrenotazioniListComponent,
    SidebarComponent,
    BreadcrumbModule,
    BackButtonComponent
],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'studiomedicof';
}
