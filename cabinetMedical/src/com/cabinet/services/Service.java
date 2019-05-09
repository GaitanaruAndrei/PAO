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
import com.cabinet.models.utilizatori.User;

import java.security.SecurityPermission;
import java.util.*;
import java.sql.Timestamp;

public class Service {
    private  ArrayList<User> utilizatori = new ArrayList<User>();
    private  Medic[] medic = new Medic[10];
    private  User[] user = new User[5];
    private  Pacient[] pacient = new Pacient[10];
    private  NotaPlata[] nota =new NotaPlata[3];
    private static Card[] card = new Card[3];
    private  Medicament[] medicament = new Medicament[3];
    private  Spitalizare[] spitalizares = new Spitalizare[3];

    private static  Service instance= new Service();

    private  Service(){

       nota[0] =  FileTextServiceNotaPlata.getInstance().readTextFromFile("files/notaPlata.csv",0);
       nota[1] =  FileTextServiceNotaPlata.getInstance().readTextFromFile("files/notaPlata.csv",1);
       card[0] = FileTextServiceCard.getInstance().readTextFromFile("files/card.csv",1);
       card[1] = FileTextServiceCard.getInstance().readTextFromFile("files/card.csv",1);
       medicament[0] = FileTextServiceMedicament.getInstance().readTextFromFile("files/medicament.csv",0);
       medicament[1] = FileTextServiceMedicament.getInstance().readTextFromFile("files/medicament.csv",1);
      spitalizares[0] = FileTextServiceSpitalizare.getInstance().readTextFromFile("files/spitalizare.csv",0);
      spitalizares[1] = FileTextServiceSpitalizare.getInstance().readTextFromFile("files/spitalizare.csv",1);
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

   user[0] = new Medic(1,"Andrei","Gaitanaru","nume1","08882213","aleea Olanesti ",programare,d,"aa,","specialitate");
   user[1] = new Medic(2,"ION","Gaitanaru","nume2","08882213","aleea Olanesti ",programare,d,"aa,","specialitate");
    user[2] = new PacientCopil(3,"Username","Parola","nume3","telefon","adresa",programare,11,listaFisa,factura,spitalizare,card[0],"numeMama","Numetata");
    user[3] = new PacientCopil(4,"Username2","Parola","nume4","telefon","adresa",programare,11,listaFisa,factura,spitalizare,card[0],"numeMama","Numetata");
    user[4] = new PacientBatran(4,"Username2","Parola","nume5","telefon","adresa",programare,11,listaFisa,factura,spitalizare,card[0],true,"a","b");

     for (int i = 0 ; i < 5; i++){
         utilizatori.add(user[i]);
     }
     Collections.sort(utilizatori);



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
        for (int i = 0; i < user.length; i++) {
            String name = user[i].getClass().getSimpleName();
          if (name.equals("Medic") )
              number++;
        }

        return number;

    }
    public int catiUtilizatoriSuntPacientiBatran(){

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        int number = 0;
        for (int i = 0; i < user.length; i++) {
            String name = user[i].getClass().getSimpleName();
            if (name.equals("PacientBatran") )
                number++;
        }

        return number;

    }
    public void  afiseazaProgramariPacient( String numePacient) {

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object() {
        }.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        int number = 0;
        int ok = 0;

        for (int i = 0; i < user.length; i++) {
            String name = user[i].getClass().getSimpleName();
            if ((name.equals("PacientBatran") || (name.equals("PacientCopil"))) && user[i].getNume().equals(numePacient)) {

                List<Programare> lista = user[i].getProgramare();
                if(lista.size() == 0) System.out.println("Pacientul: " + user[i].getNume() + " nu are programari");
                else {
                    System.out.println("Pacientul: " + user[i].getNume() + " are");
                    System.out.println(lista);

                }

            } else ok = 1;



        } if (ok == 0) System.out.println("Pacientul nu exista");
    }
    public int catiUtilizatoriSuntPacientCopil(){

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        int number = 0;
        for (int i = 0; i < user.length; i++) {
            String name = user[i].getClass().getSimpleName();
            if (name.equals("PacientCopil") )
                number++;

        }

        return number;

    }
    public void afiseazaPacientDupaNume(String numePacient){

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        int ok =0;
        for (int i = 0; i < user.length; i++) {
            String name = user[i].getNume();
            if (name.equals(numePacient) ) {
                System.out.println(user[i]);
                ok = 1;
            }


        }
        if (ok == 0) System.out.println("Pacientul nu exista");

    }
    public void afiseazaMedicDupaNume(String numePacient){

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        int ok =0;
        for (int i = 0; i < user.length; i++) {
            String name = user[i].getNume();
            String clasa =user[i].getClass().getSimpleName();
            if (name.equals(numePacient) &&  clasa.equals("Medic")) {
                System.out.println(user[i]);
                ok = 1;
            }


        }
        if (ok == 0) System.out.println("Medicul nu exista");

    }
    public int catiUtilizatoriSuntPacientiBatrani(){

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(new Object(){}.getClass().getEnclosingMethod().getName()).
                append(",").append(new Timestamp(System.currentTimeMillis()));
        FileTextServiceTimesApel.getInstance().writeTextToFile(stringBuilder.toString(),
                "files/times.csv");

        int number = 0;
        for (int i = 0; i < user.length; i++)
            if (user[i].getClass().getName().equals("PacientBatran"))
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
            if (user[i].getClass().getName().equals("PacientCopil"))
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

