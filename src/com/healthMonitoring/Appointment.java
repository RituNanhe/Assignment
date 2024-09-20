package com.healthMonitoring;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int id;
    private int doctorId;
    private LocalDate date;
    private LocalTime time;

    public Appointment(int id, int doctorId, LocalDate date, LocalTime time) {
        this.id = id;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Appointment{id=" + id + ", doctorId=" + doctorId + ", date=" + date + ", time=" + time + "}";
    }
}
