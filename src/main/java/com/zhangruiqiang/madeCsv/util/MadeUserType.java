package com.zhangruiqiang.madeCsv.util;

import java.util.Random;

public class MadeUserType {
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.println(getUserType());
        }

    }
    public static String getUserType(){
        String [] userType={"PERSONAL","ORGANIZATION"};
        Random random=new Random();
        int index=random.nextInt(20);
        if(index>15){
            return  userType[1];
        }else{
            return  userType[0];
        }
    }
}
