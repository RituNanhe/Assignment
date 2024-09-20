package com.healthMonitoring;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HMSService implements HMSInterface {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public HMSService() {
        loadPatientsFromCSV("src/Patients.csv");
        loadDoctorsFromCSV("src/Doctors.csv");
        loadAppointmentsFromCSV("src/Appointments.csv");
    }

    @Override
    public void registerPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient registered: " + patient);
    }

    @Override
    public void scheduleAppointment(int appointmentId, int doctorId, LocalDate date, LocalTime time) {
        if (isDoctorAvailable(doctorId, date, time)) {
            appointments.add(new Appointment(appointmentId, doctorId, date, time));
            System.out.println("Appointment scheduled successfully.");
        } else {
            System.out.println("Doctor is not available at the selected time. Please choose a different time.");
        }
    }

    private boolean isDoctorAvailable(int doctorId, LocalDate date, LocalTime time) {
        for (Appointment appointment : appointments) {
            if (appointment.getDoctorId() == doctorId && appointment.getDate().equals(date) && appointment.getTime().equals(time)) {
                return false; // Doctor is not available
            }
        }
        return true; 
    }

    @Override
    public void updatePatientVitals(int patientId, double bloodPressure, double heartRate) {
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                patient.updateVitalSigns(bloodPressure, heartRate);
                System.out.println("Updated vitals for patient: " + patient);
                return;
            }
        }
        System.out.println("Patient ID not found.");
    }

    @Override
    public void retrieveSortedPatientsByAge() {
        patients.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        System.out.println("Sorted Patients by Age: " + patients);
    }

    public void loadPatientsFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true; 
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; 
                    continue;
                }
                line = line.trim();
                if (line.isEmpty()) continue; 

                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                int age = Integer.parseInt(values[2]);
                String gender = values[3];
                String medicalHistory = values[4];
                patients.add(new Patient(id, name, age, gender, medicalHistory));
            }
        } catch (IOException e) {
            System.out.println("Error reading patients CSV: " + e.getMessage());
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Error parsing patient data: " + e.getMessage());
        }
    }

    public void loadDoctorsFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true; 
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; 
                    continue;
                }
                line = line.trim();
                if (line.isEmpty()) continue; 

                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                String specialization = values[2];
                doctors.add(new Doctor(id, name, specialization));
            }
        } catch (IOException e) {
            System.out.println("Error reading doctors CSV: " + e.getMessage());
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Error parsing doctor data: " + e.getMessage());
        }
    }

    public void loadAppointmentsFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true; 
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; 
                    continue;
                }
                line = line.trim();
                if (line.isEmpty()) continue; 

                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                int doctorId = Integer.parseInt(values[1]);
                LocalDate date = LocalDate.parse(values[2]);
                LocalTime time = LocalTime.parse(values[3]);
                appointments.add(new Appointment(id, doctorId, date, time));
            }
        } catch (IOException e) {
            System.out.println("Error reading appointments CSV: " + e.getMessage());
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Error parsing appointment data: " + e.getMessage());
        }
    }

    public void retrieveAppointmentsByDoctor(int doctorId) {
        boolean hasAppointments = false;
        for (Appointment appointment : appointments) {
            if (appointment.getDoctorId() == doctorId) {
                System.out.println(appointment);
                hasAppointments = true;
            }
        }
        if (!hasAppointments) {
            System.out.println("No appointments found for Doctor ID: " + doctorId);
        }
    }

    public void cancelAppointment(int appointmentId) {
        appointments.removeIf(appointment -> appointment.getId() == appointmentId);
        System.out.println("Cancelled appointment: " + appointmentId);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}
