import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  
  be_url : string = "http://localhost:8080/api/"
  constructor(private http: HttpClient) { }
  
  getPazienti(){
    return this.http.get<any>(this.be_url+"pazienti")
  }
  getMedici(){
    return this.http.get<any>(this.be_url+"medici")
  }
  getPrenotazioni(){
    return this.http.get<any>(this.be_url+"prenotazioni")
  }
  getTurni(){
    return this.http.get<any>(this.be_url+"turni")
  }
  getPazienteDetail(id : string){
    return this.http.get<any>(this.be_url+"pazienti/" + id)
  }
  getMedicoDetail(id : string){
    return this.http.get<any>(this.be_url+"medici/" + id)
  }
  getPrenotazioneDetail(id : string){
    return this.http.get<any>(this.be_url+"prenotazioni/" + id)
  }
  getTurniPerMedico(id : string){
    return this.http.get<any>(this.be_url+"turni/filter/idMedico/" + id)
  }
  getPrenotazioniPerMedico(id:string){
    return this.http.get<any>(this.be_url+"prenotazioni/filter/idMedico/" + id)
  }
  getPrenotazioniPerPaziente(id:string){
    return this.http.get<any>(this.be_url+"prenotazioni/filter/idPaziente/" + id)
  }
  
  createPrenotazione(prenotazioneData : any){
    return this.http.post<any>(this.be_url+'prenotazioni', prenotazioneData);
  }
  createPaziente(pazienteData : any){
    return this.http.post<any>(this.be_url+'pazienti', pazienteData);
  }
  createMedico(medicoData : any){
    return this.http.post<any>(this.be_url+'medici', medicoData);
  }
  createTurno(turnoData : any){
    return this.http.post<any>(this.be_url+'turni', turnoData);
  }

  deletePrenotazione(id: string) {
    return this.http.delete<any>(this.be_url+'prenotazioni/' + id);
  }
  deletePaziente(id: string) {
    return this.http.delete<any>(this.be_url+'pazienti/' + id);
  }
  deleteMedico(id: string) {
    return this.http.delete<any>(this.be_url+'medici/' + id);
  }
}
