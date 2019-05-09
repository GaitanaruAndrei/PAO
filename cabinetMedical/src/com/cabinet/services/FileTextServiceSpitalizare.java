package com.cabinet.services;

import com.cabinet.models.fisa.Medicament;
import com.cabinet.models.pacienti.Spitalizare;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTextServiceSpitalizare {
    private static FileTextServiceSpitalizare ourInstance = new FileTextServiceSpitalizare();
    private FileTextServiceSpitalizare(){

    }
    public static FileTextServiceSpitalizare getInstance(){
        return  ourInstance;
    }

    public void writeTextToFile( String textToWrite , String fileNamePath){

        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileNamePath,true));
            printWriter.println(textToWrite);
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Spitalizare readTextFromFile(String fileNamePath,Integer positionLine){
        Spitalizare spitalizare  = null;
        try {
            String line = Files.readAllLines(Paths.get("files/spitalizare.csv")).get(positionLine);

            String[] values = line.split(",");

            spitalizare = new Spitalizare(Integer.parseInt(values[0]),Integer.parseInt(values[1]));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return spitalizare;
    }
}
