package com.healthMonitoring;

public class Doctor {
    private int id;
    private String name;
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Doctor{id=" + id + ", name='" + name + "', specialization='" + specialization + "'}";
    }
}

class Cardiologist extends Doctor {
    public Cardiologist(int id, String name) {
        super(id, name, "Cardiologist");
    }
}

class Dermatologist extends Doctor {
    public Dermatologist(int id, String name) {
        super(id, name, "Dermatologist");
    }
}


