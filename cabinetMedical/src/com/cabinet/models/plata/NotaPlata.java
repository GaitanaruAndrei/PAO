package com.cabinet.models.plata;

public class NotaPlata {
    private String metodaPlata;
    private Integer suma;
    public NotaPlata()
    {
        this.metodaPlata="";
        this.suma=null;

    }
    public NotaPlata(String metodaPlata, Integer suma) {
        this.metodaPlata = metodaPlata;
        this.suma = suma;

    }

    public String getMetodaPlata() {
        return metodaPlata;
    }

    public void setMetodaPlata(String metodaPlata) {
        this.metodaPlata = metodaPlata;
    }

    public Integer getSuma() {
        return suma;
    }

    public void setSuma(Integer suma) {
        this.suma = suma;
    }


    @Override
    public String toString() {
        return "NotaPlata{" +
                "metodaPlata='" + metodaPlata + '\'' +
                ", suma=" + suma +
                '}';
    }
}
