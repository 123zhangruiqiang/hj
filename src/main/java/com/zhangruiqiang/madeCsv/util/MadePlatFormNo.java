package com.zhangruiqiang.madeCsv.util;

import java.util.ArrayList;
import java.util.List;

public class MadePlatFormNo {
    public static List<String> platformnolist=new ArrayList<String>();
    public static void makePlatFormNo(){
        String platformNo=String.valueOf((long)((Math.random()*9+1)*1000000000000000.0));
        if(platformnolist.size()>0){
            if(platformnolist.contains(platformNo)){
                makePlatFormNo();
            }else{
                platformnolist.add(platformNo);

            }
        }else{
            platformnolist.add(platformNo);
        }
    }

    public static List<String> getSinglePlatfromNo(int row){
        for(int i=0;i<row;i++){
            makePlatFormNo();
        }
        return  platformnolist;
    }
    public static void main(String[] args) {
        for(int i=0;i<20;i++){
        //makePlatFormNo();
            makePlatFormNo();

        }
        System.out.println(platformnolist);


    }
}
