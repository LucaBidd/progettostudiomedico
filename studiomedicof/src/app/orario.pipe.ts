import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'orario'
})
export class OrarioPipe implements PipeTransform {
  transform(value: string): string {
    if (!value) return '';
    
    const [ore, minuti] = value.split(':');
    return `${ore}:${minuti}`;
  }
}
