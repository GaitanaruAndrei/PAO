package com.cabinet.services;

import com.cabinet.models.plata.NotaPlata;

import java.io.*;

public class FileTextServiceNotaPlata {

    private static FileTextServiceNotaPlata ourInstance = new FileTextServiceNotaPlata();
    private FileTextServiceNotaPlata(){

    }
    public static FileTextServiceNotaPlata getInstance(){
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

    public  NotaPlata readTextFromFile(String fileNamePath){
        NotaPlata nota = null;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileNamePath));
            String line = lineNumberReader.readLine();
            String[] values = line.split(",");

            nota = new NotaPlata(values[0],Integer.parseInt(values[1]));

            lineNumberReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return nota;
    }
}
