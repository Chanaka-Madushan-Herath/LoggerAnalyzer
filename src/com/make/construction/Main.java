package com.make.construction;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.next();
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        Date date = new Date();
        System.out.println(date);


    }

}

