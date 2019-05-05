package com.cabinet.models.fisa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FisaMedicala {
    private Integer id_fisa;
    private String Diagnostic;
    private String procedura;
    private List<Medicament> medicamente ;
    public FisaMedicala()
    {
        this.id_fisa = null;
        this.Diagnostic = "";
        this.procedura = "";
        this.medicamente = new ArrayList<>();
    }

    public FisaMedicala(Integer id_fisa,  String diagnostic, String procedura, List<Medicament> medicamente) {
        this.id_fisa = id_fisa;
        this.Diagnostic = diagnostic;
        this.procedura = procedura;
        this.medicamente = medicamente;
    }
//public void adaugaDataInceput()
//{
//
//
//        System.out.println("Data inceput ");
//
//        Scanner sc= new Scanner(System.in);
//        System.out.println("Anul");
//        int an = sc.nextInt();
//        System.out.println("Luna");
//        int luna = sc.nextInt();
//        System.out.println("Zi");
//        int zi = sc.nextInt();
//        LocalDate data = LocalDate.of(an, luna, zi);
//        this.dataInceput = data;
//
//}
//
//    public void adaugaDataFinal()
//    {
//
//            System.out.println("Data final ");
//
//            Scanner sc= new Scanner(System.in);
//            System.out.println("Anul");
//            int an = sc.nextInt();
//            System.out.println("Luna");
//            int luna = sc.nextInt();
//            System.out.println("Zi");
//            int zi = sc.nextInt();
//            LocalDate data = LocalDate.of(an, luna, zi);
//            this.dataFinal = data;
//
//    }
//


    public Integer getId_fisa() {
        return id_fisa;
    }

    public void setId_fisa(Integer id_fisa) {
        this.id_fisa = id_fisa;
    }

    public String getDiagnostic() {
        return Diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        Diagnostic = diagnostic;
    }

    public String getProcedura() {
        return procedura;
    }

    public void setProcedura(String procedura) {
        this.procedura = procedura;
    }

    public List<Medicament> getMedicamente() {
        return medicamente;
    }

    public void setMedicamente(List<Medicament> medicamente) {
        this.medicamente = medicamente;
    }

    @Override
    public String toString() {
        return "FisaMedicala{" +
                "id_fisa=" + id_fisa +
                ", Diagnostic='" + Diagnostic + '\'' +
                ", procedura='" + procedura + '\'' +
                ", medicamente=" + medicamente +
                '}';
    }
}
