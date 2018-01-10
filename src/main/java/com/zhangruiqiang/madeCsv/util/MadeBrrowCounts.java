package com.zhangruiqiang.madeCsv.util;

import java.util.Random;

public class MadeBrrowCounts {
    public static String getCounts(){
        Random random=new Random();
        return String.valueOf(random.nextInt(30));
    }
}
