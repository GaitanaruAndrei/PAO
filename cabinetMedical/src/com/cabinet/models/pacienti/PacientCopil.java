package com.cabinet.models.pacienti;


import com.cabinet.models.fisa.FisaMedicala;
import com.cabinet.models.plata.Card;
import com.cabinet.models.plata.NotaPlata;
import com.cabinet.models.programare.Programare;

import java.util.Date;
import java.util.List;

public class PacientCopil extends Pacient {
    private String numeMama;
    private String numeTata;


    public PacientCopil() {
        super(null, null, null, null, null, null, null, null, null, null, null, null);
        this.numeMama = null;
        this.numeTata = null;

    }

    public PacientCopil(Integer id, String username, String parola, String nume, String telefon, String adresa, List<Programare> programare, Integer varsta, List<FisaMedicala> reteta, List<NotaPlata> factura, Spitalizare spitalizare, Card card, String numeMama, String numeTata) {
        super(id, username, parola, nume, telefon, adresa, programare, varsta, reteta, factura, spitalizare, card);
        this.numeMama = numeMama;
        this.numeTata = numeTata;
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
