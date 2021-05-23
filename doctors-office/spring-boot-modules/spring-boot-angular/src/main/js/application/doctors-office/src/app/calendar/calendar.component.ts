import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {CalendarEvent, CalendarView} from 'angular-calendar';
import {UserService} from '../service/user.service';
import {CalendarService} from '../service/calendar.service';
import {Observable} from 'rxjs';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-calendar',
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {
  view: CalendarView = CalendarView.Month;

  viewDate: Date = new Date();
  eventName: FormControl;
  events$: Observable<CalendarEvent<any>[]>;
  // [
  //   {
  //     title: 'Editable event',
  //     start: new Date(),
  //     actions: [
  //       {
  //         label: '<i class="fas fa-fw fa-pencil-alt"></i>',
  //         onClick: () => {
  //           console.log('Edit event', event);
  //         },
  //       },
  //     ],
  //   },
  //   {
  //     title: 'Deletable event',
  //     start: new Date(),
  //     actions: [
  //       {
  //         label: '<i class="fas fa-fw fa-trash-alt"></i>',
  //         onClick: ({ event }: { event: CalendarEvent }): void => {
  //           this.events = this.events.filter((iEvent) => iEvent !== event);
  //           console.log('Event deleted', event);
  //         },
  //       },
  //     ],
  //   },
  //   {
  //     title: 'Non editable and deletable event',
  //     start: new Date(),
  //   },
  // ];
  calendarEventStartDate: string;
  calendarEventEndDate: string;

  constructor(private userService: UserService,
              private calendarService: CalendarService) { }

  ngOnInit(): void {
    this.fetchCalendarData();
  }

  setCalendarEventStartDate(date: unknown) {
    this.calendarEventStartDate = String(date);
  }

  setCalendarEventEndDate(date: unknown) {
    this.calendarEventEndDate = String(date);
  }

  onCreateCalendarEventClick() {
    let calendarEvent: CalendarEvent;
    calendarEvent = {
      title: this.eventName.value.get('eventName').value,
      start: new Date(this.calendarEventStartDate),
      end: new Date(this.calendarEventEndDate),
      color: undefined
    };
    const calendarEventObservable = this.calendarService.saveCalendarEvent(calendarEvent);
    calendarEventObservable.toPromise().then(
      () => {
        this.fetchCalendarData();
      });
  }

  private fetchCalendarData() {
    this.events$ = this.calendarService.fetchCalendarData(this.userService.getUsernameOfCurrentUser());
  }

  setCalendarEventName(eventName: FormControl) {
    this.eventName = eventName.value;
  }
}
