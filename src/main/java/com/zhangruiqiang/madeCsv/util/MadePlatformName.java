package com.zhangruiqiang.madeCsv.util;

import java.util.Random;

public class MadePlatformName {
    public static String getPlatFormName(){
        String companyName[]={"江南嘉捷","滴滴打人","优利金","中金支付","麦田房产","链家","我爱我家","美团","饿了么","微软中国",
        "阿尔法","学而思"};
        Random random=new Random();
        return companyName[random.nextInt(companyName.length)];
    }
}
