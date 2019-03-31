package com.cabinet.models.FisaMedicala;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FisaMedicala {
    private Integer id_fisa;
    private LocalDate dataInceput;
    private LocalDate dataFinal;
    private String Diagnostic;
    private String procedura;
    private List<String> medicamente ;
    public FisaMedicala()
    {
        this.id_fisa = null;
        this.dataInceput = null;
        this.dataFinal = null;
        this.Diagnostic = "";
        this.procedura = "";
        this.medicamente = new ArrayList<>();
    }

    public FisaMedicala(Integer id_fisa, LocalDate dataInceput, LocalDate dataFinal, String diagnostic, String procedura, List<String> medicamente) {
        this.id_fisa = id_fisa;
        this.dataInceput = dataInceput;
        this.dataFinal = dataFinal;
        this.Diagnostic = diagnostic;
        this.procedura = procedura;
        this.medicamente = medicamente;
    }
public void adaugaDataInceput()
{


        System.out.println("Data inceput ");

        Scanner sc= new Scanner(System.in);
        System.out.println("Anul");
        int an = sc.nextInt();
        System.out.println("Luna");
        int luna = sc.nextInt();
        System.out.println("Zi");
        int zi = sc.nextInt();
        LocalDate data = LocalDate.of(an, luna, zi);
        this.dataInceput = data;

}

    public void adaugaDataFinal()
    {

            System.out.println("Data final ");

            Scanner sc= new Scanner(System.in);
            System.out.println("Anul");
            int an = sc.nextInt();
            System.out.println("Luna");
            int luna = sc.nextInt();
            System.out.println("Zi");
            int zi = sc.nextInt();
            LocalDate data = LocalDate.of(an, luna, zi);
            this.dataFinal = data;

    }


    public void adaugaMedicament() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cate medicamente adaugati?");
        int numar = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numar; i++) {
            System.out.println("Denumire medicament");

            String denumire = sc.nextLine();

            if (this.medicamente != null) this.medicamente.add(denumire);
            else {
                this.medicamente = new ArrayList<String>();
                this.medicamente.add(denumire);
            }
        }
    }
        public void afiseazaMedicamente()
        {
            for ( String m : this.medicamente)
            {
                System.out.println(m);
            }
        }

    public Integer getId_fisa() {
        return id_fisa;
    }

    public void setId_fisa(Integer id_fisa) {
        this.id_fisa = id_fisa;
    }

    public LocalDate getDataInceput() {
        return dataInceput;
    }

    public void setDataInceput(LocalDate dataInceput) {
        this.dataInceput = dataInceput;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
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

    public List<String> getMedicamente() {
        return medicamente;
    }

    public void setMedicamente(List<String> medicamente) {
        this.medicamente = medicamente;
    }

    @Override
    public String toString() {
        return "FisaMedicala{" +
                "id_fisa=" + id_fisa +
                ", dataInceput=" + dataInceput +
                ", dataFinal=" + dataFinal +
                ", Diagnostic='" + Diagnostic + '\'' +
                ", procedura='" + procedura + '\'' +
                ", medicamente=" + medicamente +
                '}';
    }
}
