package com.zhangruiqiang.madeCsv.util;

import java.util.Random;

public class MadeHkType {
    public static String getHkType(){
        String hktype[]={"ONE_TIME_SERVICING","FIRSEINTREST_LASTPRICIPAL","FIXED_PAYMENT_MORTGAGE","FIXED_BASIS_MORTGAGE"};
        Random random=new Random();
        int index=random.nextInt(hktype.length);
        return  hktype[index];
    }
}
