package com.cabinet.models.pacienti;

import com.cabinet.models.fisa.FisaMedicala;
import com.cabinet.models.plata.Card;
import com.cabinet.models.plata.NotaPlata;
import com.cabinet.models.programare.Programare;


import java.util.Date;
import java.util.List;

public class PacientBatran extends Pacient {
    private boolean fumator;
    private String factoriRisc;
    private String antecedente;

    public PacientBatran() {
        super(null, null, null, null, null,null, null,null,null, null, null, null);
        this.fumator =false;
        this.factoriRisc = null;
        this.antecedente = null;
    }
    public PacientBatran(boolean fumator, String factoriRisc, String antecedente) {
        this.fumator = fumator;
        this.factoriRisc = factoriRisc;
        this.antecedente = antecedente;
    }

    public PacientBatran(Integer id, String username, String parola, String nume, String telefon, String adresa, List<Programare> programare, Integer varsta, List<FisaMedicala> reteta, List<NotaPlata> factura, Spitalizare spitalizare, Card card, boolean fumator, String factoriRisc, String antecedente) {
        super(id, username, parola, nume, telefon, adresa, programare, varsta, reteta, factura, spitalizare, card);
        this.fumator = fumator;
        this.factoriRisc = factoriRisc;
        this.antecedente = antecedente;
    }
}
