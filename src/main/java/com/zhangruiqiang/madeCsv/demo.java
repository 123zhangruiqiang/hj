package com.zhangruiqiang.madeCsv;

import com.zhangruiqiang.madeCsv.entity.Jpop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class demo {
    public static void main(String[] args) throws InvocationTargetException {
        try {
            Class clazz=Class.forName("com.zhangruiqiang.madeCsv.entity.Jpop");
            Object o=clazz.newInstance();
            Jpop jpop=new Jpop();
            jpop.setNonRepaymentAmount("sssssssssss");
            jpop.setTotalIoanAmount("ssssssssssssssss");
           Method[] methods=clazz.getMethods();
           for(int i=0;i<methods.length;i++){
               if(methods[i].getName().contains("get")){
                   System.out.println(methods[i].toString().substring(methods[i].toString().lastIndexOf(".")+1));

                   System.out.println( methods[i].invoke(jpop)+"-----------------");
               }
              Object object=clazz.newInstance();


           }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
