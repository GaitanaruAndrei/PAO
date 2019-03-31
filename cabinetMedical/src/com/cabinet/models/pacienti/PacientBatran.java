package com.cabinet.models.pacienti;

import com.cabinet.models.FisaMedicala.FisaMedicala;
import com.cabinet.models.NotaPlata.NotaPlata;
import com.cabinet.models.Programare.Programare;


import java.util.Date;
import java.util.List;

public class PacientBatran extends Pacient {
    private boolean fumator;
    private String factoriRisc;
    private String antecedente;

    public PacientBatran() {
        super(null, "", "", "", "", "", null, null, null, null);
        this.fumator = false;
        this.factoriRisc = "";
        this.antecedente = "";
    }

    public PacientBatran(Integer id, String username, String parola, String nume, String telefon, String adresa, List<Programare> programare, Integer varsta, List<FisaMedicala> reteta, List<NotaPlata> factura, boolean fumator, String factoriRisc, String antecedente) {
        super(id, username, parola, nume, telefon, adresa, programare, varsta, reteta, factura);
        this.fumator = fumator;
        this.factoriRisc = factoriRisc;
        this.antecedente = antecedente;
    }

    public boolean isFumator() {
        return fumator;
    }

    public void setFumator(boolean fumator) {
        this.fumator = fumator;
    }

    public String getFactoriRisc() {
        return factoriRisc;
    }

    public void setFactoriRisc(String factoriRisc) {
        this.factoriRisc = factoriRisc;
    }

    public String getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    @Override
    public String toString() {
        return "PacientBatran{" +
                "fumator=" + fumator +
                ", factoriRisc='" + factoriRisc + '\'' +
                ", antecedente='" + antecedente + '\'' +
                '}';
    }
}
