package com.cabinet.services;

import com.cabinet.models.fisa.Medicament;

import java.io.*;

public class FileTextServiceMedicament {

    private static FileTextServiceMedicament ourInstance = new FileTextServiceMedicament();
    private FileTextServiceMedicament(){

    }
    public static FileTextServiceMedicament getInstance(){
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

    public Medicament readTextFromFile(String fileNamePath){
        Medicament medicament  = null;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileNamePath));
            String line = lineNumberReader.readLine();
            String[] values = line.split(",");

            medicament = new Medicament(values[0]);

            lineNumberReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return medicament;
    }
}
