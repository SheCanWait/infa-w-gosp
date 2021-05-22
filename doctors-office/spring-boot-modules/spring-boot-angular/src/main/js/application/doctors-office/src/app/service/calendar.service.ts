import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ApplicationProperties} from '../properties/application-properties';
import {Observable} from 'rxjs';
import { CalendarEvent } from 'angular-calendar';

@Injectable({
  providedIn: 'root'
})
export class CalendarService {

  private readonly getCalendarUrl: string;

  constructor(private http: HttpClient) {
    this.getCalendarUrl = ApplicationProperties.APPLICATION_ADDRESS + '/get-calendar';
  }

  fetchCalendarData(username: string): Observable<CalendarEvent[]> {
    return this.http.post<CalendarEvent[]>(this.getCalendarUrl, username);
  }
}
