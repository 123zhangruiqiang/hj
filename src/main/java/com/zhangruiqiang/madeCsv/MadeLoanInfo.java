
package com.zhangruiqiang.madeCsv;

import com.zhangruiqiang.madeCsv.entity.Cj;
import com.zhangruiqiang.madeCsv.entity.FieldSort;
import com.zhangruiqiang.madeCsv.util.*;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MadeLoanInfo {
    public static void main(String[] args) {
        Class clazz= null;
        Object o=null;
        try {
            clazz = Class.forName("com.zhangruiqiang.madeCsv.entity.Cj");
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
    public static void doLoanInfo(int row){
        Class clazz= null;
        Object o=null;
        try {
            clazz = Class.forName("com.zhangruiqiang.madeCsv.entity.Cj");
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
        SubjectNo2.domadeSubjectNoList(row);
        MadeUserNo.domadeUserNoList(row);
        writeFi(list);
        //int number= (int) (Math.random()*9+1);
        //System.out.println(Math.random()*9+1);

        List list1=makeData(row);
        wiritFile(list1);
    }

    public static void writeFi(List list){
        String folder="D://zipdata//";
        File file=new File(folder,"LOAN_INFO.csv");
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
        File file=new File(folderPath,"LOAN_INFO.csv");
        System.out.println(file);
        BufferedWriter bf=null;
        System.out.println(list);
        FileWriter fw= null;
        try {
            System.out.println(file+"--------------------");
            fw = new FileWriter(file,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bf=new BufferedWriter(fw);
        for(int i=0;i<list.size();i++){

            System.out.println(list.get(i));
            Cj cj= (Cj) list.get(i);
            Class clazz=cj.getClass();


            try {
                System.out.println(clazz);

                Method[] methods=clazz.getMethods();
                List<Method> listm=rMethod(methods);
                System.out.println(listm);
                Map<Integer,Method> map=rMethoda(listm);
                System.out.println(map);
                List<String> list1=new ArrayList<String>();
                System.out.println(list1);

/*for(int j=listm.size()-1;j>=0;j--) {

                        String s=null;
                        if(j==0){
                            s=listm.get(j).invoke(cj).toString();

                        }else{
                            s=listm.get(j).invoke(cj)+",";
                        }
                        list1.add(s);

                    }
                System.out.println(list1);

                list1.remove(0);
                for(String s:list1){
                    System.out.println(s);
                    bf.write(s);

                }*/

                String s=null;

                for(Map.Entry<Integer,Method> entry:map.entrySet()){
                    System.out.println(entry.getKey());
                    if(map.size()==entry.getKey()){

                        s=  entry.getValue().invoke(cj).toString();
                    }else{
                        s=  entry.getValue().invoke(cj)+",";
                    }
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

    public static List<Cj> makeData(int row){
        List<Cj> list=new ArrayList<Cj>();
        for(int i=0;i<row;i++){
            Cj cj=new Cj();
            cj.setPlatformNo(MadePlatFormNo.platformnolist.get(i));
            cj.setProjectNo(MadeUserNo.getSingleUserNo());
            cj.setIdCardType("PRC_ID");
            cj.setIdCardNo(MadeIdNumber.getIdNumber());
            cj.setInvestmentTime(MadeDate.reanomDate("2016-01-06 12:33:04","2018-01-04 14:23:01"));
            cj.setAmount(String.valueOf((int)Math.abs((Math.random()*9+1)*100000)));
            cj.setSubjectNo(SubjectNo2.getSingleSubjectNo());
            MadeAddress.getResAddress();
            cj.setProvience(MadeAddress.getProvince());
            cj.setCity(MadeAddress.getCity());
            cj.setDistrict(MadeAddress.getDistrict());
            list.add(cj);
        }
        return list;
    }
}

