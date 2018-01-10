package com.zhangruiqiang.madeCsv.util;

import java.util.Random;

public class MadeRecordType {
    public static String getRecordTyoe(){
        String recodeType[]={"newlyAdded","modify","cancellation"};

        Random random=new Random();
        int index=random.nextInt(3);
        return recodeType[index];

    }
}
