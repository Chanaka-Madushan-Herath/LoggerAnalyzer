package com.make.construction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LogFileRepository {
    public void readFile() throws IOException {

        BufferedReader b = new BufferedReader(new FileReader("C:\\Users\\hansa\\IdeaProjects\\LoggerAnalyzer\\src\\com\\make\\construction\\idea.log"));
        List<String> list=new ArrayList<String>();
        String s;
        while((s = b.readLine()) != null){
            list.add(s);
//            System.out.println(list);

        }

        b.close();
        List<String> errorList=new ArrayList<String>();

        for (String element : list){
            if (element.contains("ERROR")){

                errorList.add(element);
            }
        }
//        System.out.println(errorlist);
        for (int i = 0; i < errorList.size(); i++) {

            System.out.println(errorList.get(i));


        }

    }
}

