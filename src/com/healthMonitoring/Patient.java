package com.healthMonitoring;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String medicalHistory;
    private double bloodPressure;
    private double heartRate;

    public Patient(int id, String name, int age, String gender, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.medicalHistory = medicalHistory;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void updateVitalSigns(double bloodPressure, double heartRate) {
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
    }

    @Override
    public String toString() {
        return "Patient{id=" + id + ", name='" + name + "', age=" + age + ", gender='" + gender + "', medicalHistory='" + medicalHistory + "'}";
    }
}
