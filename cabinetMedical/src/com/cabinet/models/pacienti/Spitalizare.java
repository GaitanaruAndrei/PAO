package com.cabinet.models.pacienti;

public class Spitalizare {
    private Integer costSpitalizare;
    private Integer numarZileSpitalizare;

    public Spitalizare() {
        this.costSpitalizare = null;
        this.numarZileSpitalizare=null;
    }

    public Spitalizare(Integer costSpitalizare, Integer numarZileSpitalizare) {
        this.costSpitalizare = costSpitalizare;
        this.numarZileSpitalizare = numarZileSpitalizare;
    }

    public Integer getCostSpitalizare() {
        return costSpitalizare;
    }

    public void setCostSpitalizare(Integer costSpitalizare) {
        this.costSpitalizare = costSpitalizare;
    }

    public Integer getNumarZileSpitalizare() {
        return numarZileSpitalizare;
    }

    public void setNumarZileSpitalizare(Integer numarZileSpitalizare) {
        this.numarZileSpitalizare = numarZileSpitalizare;
    }

    @Override
    public String toString() {
        return "Spitalizare{" +
                "costSpitalizare=" + costSpitalizare +
                ", numarZileSpitalizare=" + numarZileSpitalizare +
                '}';
    }
}
