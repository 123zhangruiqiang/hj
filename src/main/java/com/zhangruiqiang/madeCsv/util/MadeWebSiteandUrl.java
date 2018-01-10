package com.zhangruiqiang.madeCsv.util;

import java.util.Random;

public class MadeWebSiteandUrl {
    public static String getWebSiteUrl(){
        String webhead="www";
        String spl=".";
        String webend="com";
        String middle[]={"baidu","lianjia","woaiwojia","sanguosha","bianfeng","jingdong","alibaba"};
        Random random=new Random();
        int index=random.nextInt(middle.length);
        return webend+spl+middle[index]+spl+webend;
    }
    public static String geWebSiteName(){
        String websiteName[]={"51理财","91旺财","天虹基金","钱宝宝","中亚证券","余额宝","借贷宝","易宝"};

        Random random=new Random();
        int index=random.nextInt(websiteName.length);
        return websiteName[index];
    }
}
