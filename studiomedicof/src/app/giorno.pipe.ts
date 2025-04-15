import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'giorno'
})
export class GiornoPipe implements PipeTransform {

  transform(value: string): unknown {
    let map : {[key: string]: string} = {
        'MONDAY': 'Lunedì',
        'TUESDAY': 'Martedì',
        'WEDNESDAY': 'Mercoledì',
        'THURSDAY': 'Giovedì',
        'FRIDAY': 'Venerdì',
        'SATURDAY': 'Sabato',
        'SUNDAY': 'Domenica'
    };
    console.log(map);
    return map[value.toLocaleUpperCase()] || value;
  }

}
