package com.cabinet.services;

import com.cabinet.models.fisa.Medicament;
import com.cabinet.models.pacienti.Spitalizare;

import java.io.*;

public class FileTextServiceSpitalizare {
    private static FileTextServiceSpitalizare ourInstance = new FileTextServiceSpitalizare();
    private FileTextServiceSpitalizare(){

    }
    public static FileTextServiceSpitalizare getInstance(){
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

    public Spitalizare readTextFromFile(String fileNamePath){
        Spitalizare spitalizare  = null;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileNamePath));
            String line = lineNumberReader.readLine();
            String[] values = line.split(",");

            spitalizare = new Spitalizare(Integer.parseInt(values[0]),Integer.parseInt(values[1]));

            lineNumberReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return spitalizare;
    }
}
