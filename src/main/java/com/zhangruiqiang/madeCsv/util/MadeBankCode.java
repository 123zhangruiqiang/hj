package com.zhangruiqiang.madeCsv.util;

import java.util.*;

public class MadeBankCode {
    public static final Map<String,String> bankMap=new HashMap<String,String>();
    static {
        bankMap.put("工商银行","ICBC");
        bankMap.put("中国农业银行","ABOC");
        bankMap.put("中国银行","BKCH");
        bankMap.put("中信银行","CIBK");
        bankMap.put("中国光大银行","EVER");
        bankMap.put("兴业银行","FJIB");
        bankMap.put("广发银行","GDBK");
        bankMap.put("华夏银行","HXBK");
        bankMap.put("中国工商银行","ICBK");
        bankMap.put("中国民生银行","MSBC");
        bankMap.put("中国建设银行","PCBC");
        bankMap.put("中国邮政储蓄银行","PSBC");
        bankMap.put("平安银行","SZDB");
        bankMap.put("浦发银行","SPDB");
        bankMap.put("北京银行","BJCN");
        bankMap.put("招商银行","CMBC");
        bankMap.put("交通银行","COMM");
        bankMap.put("海口联合农商银行","HKBC");
    }

    public static String getBankCode(){
        Random random=new Random();
        int index=random.nextInt(bankMap.size());
        Collection<String> collection=bankMap.values();
        Iterator<String> iterator=collection.iterator();
        String bankcode=null;
        int i=0;
        while(i<index&&iterator.hasNext()){
            i++;
            bankcode= iterator.next();
        }

        return bankcode;
    }

    public static void main(String[] args) {
        System.out.println(getBankCode());
    }
}
