import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AlertService {

  constructor() { }

  displayAlert(message: string) {
    window.prompt(message);
  }
}
