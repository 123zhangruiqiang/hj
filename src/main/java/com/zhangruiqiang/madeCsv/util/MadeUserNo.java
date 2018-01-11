package com.zhangruiqiang.madeCsv.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MadeUserNo {
    public static List<String> list =new ArrayList<String>();

    public static void madeUserNo(String userNo){
        if(list.size()>0){
            if(!list.contains(userNo)){
                list.add(userNo);
            }else{
                madeUserNo(String.valueOf((int) Math.abs((Math.random() * 9 + 1) * 1000000000)));
            }
        }else{
            list.add(userNo);
        }
    }

    public static void  domadeUserNo(){

        String subjectNo=String.valueOf((int) Math.abs((Math.random() * 9 + 1) * 1000000000));
        madeUserNo(subjectNo);
    }

    public static String getSingleUserNo(){
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
    public static void domadeUserNoList(int row){
        for(int i=0;i<row;i++){
            domadeUserNo();
        }
    }
    public static void main(String[] args) {
        domadeUserNoList(50);
        for(int i=0;i<50;i++){
            System.out.println(getSingleUserNo());
        }
        System.out.println(list.size());
        System.out.println(list);

    }
}
