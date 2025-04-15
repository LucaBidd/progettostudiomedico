import { Component, OnInit } from '@angular/core';
import { ThemeService } from '../services/theme.service';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-header',
  imports: [ButtonModule],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  userName = 'Dr. House';

  constructor(private themeService: ThemeService) {}

  ngOnInit(): void {
    this.themeService.initTheme();
  }

  changeTheme(mode: 'light' | 'dark' | 'system') {
    this.themeService.setTheme(mode);
  }


  reload() {
    location.reload();
  }

  openSettings() {
    // TODO: apri dialog impostazioni
    console.log('Apro impostazioni...');
  }

  logout() {
    // TODO: logica di logout
    console.log('Logout utente...');
  }
}
