package com.cabinet.models.pacienti;

import com.cabinet.models.FisaMedicala.FisaMedicala;
import com.cabinet.models.NotaPlata.NotaPlata;
import com.cabinet.models.Programare.Programare;
import com.cabinet.models.utilizatori.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Pacient extends User {

    private Integer varsta;
    private List<FisaMedicala> reteta;
    private List<NotaPlata> factura;
    public Pacient()
    {
        super(null,"","","","","",null);
        this.varsta = null;
        this.reteta= new ArrayList<>();
        this.factura=new ArrayList<>();
    }

    public Pacient(Integer id, String username, String parola, String nume, String telefon, String adresa, List<Programare> programare, Integer varsta, List<FisaMedicala> reteta, List<NotaPlata> factura) {
        super(id, username, parola, nume, telefon, adresa, programare);
        this.varsta = varsta;
        this.reteta = reteta;
        this.factura = factura;
    }


    public void adaugaFactura()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Metoda efectuare plata : ");
        String metoda = sc.nextLine();
        sc.nextLine();
        System.out.println("Suma de plata : ");
        Integer suma = sc.nextInt();
        NotaPlata n = new NotaPlata(metoda,suma);
        this.factura.add(n);


    }
    public void adaugaFisaMedicala() {
        Scanner sc = new Scanner(System.in);
        System.out.println("id fisa ");
        Integer id = sc.nextInt();
        sc.nextLine();
        System.out.println("Diagnostic : ");
        String diagnostic = sc.nextLine();
        System.out.println("Procedura :  ");
        String procedura= sc.nextLine();
        FisaMedicala fisa = new FisaMedicala(id,null,null,diagnostic,procedura,null);
        fisa.adaugaDataInceput();
        fisa.adaugaDataFinal();
        fisa.adaugaMedicament();
        this.reteta.add(fisa);
    }


  public void afiseazaFacturi()
  {
      factura.forEach(f -> System.out.println(f));
  }
    public  void afiseazaFiseMedicale()
    {
        for (FisaMedicala fisaMedicala : reteta)
        {
            System.out.println(fisaMedicala);

        }
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public List<FisaMedicala> getReteta() {
        return reteta;
    }

    public void setReteta(List<FisaMedicala> reteta) {
        this.reteta = reteta;
    }

    public List<NotaPlata> getFactura() {
        return factura;
    }

    public void setFactura(List<NotaPlata> factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "Pacient{"+"Nume " +this.getNume()+'\''+
                "id " + this.getId()+'\''+
                "varsta=" + varsta +
                ", reteta=" + reteta +
                ", factura=" + factura +
                '}';
    }
}

