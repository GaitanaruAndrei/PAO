package com.cabinet.services;

import com.cabinet.models.fisa.Medicament;
import com.cabinet.models.plata.Card;

import java.io.*;

public class FileTextServiceCard {
    private static FileTextServiceCard ourInstance = new FileTextServiceCard();
    private FileTextServiceCard(){

    }
    public static FileTextServiceCard getInstance(){
        return  ourInstance;
    }

    public void writeTextToFile( String textToWrite , String fileNamePath){

        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileNamePath));
            printWriter.println(textToWrite);
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Card readTextFromFile(String fileNamePath){
        Card card  = null;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileNamePath));
            String line = lineNumberReader.readLine();
            String[] values = line.split(",");

            card = new Card(Integer.parseInt(values[0]),values[1]);

            lineNumberReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return card;
    }
}
