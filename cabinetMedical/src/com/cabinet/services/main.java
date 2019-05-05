package com.cabinet.services;


import com.cabinet.models.pacienti.PacientBatran;
import com.cabinet.models.plata.Card;
import com.cabinet.models.plata.NotaPlata;
import com.cabinet.models.programare.Programare;
import com.cabinet.models.utilizatori.User;

import java.util.*;

public class main {
    public static void main(String[] args) {

        /*
System.out.println("------MENIU------");
System.out.println("0.LOGIN MEDIC");
System.out.println("1.LOGIN PACIENT ");
System.out.println("2.Adauga Medic");
System.out.println("3.Adauga Pacient");
System.out.println("4.Afiseaza Medici");
System.out.println("5.Afiseaza Pacienti");
System.out.println("6.Cauta medic ");
System.out.println("7.Cauta pacienti");
System.out.println("8.Fa o programare");
System.out.println("9.Afiseaza facturi dupa ID");
System.out.println("10.Afiseaza fise medicale dupa ID");
System.out.println("11.Afiseaza programari pacienti");
System.out.println("12.Afiseaza programari medici");
System.out.println("13.IESIRE");

boolean ok  = true;
Scanner sc = new Scanner(System.in);
Services cabinet = Services.getInstance();
while (ok)
{
    System.out.println("Introdu caz");
    Integer nr = sc.nextInt();
    sc.nextLine();
    switch (nr)
    {
        case 0:
        {
            System.out.println("Username:");
            String username = sc.nextLine();
            System.out.println("Parola:");
            String parola = sc.nextLine();
            cabinet.loginMedic(username,parola);
            break;
        }
        case 1:
        {
            System.out.println("Username:");
            String username = sc.nextLine();
            System.out.println("Parola:");
            String parola = sc.nextLine();
            cabinet.loginPacient(username,parola);
            break;
        }
        case 2:
        {
            cabinet.adaugaMedic();
            break;
        }
        case 3:
        {
            cabinet.adaugaPacient();
            break;
        }
        case 4:
        {
            cabinet.listaMedici();
            break;
        }
        case 5:
        {
            cabinet.listaPacienti();
            break;
        }
        case 6:
        {
            System.out.println("Id medic cautat :");
             Integer id = sc.nextInt();
             cabinet.cautaMedicId(id);
             break;

        }
        case 7:
        {
            System.out.println("Id pacient cautat :");
            Integer id = sc.nextInt();
            cabinet.cautaPacientId(id);
            break;

        }
        case 8:
        {
            System.out.println("Id medic cautat :");
            Integer id = sc.nextInt();
            cabinet.faProgramare(id);
            break;

        }
        case 9:
        {
            System.out.println("Id medic cautat :");
            Integer id = sc.nextInt();
            cabinet.afiseazaFacturiPacienti(id);
            break;

        }

        case 10:
        {
            System.out.println("Id medic cautat :");
            Integer id = sc.nextInt();
            cabinet.afiseazaFiseMedicalePacienti(id);
            break;

        }
        case 11 :
        {
            cabinet.afiseazaProgramariPacienti();
            break;
        }
        case 12 :
        {
            cabinet.afiseazaProgramariMedici();
            break;
        }
        case 13:
        {
            System.out.println("La revedere");
            ok = false;
            break;
        }




    }



}








//*/
//        Calendar calendar =Calendar.getInstance();
//        calendar.set(1997,2,12);
//        Date dataNastere = calendar.getTime();
//
//        Programare programare = new Programare();
//        programare.organizareProgramare();
//        List<Programare> listaProgramare = new ArrayList<Programare>();
//        listaProgramare.add(programare);
//
//
//
//        User user = new User(1,"a","b","c","d","aa",listaProgramare,dataNastere);
//        StringBuilder stringBuilder= new StringBuilder("");
//        stringBuilder.append(user.getId()).append(",").append(user.getUsername()).append(",").append(user.getPassword()).append(",").append(user.getNume()).
//                append(",").append(user.getTelefon()).append(",").append(user.getAdresa()).append(",").append(user.getProgramare()
//        ).append(",").append(user.getDataNastere());
//        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(), "/Users/GaitanaruAndrei/Desktop/librarymanagementjava/cabinetMedical/files/user.csv");
//        User user2=new User();
//        user2 =FileTextService.getInstance().readUserFromFile("/Users/GaitanaruAndrei/Desktop/librarymanagementjava/cabinetMedical/files/user.csv");
//        FileSerializableService.getInstance().writeObjectToFile(user,"/Users/GaitanaruAndrei/Desktop/librarymanagementjava/cabinetMedical/files/user.csv");
//        User user3 = new User();
//        user3 =(User) FileSerializableService.getInstance().readObjectFromFile("/Users/GaitanaruAndrei/Desktop/librarymanagementjava/cabinetMedical/files/user.csv");
//        System.out.println(user3);
//
        System.out.println(Service.getInstance().catiUtilizatoriSuntMedici());
        System.out.println(Service.getInstance().catiUtilizatoriSuntPacientiBatrani());
        System.out.println(Service.getInstance().catiUtilizatoriSuntPacientiCopil());
        Service.getInstance().afiseazaUtilizatoriSortati();






    }
}
