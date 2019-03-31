package com.cabinet.services;


import com.cabinet.models.FisaMedicala.FisaMedicala;
import com.cabinet.models.Programare.Programare;
import com.cabinet.models.medic.Medic;
import com.cabinet.models.pacienti.Pacient;
import com.cabinet.models.utilizatori.User;

import javax.sound.midi.SysexMessage;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main (String [] args)
    {

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












    }
}
