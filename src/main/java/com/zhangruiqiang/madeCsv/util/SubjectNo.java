package com.zhangruiqiang.madeCsv.util;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class SubjectNo {
    private static Set<String> list=new HashSet<String>();

    private static List<String> list2 = null;

    public static void  makeSingleSubjectNo(String subjectNo){
        list.add(subjectNo);
    }

    public static String getSingleSubjectNo(int i){
     return list2.get(i);



    }

    public static void domakeSingleSubjectNo(int row){
        for(int i=0;list.size()<row;i++) {
            makeSingleSubjectNo(String.valueOf((int) Math.abs((Math.random() * 9 + 1) * 1000000000)));
        }
         list2= new ArrayList<String>(list);
        System.out.println(list.size());

    }

    public static void main(String[] args) {

            domakeSingleSubjectNo(20);
        System.out.println(list.size());
       // List<String> list2 = new ArrayList<String>(list);
        for(int i=0;i<list2.size();i++){
            System.out.println("--------------"+getSingleSubjectNo(i));
        }
    }
}
