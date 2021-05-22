package com.baeldung.application.repositories;

import com.baeldung.application.entities.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalendarRepository extends JpaRepository<CalendarEvent, Long> {

    @Query(value = "SELECT new CalendarEvent(calendarEvents.id, calendarEvents.title, calendarEvents.startDate, calendarEvents.endDate, calendarEvents.calendarEventColor) " +
            "FROM LOGIN_DATA loginData " +
            "LEFT JOIN loginData.calendarEvents calendarEvents " +
            "WHERE loginData.username=:username",
            nativeQuery = true)
    List<CalendarEvent> getCalendarEventsByUsername(@Param("username") String username);

}
