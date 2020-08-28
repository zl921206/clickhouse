package com.kamluen.clickhouse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemInfoTest {

    public static void main(String[] args) {
        System.out.println("输出javahome: " + System.getenv().get("JAVA_HOME"));

        String date = "2019-05-08";
        try {
            System.out.println("输出日期：" + new SimpleDateFormat("yyyy-MM-dd").parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
