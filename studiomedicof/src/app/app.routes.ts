import { Routes } from '@angular/router';
import { MediciListComponent } from './medici-list/medici-list.component';
import { PazientiListComponent } from './pazienti-list/pazienti-list.component';
import { HomeComponent } from './home/home.component';
import { AddPrenotazioneComponent } from './add-prenotazione/add-prenotazione.component';
import { AddPazienteComponent } from './add-paziente/add-paziente.component';
import { PazienteDetailsComponent } from './paziente-details/paziente-details.component';
import { AddMedicoComponent } from './add-medico/add-medico.component';
import { MedicoDetailsComponent } from './medico-details/medico-details.component';


export const routes: Routes = [
    {path: "medici-list" , component: MediciListComponent},
    {path: "pazienti-list" , component: PazientiListComponent},
    {path: "add-prenotazione" , component: AddPrenotazioneComponent},
    {path: "add-paziente" , component: AddPazienteComponent},
    {path: "paziente-details/:id" , component: PazienteDetailsComponent},
    {path: "add-medico", component: AddMedicoComponent},
    {path: "medico-details/:id" , component: MedicoDetailsComponent},
    {path: "" , component: HomeComponent}
];
