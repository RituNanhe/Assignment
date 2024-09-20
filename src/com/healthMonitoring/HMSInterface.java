package com.healthMonitoring;

import java.time.LocalDate;
import java.time.LocalTime;

public interface HMSInterface {
    void registerPatient(Patient patient);
    void scheduleAppointment(int appointmentId, int doctorId, LocalDate date, LocalTime time);
    void updatePatientVitals(int patientId, double bloodPressure, double heartRate);
    void retrieveSortedPatientsByAge();
}
