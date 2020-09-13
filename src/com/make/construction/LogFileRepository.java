package com.make.construction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;


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

        String e = list.get(list.size()-1);
        System.out.println("\n"+e);


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\hansa\\IdeaProjects\\LoggerAnalyzer\\src\\com\\make\\construction\\timeStamp.txt",true));
        new FileWriter("C:\\Users\\hansa\\IdeaProjects\\LoggerAnalyzer\\src\\com\\make\\construction\\timeStamp.txt", false).close();

        String[] res = e.split("[,]", 0);
        bufferedWriter.write(res[0]);
        bufferedWriter.close();


    }

}

