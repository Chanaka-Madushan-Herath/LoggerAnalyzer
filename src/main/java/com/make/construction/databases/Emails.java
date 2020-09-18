package com.make.construction.databases;

import java.util.ArrayList;
import java.util.List;

public class Emails {

    private List<String> emailList;

    public Emails() {
        emailList = new ArrayList<>();
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(String email) {
        this.emailList.add(email);
    }

}
