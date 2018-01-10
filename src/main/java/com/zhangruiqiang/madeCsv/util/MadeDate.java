package com.zhangruiqiang.madeCsv.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MadeDate {

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            System.out.println(reanomDate("2016-12-03 12:33:04","2018-01-04 14:23:01"));
        }

    }

    public static String reanomDate(String beginDate,String endDate){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date begin=simpleDateFormat.parse(beginDate);
            Date end =simpleDateFormat.parse(endDate);
            if(begin.getTime()>=end.getTime()){
                return null;
            }
            Random random=new Random();

            long time=(long)(begin.getTime()+Math.random()*(end.getTime()-begin.getTime()));


            return simpleDateFormat.format(new Date(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
