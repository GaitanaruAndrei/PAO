package com.cabinet.services;

import com.cabinet.models.fisa.FisaMedicala;
import com.cabinet.models.fisa.Medicament;
import com.cabinet.models.medic.Medic;
import com.cabinet.models.pacienti.Pacient;
import com.cabinet.models.pacienti.PacientBatran;
import com.cabinet.models.pacienti.PacientCopil;
import com.cabinet.models.pacienti.Spitalizare;
import com.cabinet.models.plata.Card;
import com.cabinet.models.plata.NotaPlata;
import com.cabinet.models.programare.Programare;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Service3 {


    private static List<Medicament> medicamentList = new ArrayList<>();
    private static List<NotaPlata> notaPlataList = new ArrayList<>();
    private static List<Spitalizare> spitalizareList = new ArrayList<>();
    private static List<Medic> medicList = new ArrayList<>();
    private static List<Pacient> pacientList = new ArrayList<>();
    private static Card[] cardList = new Card[3];
    private static final Service3 instance  = new Service3();
    public static Service3 getInstance(){
        return  instance;
    }

    public  Service3(){
        List<Programare> programare = new ArrayList<Programare>();
        Date d = new Date();
        List<FisaMedicala>listaFisa= new ArrayList<FisaMedicala>();
        FisaMedicala fisa =  new FisaMedicala(1,"a","b",null);
        Medicament medicament = new Medicament("algocalmin");
        List<Medicament> m = new ArrayList<Medicament>();
        m.add(medicament);
        fisa.setMedicamente(m);
        listaFisa.add(fisa);

        List<NotaPlata> factura = new ArrayList<NotaPlata>();
        NotaPlata nota1 = new NotaPlata("card",100);
        factura.add(nota1);
        //   Card card = new Card(1,"aa");
        Spitalizare spitalizare = new Spitalizare();
       cardList[0]= new Card(1121,"Andrei");
        cardList[1] = new Card(1234,"Ion");
        medicList.add( new Medic(1,"Andrei","Gaitanaru","nume1","08882213","aleea Olanesti ",programare,d,"aa,","specialitate"));
        medicList.add( new Medic(2,"Ion","Gaitanaru","nume1","08882213","aleea Olanesti ",programare,d,"aa,","specialitate"));
        medicList.add( new Medic(3,"Vasile","Gaitanaru","nume1","08882213","aleea Olanesti ",programare,d,"aa,","specialitate"));
        pacientList.add(new PacientCopil(3,"Username","Parola","Andrei","telefon","adresa",programare,11,listaFisa,factura,spitalizare,cardList[1],"numeMama","Numetata"));
        pacientList.add(new PacientBatran(4,"Username2","Parola","nume5","telefon","adresa",programare,11,listaFisa,factura,spitalizare,cardList[0],true,"a","b"));
        pacientList.add(new PacientCopil(11,"Username","Parola","Andrei","telefon","adresa",programare,11,listaFisa,factura,spitalizare,cardList[1],"numeMama","Numetata"));
        pacientList.add(new PacientBatran(4,"Username2","Parola","NICOLAE RADU","telefon","adresa",programare,11,listaFisa,factura,spitalizare,cardList[0],true,"a","b"));
    }

    public List<Pacient> pacientiCopii(){

        List<Pacient> childList = new ArrayList<>();
        for (Pacient pacient : pacientList) {
            if (pacient.getClass() == PacientCopil.class) {
                childList.add(pacient);
            }
        }

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        return  childList;
    }
    public List<Medic> medici(){

        List<Medic> medicL= new ArrayList<>();
        for (Medic medic : medicList) {
            if (medic.getClass() == Medic.class) {
                medicL.add(medic);
            }
        }

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        return  medicL;
    }

    public List<Pacient> pacientiBatrani(){

        List<Pacient> oldList = new ArrayList<>();
        for (Pacient pacient : pacientList) {
            if (pacient.getClass() == PacientBatran.class) {
                oldList.add(pacient);
            }
        }

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        return  oldList;
    }
    public void orderPatients() {

        Collections.sort(pacientList);
        for (Pacient pacient : pacientList)
            System.out.println(pacient);
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
    }

    public void orderMedics() {

        Collections.sort(medicList);
        for (Medic medic : medicList)
            System.out.println(medic);
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");
    }




}
