package com.baeldung.application.entities;

import com.baeldung.application.calendar.CalendarEventColor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CalendarEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Column
    private CalendarEventColor calendarEventColor;

    public CalendarEvent() {
    }

    public CalendarEvent(String title, LocalDateTime startDate, LocalDateTime endDate, CalendarEventColor calendarEventColor) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.calendarEventColor = calendarEventColor;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public CalendarEventColor getCalendarEventColor() {
        return calendarEventColor;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.getId() + ", startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ", calendarEventColor=" + this.getCalendarEventColor() + '}';
    }
}