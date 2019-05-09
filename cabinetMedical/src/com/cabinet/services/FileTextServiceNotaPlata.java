package com.cabinet.services;

import com.cabinet.models.plata.NotaPlata;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTextServiceNotaPlata {

    private static FileTextServiceNotaPlata ourInstance = new FileTextServiceNotaPlata();
    private FileTextServiceNotaPlata(){

    }
    public static FileTextServiceNotaPlata getInstance(){
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

    public  NotaPlata readTextFromFile(String fileNamePath,Integer positionLine){
        NotaPlata nota = null;
        try {
            String line = Files.readAllLines(Paths.get("files/notaPlata.csv")).get(positionLine);

            String[] values = line.split(",");

            nota = new NotaPlata(values[0],Integer.parseInt(values[1]));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return nota;
    }
}
