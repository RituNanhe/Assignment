package com.healthMonitoring;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HMSService hmsService = new HMSService();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHealth Monitoring System");
            System.out.println();
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Update Patient Vitals");
            System.out.println("4. Retrieve Sorted Patients by Age");
            System.out.println("5. Retrieve Appointments by Doctor ID");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
         
            switch (choice) {
                case 1:// Register Patient
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter Patient Age: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Patient Gender: (M/F)");
                    String patientGender = scanner.nextLine();
                    System.out.print("Enter Medical History: ");
                    String medicalHistory = scanner.nextLine();

                    Patient newPatient = new Patient(patientId, patientName, patientAge, patientGender, medicalHistory);
                    hmsService.registerPatient(newPatient);
                    break;

                case 2:// Schedule Appointment
                    System.out.print("Enter Appointment ID: ");
                    int appointmentId = scanner.nextInt();
                    System.out.print("Enter Doctor ID: ");
                    int doctorId = scanner.nextInt();
                    System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
                    LocalDate appointmentDate = LocalDate.parse(scanner.next());
                    System.out.print("Enter Appointment Time (HH:MM): ");
                    LocalTime appointmentTime = LocalTime.parse(scanner.next());

                    hmsService.scheduleAppointment(appointmentId, doctorId, appointmentDate, appointmentTime);
                    System.out.println();
                    break;

                case 3:// Update Patient Vitals
                    System.out.print("Enter Patient ID: ");
                    int updatePatientId = scanner.nextInt();
                    System.out.print("Enter Blood Pressure: ");
                    double bloodPressure = scanner.nextDouble();
                    System.out.print("Enter Heart Rate: ");
                    double heartRate = scanner.nextDouble();

                    hmsService.updatePatientVitals(updatePatientId, bloodPressure, heartRate);
                    break;

                case 4:// Retrieve Sorted Patients by Age
                    hmsService.retrieveSortedPatientsByAge();
                    break;

                case 5: // Retrieve Appointments by Doctor ID
                    System.out.print("Enter Doctor ID: ");
                    int searchDoctorId = scanner.nextInt();
                    hmsService.retrieveAppointmentsByDoctor(searchDoctorId);
                    break;

                case 6:// Cancel Appointment
                    System.out.print("Enter Appointment ID to Cancel: ");
                    int cancelAppointmentId = scanner.nextInt();
                    hmsService.cancelAppointment(cancelAppointmentId);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
