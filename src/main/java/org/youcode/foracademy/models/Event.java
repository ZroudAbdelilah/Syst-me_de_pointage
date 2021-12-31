package org.youcode.foracademy.models;

import java.util.Date;

public class Event {
    private long id_event;
    private String name_event;
    private Date start_date;
    private Date end_date;
    private Boolean status_event;


    public Event() {
    }

    public Event(int id_event, String name_event, Date start_date, Date end_date, Boolean status_event) {
        this.id_event = id_event;
        this.name_event = name_event;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status_event = status_event;

    }

    public Event(String name_event, Date start_date, Date end_date, Boolean status_event) {
        this.name_event = name_event;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status_event = status_event;

    }

    public Boolean getStatus_event() {
        return status_event;
    }

    public void setStatus_event(Boolean status_event) {
        this.status_event = status_event;
    }

    public long getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getName_event() {
        return name_event;
    }

    public void setName_event(String name_event) {
        this.name_event = name_event;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id_event=" + id_event +
                ", name_event='" + name_event + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
