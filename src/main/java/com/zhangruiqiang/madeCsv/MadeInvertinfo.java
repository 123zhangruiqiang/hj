
package com.zhangruiqiang.madeCsv;

import com.zhangruiqiang.madeCsv.entity.FieldSort;
import com.zhangruiqiang.madeCsv.entity.Tzr;
import com.zhangruiqiang.madeCsv.util.MadeDate;
import com.zhangruiqiang.madeCsv.util.SubjectNo;
import com.zhangruiqiang.madeCsv.util.SubjectNo2;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MadeInvertinfo {
    public static void main(String[] args) {
        Class clazz= null;
        Object o=null;
        try {
            clazz = Class.forName("com.zhangruiqiang.madeCsv.entity.Tzr");
            o=clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println(clazz);
        Field[] fields=clazz.getDeclaredFields();
        List<String> list=new ArrayList<String>();
        for(Field field:fields){
            list.add(field.toString().substring(field.toString().lastIndexOf(".")+1));
        }
        // FileIo.write(list);
        writeFi(list);
        //int number= (int) (Math.random()*9+1);
        //System.out.println(Math.random()*9+1);
        List list1=makeData(3);
        wiritFile(list1);
    }
    public static void doInvertInfo(int row){
        Class clazz= null;
        Object o=null;
        try {
            clazz = Class.forName("com.zhangruiqiang.madeCsv.entity.Tzr");
            o=clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println(clazz);
        Field[] fields=clazz.getDeclaredFields();
        List<String> list=new ArrayList<String>();
        for(Field field:fields){
            list.add(field.toString().substring(field.toString().lastIndexOf(".")+1));
        }
        // FileIo.write(list);
        System.out.println("------------------------");
        SubjectNo2.domadeSubjectNoList(row);
        System.out.println("------------------------");
        writeFi(list);
        //int number= (int) (Math.random()*9+1);
        //System.out.println(Math.random()*9+1);

        List list1=makeData(row);
        wiritFile(list1);

    }

    public static void writeFi(List list){
        String folder="D://zipdata//";
        File file=new File(folder,"INVESTOR_INFO.csv");
        BufferedWriter bf=null;
        try {
            FileWriter fw=new FileWriter(file);
            bf=new BufferedWriter(fw);
            for(int i=0;i<list.size();i++){


                bf.write(list.get(i).toString().toUpperCase());
                if(i!=list.size()-1){
                    bf.write(",");
                }

                if(i==list.size()-1) {
                    bf.write("\r\n");
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {


            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();

            }

        }

    }

    public static void wiritFile(List<Object> list)  {
        String folderPath="D://zipdata//";
        File file=new File(folderPath,"INVESTOR_INFO.csv");
        System.out.println(file);
        BufferedWriter bf=null;
        System.out.println(list);
        FileWriter fw= null;
        try {
            fw = new FileWriter(file,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bf=new BufferedWriter(fw);
        for(int i=0;i<list.size();i++){

            System.out.println(list.get(i));
            Tzr tzr= (Tzr) list.get(i);
            Class clazz=tzr.getClass();
            System.out.println(clazz);


            try {



                Method[] methods=clazz.getMethods();
                List<Method> listm=rMethod(methods);
                Map<Integer,Method> map=rMethoda(listm);
                System.out.println(map);
                List<String> list1=new ArrayList<String>();
                System.out.println(list1);


/*for(int j=listm.size()-1;j>=0;j--) {

                        String s=null;
                        if(j==0){
                            s=listm.get(j).invoke(tzr).toString();

                        }else{
                            s=listm.get(j).invoke(tzr)+",";
                        }
                        list1.add(s);


                }
                list1.remove(0);
                for(String s:list1){
                    bf.write(s);

                }*/

                String s=null;

                for(Map.Entry<Integer,Method> entry:map.entrySet()){
                    if(map.size()==entry.getKey()){
                        s=  entry.getValue().invoke(tzr).toString();
                    }else{
                        s=  entry.getValue().invoke(tzr)+",";
                    }
                    System.out.println(s+"-------------------------");
                    bf.write(s);
                }

                bf.write("\r\n");

            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


        }

        try {
            bf.flush();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<Method> rMethod(Method[] methods){
        List<Method> list=new ArrayList();
        for(int i=0;i<methods.length;i++){
            if(methods[i].getName().contains("get")){
                list.add(methods[i]);
            }
        }
        return list;
    }

    public static Map<Integer,Method> rMethoda(List<Method> list){
        Map<Integer, Method> map=new HashMap<Integer, Method>();
        for(int i=0;i<list.size();i++){

            // Annotation annotation=list.get(i).getAnnotation(FieldSort.class);
            if(list.get(i).isAnnotationPresent(FieldSort.class)){
                FieldSort fieldSort=(FieldSort) list.get(i).getAnnotation(FieldSort.class);
                int value=Integer.valueOf(fieldSort.value());
                map.put(value,list.get(i));
            }


        }

        return map;
    }



    public static List<Tzr> makeData(int row){
        List<Tzr> list=new ArrayList<Tzr>();

        for(int i=0;i<row;i++){
            Tzr tzr=new Tzr();
            tzr.setPlatformNo(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            tzr.setStartTime(MadeDate.reanomDate("2015-12-03 12:33:04","2017-01-04 14:23:01").toString());
            tzr.setEndTime(MadeDate.reanomDate("2016-01-06 12:33:04","2018-01-04 14:23:01").toString());
            tzr.setNewOpenAccountNumber(String.valueOf((int)Math.abs((Math.random()*9+1)*1000)));
            tzr.setRechargeNumber(String.valueOf((int)Math.abs((Math.random()*9+1)*1000)));
            tzr.setRechargePenNumber(String.valueOf((int)Math.abs((Math.random()*9+1)*100000)));
            tzr.setReceivedPaymentsNumber(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            tzr.setRechargeAmount(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            tzr.setInvestmentNumber(String.valueOf((int)Math.abs((Math.random()*9+1)*100000)));
            tzr.setInvestmentPenNumber(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            tzr.setInvestmentAmount(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            tzr.setWithdrawNumber(String.valueOf((int)Math.abs((Math.random()*9+1)*10000000)));
            tzr.setWithdrawPenNumber(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            tzr.setWithdrawAmount(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            tzr.setReceivedPaymentsNumber(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            tzr.setReceivedPaymentsPenNumber(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            tzr.setReceivedPaymentsAmount(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            tzr.setBalanceNumber(String.valueOf((int)Math.abs((Math.random()*9+1)*100000)));
            tzr.setBalanceAmount(String.valueOf((int)Math.abs((Math.random()*9+1)*100000000)));
            tzr.setSubjectNo(SubjectNo2.getSingleSubjectNo());
            list.add(tzr);
        }
        return list;
    }
}

