package org.youcode.foracademy.services;

import org.youcode.foracademy.interfaceImp.EventDao;
import org.youcode.foracademy.models.Event;
import java.util.List;

//Go to the class and click alt + enter to generate jUnite tests boilerplate
public class EventService {

    private EventDao eventDao;

    public EventService() {
        this.eventDao = new EventDao();
    }

    public EventService(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public Event read(long id) {
        return eventDao.read(id);
    }

    public List<Event> readAll() {
        return eventDao.readAll();
    }

    public Event delete(Event event) {
        return eventDao.delete(event);
    }

    public Event create(Event event) {
        return eventDao.create(event);
    }

    public Event update(Event event) {
        return eventDao.update(event);
    }
}


