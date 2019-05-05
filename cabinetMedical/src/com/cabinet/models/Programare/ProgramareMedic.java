package com.cabinet.models.programare;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ProgramareMedic extends Programare {

    private String numePacient;

    public ProgramareMedic(LocalDateTime dataProgramare, String numePacient) {
        super(dataProgramare);
        this.numePacient = numePacient;
    }
    public ProgramareMedic()
    {
        super(null);
        this.numePacient="";
    }

    public String getNumePacient() {
        return numePacient;
    }

    public void setNumePacient(String numePacient) {
        this.numePacient = numePacient;
    }

    @Override
    public String toString() {
        return "ProgramareMedic{" +
                "numePacient='" + numePacient + '\'' +
                '}';
    }

    @Override
    public void organizareProgramare() {
        super.organizareProgramare();
        System.out.println("Nume pacient");
        Scanner sc = new Scanner(System.in);
        this.numePacient=sc.nextLine();
    }
}
