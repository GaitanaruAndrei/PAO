package com.cabinet.models.Programare;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ProgramarePacient extends  Programare {

    private String numeMedic;
    private Integer varsta;
    private Integer greutate;
    private Integer inaltime;

    public ProgramarePacient(LocalDateTime dataProgramare, String numeMedic, Integer varsta, Integer greutate, Integer inaltime) {
        super(dataProgramare);
        this.numeMedic = numeMedic;
        this.varsta = varsta;
        this.greutate = greutate;
        this.inaltime = inaltime;
    }
    public ProgramarePacient()
    {
        super(null);
        this.numeMedic ="";
        this.varsta = null;
        this.greutate = null;
        this.inaltime =null;

    }

    @Override
    public void organizareProgramare() {
        super.organizareProgramare();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nume medic");
        this.numeMedic=sc.nextLine();
        System.out.println("Varsta");
        this.varsta=sc.nextInt();
        System.out.println("Greutate");
        this.greutate=sc.nextInt();
        System.out.println("Inaltime");
        this.inaltime=sc.nextInt();

    }

    public String getNumeMedic() {
        return numeMedic;
    }

    public void setNumeMedic(String numeMedic) {
        this.numeMedic = numeMedic;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public Integer getGreutate() {
        return greutate;
    }

    public void setGreutate(Integer greutate) {
        this.greutate = greutate;
    }

    public Integer getInaltime() {
        return inaltime;
    }

    public void setInaltime(Integer inaltime) {
        this.inaltime = inaltime;
    }

    @Override
    public String toString() {
        return "ProgramarePacient{" +
                "numeMedic='" + numeMedic + '\'' +
                ", varsta=" + varsta +
                ", greutate=" + greutate +
                ", inaltime=" + inaltime +
                '}';
    }
}
