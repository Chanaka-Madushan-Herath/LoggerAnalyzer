package com.make.construction.Streaming;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @Test
    void check_getErrorBuffer_working_or_not() {
        Result result = new Result();
        List<String> email = new ArrayList<String>();
        email.add("ovindu@gmail.com");

        result.setErrorBuffer("ovindu@gmail.com");

        assertEquals(email,result.getErrorBuffer());
    }
    @Test
    public void check_getLine_working_or_not(){
        Result result = new Result();


        result.setLine("2020-01-25 16:07:06,429");

        assertEquals("2020-01-25 16:07:06,429",result.getLine());
    }
    @Test
    public void check_getSubject_working_or_not(){
        Result result = new Result();


        result.setSubject("INFO");

        assertEquals("INFO",result.getSubject());
    }

}