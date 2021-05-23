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
  private readonly saveCalenderEventUrl: string;


  constructor(private http: HttpClient) {
    this.getCalendarUrl = ApplicationProperties.APPLICATION_ADDRESS + '/get-calendar';
    this.saveCalenderEventUrl = ApplicationProperties.APPLICATION_ADDRESS + '/save-calendar-event';
  }

  fetchCalendarData(username: string): Observable<CalendarEvent[]> {
    return this.http.post<CalendarEvent[]>(this.getCalendarUrl, username);
  }

  saveCalendarEvent(calendarEvent: CalendarEvent) {
    return this.http.post<CalendarEvent>(this.getCalendarUrl, calendarEvent);
  }
}
