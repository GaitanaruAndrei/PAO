package com.cabinet.services;

import com.cabinet.models.fisa.Medicament;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTextServiceMedicament {

    private static FileTextServiceMedicament ourInstance = new FileTextServiceMedicament();
    private FileTextServiceMedicament(){

    }
    public static FileTextServiceMedicament getInstance(){
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

    public Medicament readTextFromFile(String fileNamePath,Integer positionLine){
        Medicament medicament  = null;
        try {
            String line = Files.readAllLines(Paths.get("files/medicament.csv")).get(positionLine);

            String[] values = line.split(",");

            medicament = new Medicament(values[0]);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return medicament;
    }
}
