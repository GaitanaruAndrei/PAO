package com.cabinet.services;

import com.cabinet.models.fisa.Medicament;
import com.cabinet.models.plata.Card;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTextServiceCard {
    private static FileTextServiceCard ourInstance = new FileTextServiceCard();
    private FileTextServiceCard(){

    }
    public static FileTextServiceCard getInstance(){
        return  ourInstance;
    }

    public void writeTextToFile( String textToWrite , String fileNamePath){

        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileNamePath, true));
            printWriter.println(textToWrite);
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Card readTextFromFile(String fileNamePath,Integer positionLine){
        Card card  = null;
        try {
            String line = Files.readAllLines(Paths.get("files/card.csv")).get(positionLine);

            String[] values = line.split(",");

            card = new Card(Integer.parseInt(values[0]),values[1]);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }

        return card;
    }
}
