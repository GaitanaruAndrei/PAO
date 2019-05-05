package com.cabinet.services;

import com.cabinet.models.fisa.FisaMedicala;
import com.cabinet.models.fisa.Medicament;
import com.cabinet.models.medic.Medic;
import com.cabinet.models.pacienti.Pacient;
import com.cabinet.models.pacienti.PacientCopil;
import com.cabinet.models.pacienti.Spitalizare;
import com.cabinet.models.plata.Card;
import com.cabinet.models.plata.NotaPlata;
import com.cabinet.models.programare.Programare;
import com.cabinet.models.utilizatori.User;

import java.security.SecurityPermission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

public class Service {
    private static final Service instance= new Service();
    private  ArrayList<User> utilizatori = new ArrayList<User>();
    private  Medic[] medic = new Medic[10];
    private  User[] user = new User[5];
    private  Pacient[] pacient = new Pacient[10];
    private  NotaPlata[] nota =new NotaPlata[3];
    private static Card[] card = new Card[3];
    private  Medicament[] medicament = new Medicament[3];
    private  Spitalizare[] spitalizares = new Spitalizare[3];
     private  Service(){

         card[0] = new Card();
       nota[0] =  FileTextServiceNotaPlata.getInstance().readTextFromFile("files/notaPlata.csv");
       nota[1] =  FileTextServiceNotaPlata.getInstance().readTextFromFile("files/notaPlata.csv");
       card[0] = FileTextServiceCard.getInstance().readTextFromFile("files/card.csv");
       card[1] = FileTextServiceCard.getInstance().readTextFromFile("files/card.csv");
       medicament[0] = FileTextServiceMedicament.getInstance().readTextFromFile("files/medicament.csv");
       medicament[1] = FileTextServiceMedicament.getInstance().readTextFromFile("files/medicament.csv");
      spitalizares[0] = FileTextServiceSpitalizare.getInstance().readTextFromFile("files/spitalizare.csv");
      spitalizares[1] = FileTextServiceSpitalizare.getInstance().readTextFromFile("files/spitalizare.csv");
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

    medic[0] = new Medic(10,"Andrei","Gaitanaru","Gaitanaru","08882213","aleea Olanesti ",programare,d,"aa,","specialitate");
      medic[1] = new Medic(11,"ION","Gaitanaru","Gaitanaru","08882213","aleea Olanesti ",programare,d,"aa,","specialitate");
     pacient[0] = new PacientCopil(1,"Username","Parola","nume","telefon","adresa",programare,11,listaFisa,factura,spitalizare,card[0],"numeMama","Numetata");



     for (int i = 0 ; i < 5; i++){
         utilizatori.add(user[i]);
     }



}
    public  static  Service getInstance(){
        return instance;
    }

    public int catiUtilizatoriSuntMedici(){

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        int number = 0;
        for (int i = 0; i < user.length; i++)
            if (user[i].getClass().getName() == "Medic")
                number++;
        return number;

    }
    public int catiUtilizatoriSuntPacientiBatrani(){

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        int number = 0;
        for (int i = 0; i < user.length; i++)
            if (user[i].getClass().getName() == "PacientBatran")
                number++;
        return number;

    }
    public int catiUtilizatoriSuntPacientiCopil(){

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        int number = 0;
        for (int i = 0; i < user.length; i++)
            if (user[i].getClass().getName() == "PacientCopil")
                number++;
        return number;

    }


    public void afiseazaUtilizatoriSortati() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        for (User u : utilizatori) {
            System.out.println(u.getNume());
        }
    }





}

