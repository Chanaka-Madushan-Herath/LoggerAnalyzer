package com.make.construction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String testString = null;
        if (testString != null)
            System.out.println(testString.equals("F"));


    }

}


class SecondLine {

    private BufferedReader bufferedReader;
    public SecondLine(BufferedReader bufferedReader){

        this.bufferedReader = bufferedReader;

    }

    public void print() throws IOException {

        System.out.println(bufferedReader.readLine());


    }
}

