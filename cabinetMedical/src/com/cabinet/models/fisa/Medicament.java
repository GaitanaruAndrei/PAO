package com.cabinet.models.fisa;

public class Medicament {

    private String denumireMedicament;

    public Medicament(String denumireMedicament) {
        this.denumireMedicament = denumireMedicament;
    }

    public String getDenumireMedicament() {
        return denumireMedicament;
    }

    public void setDenumireMedicament(String denumireMedicament) {
        this.denumireMedicament = denumireMedicament;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "denumireMedicament='" + denumireMedicament + '\'' +
                '}';
    }
}
