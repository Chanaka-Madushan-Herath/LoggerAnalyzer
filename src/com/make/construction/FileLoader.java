package com.make.construction;

import java.io.*;


public class FileLoader {


    private String filePath;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public FileLoader(String filePath) {
        this.filePath = filePath;
    }

    public void openFile() throws FileNotFoundException {
        this.fileReader = new FileReader(filePath);
        this.bufferedReader = new BufferedReader(fileReader);
    }

    public void readFile() throws IOException {

        String line;
        boolean errorState = false;

        while ((line = this.bufferedReader.readLine()) != null){

            if(line.equals("ERROR")){
                System.out.println("ERROR");
                errorState = true;
            }

        }
        if (errorState){

            Runnable runnable = () -> {EmailSender emailSender = new EmailSender();emailSender.send();};
            Thread thread = new Thread(runnable);
            thread.start();

        }

        this.recordTimeStamp();
    }

    private void recordTimeStamp() {




    }




}
