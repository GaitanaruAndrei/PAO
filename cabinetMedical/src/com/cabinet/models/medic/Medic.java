package com.cabinet.models.medic;

import com.cabinet.models.programare.Programare;

import com.cabinet.models.utilizatori.User;

import java.util.Date;
import java.util.List;

public class Medic extends User {
    private String departament;
    private String specialitate;

    public Medic() {
        super(null,"","","","","",null);
        this.departament = "";
        this.specialitate = "";
    }


    public Medic(Integer id, String username, String parola, String nume, String telefon, String adresa, List<Programare> programare, Date dataNastere, String departament, String specialitate) {
        super(id, username, parola, nume, telefon, adresa, programare);
        this.departament = departament;
        this.specialitate = specialitate;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getSpecialitate() {
        return specialitate;
    }

    public void setSpecialitate(String specialitate) {
        this.specialitate = specialitate;
    }

    @Override
    public String toString() {
        return "Medic{" + "nume "+ this.getNume()+'\''+"id"+this.getId()+'\''+
                "departament='" + departament + '\'' +
                ", specialitate='" + specialitate + '\'' +
                '}';
    }
}
