import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  private darkClass = 'dark-mode';

  setTheme(mode: 'light' | 'dark' | 'system') {
    const html = document.documentElement;

    if (mode === 'system') {
      const prefersDark = window.matchMedia('(prefers-color-scheme: dark)').matches;
      html.classList.toggle(this.darkClass, prefersDark);
    } else {
      html.classList.toggle(this.darkClass, mode === 'dark');
    }

    localStorage.setItem('theme', mode);
  }

  initTheme() {
    const saved = localStorage.getItem('theme') as 'light' | 'dark' | 'system' | null;
    this.setTheme(saved || 'light');
  }
}
