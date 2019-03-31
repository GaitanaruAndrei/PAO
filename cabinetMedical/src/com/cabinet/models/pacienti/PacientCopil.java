package com.cabinet.models.pacienti;


import com.cabinet.models.FisaMedicala.FisaMedicala;
import com.cabinet.models.NotaPlata.NotaPlata;
import com.cabinet.models.Programare.Programare;

import java.util.Date;
import java.util.List;

public class PacientCopil extends Pacient {
    private  String numeMama;
    private  String numeTata;

    public PacientCopil() {
        this.numeMama="";
        this.numeTata="";
    }

    public PacientCopil(Integer id, String username, String parola, String nume, String telefon, String adresa, List<Programare> programare, Integer varsta, List<FisaMedicala> reteta, List<NotaPlata> factura) {
        super(id, username, parola, nume, telefon, adresa, programare, varsta, reteta, factura);
    }

    public String getNumeMama() {
        return numeMama;
    }

    public void setNumeMama(String numeMama) {
        this.numeMama = numeMama;
    }

    public String getNumeTata() {
        return numeTata;
    }

    public void setNumeTata(String numeTata) {
        this.numeTata = numeTata;
    }

    @Override
    public String toString() {
        return "PacientCopil{" +
                "numeMama='" + numeMama + '\'' +
                ", numeTata='" + numeTata + '\'' +
                '}';
    }
}
