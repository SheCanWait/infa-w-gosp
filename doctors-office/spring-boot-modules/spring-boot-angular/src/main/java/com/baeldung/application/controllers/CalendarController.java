package com.baeldung.application.controllers;

import com.baeldung.application.entities.CalendarEvent;
import com.baeldung.application.entities.LoginData;
import com.baeldung.application.repositories.CalendarRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CalendarController {

    private final CalendarRepository calendarRepository;

    public CalendarController(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @PostMapping("/get-calendar")
    public List<CalendarEvent> login(@RequestBody String username) {
        return calendarRepository.getCalendarEventsByUsername(username);
    }
}
