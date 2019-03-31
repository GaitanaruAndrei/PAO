package com.cabinet.services;

import com.cabinet.models.Programare.Programare;
import com.cabinet.models.Programare.ProgramareMedic;
import com.cabinet.models.Programare.ProgramarePacient;
import com.cabinet.models.medic.Medic;
import com.cabinet.models.pacienti.Pacient;
import com.cabinet.models.utilizatori.User;

import java.util.*;

public class Services {
    private Set<Medic> medici = new HashSet<>();
    private Set<Pacient> pacienti = new HashSet<>();

    private static Services ourInstance = new Services();

    private Services()
    {

    }
    public void adaugaMedic()
    {
        System.out.println("Adauga medic:");
        Scanner sc = new Scanner(System.in);
        System.out.println("iD MEDIC:");
        Integer id_medic= sc.nextInt();
        sc.nextLine();

        System.out.println("Username:");
        String username = sc.nextLine();
        System.out.println("Parola:");
        String parola= sc.nextLine();
        System.out.println("Nume:");
        String nume = sc.nextLine();
        System.out.println("Telefon:");
        String telefon= sc.nextLine();
        System.out.println("Adresa:");
        String adresa = sc.nextLine();
        System.out.println("Departament:");
        String departament = sc.nextLine();
        System.out.println("Specialitate:");
        String specialitate = sc.nextLine();
        List<Programare>programari = new ArrayList<>();
        Programare p = new ProgramareMedic();
        p.organizareProgramare();
        programari.add(p);
        Medic nou = new Medic(id_medic,username,parola,nume,telefon,adresa,programari,departament,specialitate);
        this.medici.add(nou);





    }
    public static Services getInstance()
    {
        if (ourInstance== null)
           ourInstance = new Services();

        return ourInstance;
    }
    public void adaugaPacient()
    {
        System.out.println("Adauga pacient:");
        Scanner sc = new Scanner(System.in);
        System.out.println("iD pacient:");
        Integer id_pacient= sc.nextInt();
        sc.nextLine();

        System.out.println("Username:");
        String username = sc.nextLine();
        System.out.println("Parola:");
        String parola= sc.nextLine();
        System.out.println("Nume:");
        String nume = sc.nextLine();
        System.out.println("Telefon:");
        String telefon= sc.nextLine();
        System.out.println("Adresa:");
        String adresa = sc.nextLine();
        System.out.println("Varsta:");
        Integer varsta = sc.nextInt();
        sc.nextLine();

        List<Programare>programari = new ArrayList<>();
        Programare p = new ProgramarePacient();
        p.organizareProgramare();
        programari.add(p);
       Pacient pacient = new Pacient(id_pacient,username,parola,nume,telefon,adresa,programari,varsta,null,null);
       pacient.adaugaFisaMedicala();
       pacient.adaugaFactura();
        this.pacienti.add(pacient);

    }

    public void listaMedici()
    {
        medici.forEach(m ->System.out.println(m));
    }
    public void listaPacienti()
    {
        pacienti.forEach(p->System.out.println(p));
    }
    public void afiseazaProgramariMedici()
    {
        for ( Medic m : medici)
        {
            m.afiseazaProgramari();
        }
    }
    public void afiseazaProgramariPacienti()
    {
        for (Pacient p : pacienti)
        {
            p.afiseazaProgramari();
        }
    }
    public void faProgramare(Integer id)
    {
        for (Pacient p : pacienti)
        {
            if ( id == p.getId()) p.adaugaProgramare();
        }
    }
    public void afiseazaFacturiPacienti(Integer id )
    {
        for (Pacient p : pacienti)
        {
            if ( cautaPacientId(id) != null)
                p.afiseazaFacturi();
        }
    }
    public void afiseazaFiseMedicalePacienti(Integer id)
    {
        for (Pacient p : pacienti)
        {
            if ( cautaPacientId(id) != null)
                p.afiseazaFiseMedicale();

        }
    }
    public Pacient loginPacient(String username, String  parola) {
        for (Pacient  p :
                pacienti) {
            if (username.contentEquals(p.getUsername()) && parola.contentEquals(p.getPassword())) {
                System.out.println("Login successful. Welcome, " + p.getNume());
                return p;
            }
        }
        System.out.println("Login failed.");
        return null;
    }
    public Medic loginMedic(String username, String  parola) {
        for (Medic m :
                medici) {
            if (username.contentEquals(m.getUsername()) && parola.contentEquals(m.getPassword())) {
                System.out.println("Login successful. Welcome, " + m.getNume());
                return m;
            }
        }
        System.out.println("Login failed.");
        return null;
    }

    public Pacient cautaPacientId(Integer id )
    {
        for (Pacient p :
               pacienti) {
            if (id == p.getId()) {
                System.out.println("Exista pacientul cu numele " + p.getNume());
                return p;
            }
        }
        System.out.println("Nu exista.");
        return null;
    }
    public Medic cautaMedicId(Integer id )
    {
        for (Medic p :
                medici) {
            if (id == p.getId()) {
                System.out.println("Exista pacientul cu numele " + p.getNume());
                return p;
            }
        }
        System.out.println("Nu exista.");
        return null;
    }

}
