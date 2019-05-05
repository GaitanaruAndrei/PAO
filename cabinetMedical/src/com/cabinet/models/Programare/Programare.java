package com.cabinet.models.programare;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Programare {

    private LocalDateTime dataProgramare;

    public Programare() {
        this.dataProgramare = null;
    }

    public Programare(LocalDateTime dataProgramare) {
        this.dataProgramare = dataProgramare;
    }

    public void organizareProgramare()
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
        this.dataProgramare=date1;
    }


//    public  void afiseazaProgramare();

    public LocalDateTime getDataProgramare() {
        return dataProgramare;
    }

    public void setDataProgramare(LocalDateTime dataProgramare) {
        this.dataProgramare = dataProgramare;
    }


    @Override
    public String toString() {
        return "programare{" +
                "dataProgramare=" + dataProgramare +
                '}';
    }
}
