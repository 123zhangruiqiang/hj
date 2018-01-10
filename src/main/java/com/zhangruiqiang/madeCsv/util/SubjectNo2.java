package com.zhangruiqiang.madeCsv.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SubjectNo2 {
    public static List<String> list =new ArrayList<String>();

    public static void madeSubjectNo(String subjectNo){
        if(list.size()>0){
                if(!list.contains(subjectNo)){
                         list.add(subjectNo);
                     }else{
                        madeSubjectNo(String.valueOf((int) Math.abs((Math.random() * 9 + 1) * 1000000000)));
                     }
             }else{
                     list.add(subjectNo);
             }
    }

    public static void  domadeSubjectNo(){

        String subjectNo=String.valueOf((int) Math.abs((Math.random() * 9 + 1) * 1000000000));
        madeSubjectNo(subjectNo);
    }

    public static String getSingleSubjectNo(){
        Random random=new Random();
        System.out.println(list.size()+"#########################");
        String subjectNo=null;
        if(list.size()>1) {
            int index=random.nextInt(list.size());
            subjectNo=list.get(index);
            list.remove(index);
        }else if(list.size()==1){
            subjectNo=list.get(0);
            System.out.println(subjectNo+"%%%%%%%%%%%%%%%%%%%%%%%");
            list.clear();
        }
        System.out.println(subjectNo+"^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        return subjectNo;
    }
    public static void domadeSubjectNoList(int row){
        for(int i=0;i<row;i++){
            domadeSubjectNo();
        }
    }
    public static void main(String[] args) {
        domadeSubjectNoList(50);
        for(int i=0;i<50;i++){
            System.out.println(getSingleSubjectNo());
        }
        System.out.println(list.size());
        System.out.println(list);

    }
}
