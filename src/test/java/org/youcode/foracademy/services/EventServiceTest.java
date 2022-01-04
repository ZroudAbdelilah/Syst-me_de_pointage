package org.youcode.foracademy.services;

import org.junit.jupiter.api.Test;
import org.youcode.foracademy.models.Event;
import org.youcode.foracademy.models.Event;
import org.youcode.foracademy.models.Event;
import org.youcode.foracademy.models.Event;
import org.youcode.foracademy.util.Utils;

import java.sql.Time;
import java.util.*;
import java.sql.Date;


import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {

    @Test
    void read() {
        EventService eventService = new EventService();
        assertInstanceOf(Event.class,eventService.read(1));
    }

    @Test
    void readAll() {
        EventService eventService = new EventService();
        ArrayList<Event> events = new ArrayList<Event>();
        assertInstanceOf(events.getClass(),eventService.readAll());
    }

    @Test
    void delete() {
        EventService eventService = new EventService();
        Event eventDelete = eventService.read(4);
        assertInstanceOf(Event.class,eventService.delete(eventDelete));
    }

    @Test
    void create() {
        /*
        EventService eventService = new EventService();
        java.util.Date dates = new java.util.Date();
        Event event1 = new Event("JJ",  dates, dates, true);
        assertInstanceOf(Event.class,eventService.create(event1));
        */
        EventService eventService = new EventService();
        Event event1 = new Event("Journée de rien", new Date(2022,3,8), new Date(2022,3,9), true);
        assertInstanceOf(Event.class,eventService.create(event1));
        /*
        EventService eventService = new EventService();
        Event event1 = new Event();
        event1.setStart_date(new Time(System.currentTimeMillis()));
        event1.setEnd_date(new Time(System.currentTimeMillis()));
        event1.setName_event("Journée de la femme");
        event1.setStatus_event(true);
 
        EventService eventService = new EventService();
        Event event1 = new Event();
        event1.setName_event("Journée de la femme");
        event1.setStart_date(null);
        event1.setEnd_date(null);
        event1.setStatus_event(true);
        assertInstanceOf(Event.class,eventService.create(event1));
        
         */
    }

    @Test
    void update() {
        EventService eventService = new EventService();
        Event eventUpdate = new Event(3,"Journée de l'homme", new Date(2022,11,19), new Date(2022,3,8), false);
        assertInstanceOf(Event.class,eventService.update(eventUpdate));
    }
}