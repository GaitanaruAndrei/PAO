package com.cabinet.models.utilizatori;

import com.cabinet.auth.Autentificare;
import com.cabinet.models.Programare.Programare;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class User implements Autentificare {
    private Integer id ;
    private String username;
    private String parola;
    private String nume ;
    private String telefon;
    private String adresa;
    private List<Programare> programare;
    public User()
    {
        this.id=null;
        this.username="";
        this.parola = "";
        this.nume = "";
        this.telefon = "";
        this.adresa = "";
        this.programare = new ArrayList<>();
    }
    public User(Integer id, String username, String parola, String nume, String telefon,  String adresa, List<Programare> programare) {
        this.id = id;
        this.username = username;
        this.parola = parola;
        this.nume = nume;
        this.telefon = telefon;
        this.adresa = adresa;
        this.programare = programare;
    }
    public  void adaugaProgramare()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adauga o programare:");
        System.out.println("Anul");
        int an =sc.nextInt();
        System.out.println("Luna");
        int luna =sc.nextInt();
        System.out.println("Zi");
        int zi =sc.nextInt();
        LocalDate data= LocalDate.of(an, luna,zi);
        System.out.println("Ora:");
        int ora= sc.nextInt();
        System.out.println("Minute:");
        int minute = sc.nextInt();
        LocalDateTime date1 = data.atTime(ora,minute);
        Programare noua = new Programare(date1);
        if (this.programare!=null) programare.add(noua);
        else{
            this.programare=new ArrayList<Programare>();
            programare.add(noua);
        }



    }
    public void afiseazaProgramari() {

        programare.forEach(p -> System.out.println(p));
    }




    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Programare> getProgramare() {
        return programare;
    }

    public void setProgramare(List<Programare> programare) {
        this.programare = programare;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", parola='" + parola + '\'' +
                ", nume='" + nume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adresa='" + adresa + '\'' +
                ", programare=" + programare +
                '}';
    }
}
