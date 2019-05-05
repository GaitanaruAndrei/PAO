package com.cabinet.models.plata;

public class Card {
   private Integer pin;
  private  String numeCard;

    public Card()
    {
        this.pin=null;
        this.numeCard=null;
    }
    public Card(Integer pin, String numeCard) {
        this.pin = pin;
        this.numeCard = numeCard;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public String getNumeCard() {
        return numeCard;
    }

    public void setNumeCard(String numeCard) {
        this.numeCard = numeCard;
    }

    @Override
    public String toString() {
        return "Card{" +
                "pin=" + pin +
                ", numeCard='" + numeCard + '\'' +
                '}';
    }
}
