
package com.zhangruiqiang.madeCsv;

import com.zhangruiqiang.madeCsv.entity.Bd;
import com.zhangruiqiang.madeCsv.entity.FieldSort;
import com.zhangruiqiang.madeCsv.util.MadeDate;
import com.zhangruiqiang.madeCsv.util.MadeHkType;
import com.zhangruiqiang.madeCsv.util.SubjectNo;
import com.zhangruiqiang.madeCsv.util.SubjectNo2;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MadeProject {
    public static void main(String[] args) {
        Class clazz= null;
        Object o=null;
        try {
            clazz = Class.forName("com.zhangruiqiang.madeCsv.entity.Bd");
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

    public static void doProjectInfo(int row){
        Class clazz= null;
        Object o=null;
        try {
            clazz = Class.forName("com.zhangruiqiang.madeCsv.entity.Bd");
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
        SubjectNo2.domadeSubjectNoList(row);
        List list1=makeData(row);
        wiritFile(list1);
    }


    public static void writeFi(List list){
        String folder="D://zipdata//";
        File file=new File(folder,"PROJECT_INFO.csv");
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
        File file=new File(folderPath,"PROJECT_INFO.csv");
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
            Bd bd= (Bd) list.get(i);
            Class clazz=bd.getClass();


            try {

                Method[] methods=clazz.getMethods();
                List<Method> listM=rMethod(methods);
                Map<Integer,Method> map=rMethoda(listM);
                System.out.println(map);
                List<String> list1=new ArrayList<String>();
                System.out.println(listM);

 System.out.println(clazz);

                /*Method[] methods=clazz.getMethods();
                List<String> list1=new ArrayList<String>();*/
              /*  for(int j=methods.length-1;j>=0;j--) {
                    if (methods[j].getName().contains("get")) {

                        String s=null;
                        if(j==0){
                            s=methods[j].invoke(bd).toString();
                            System.out.println(s+"++++++++++++");

                        }else{
                            s=methods[j].invoke(bd)+",";
                        }
                        list1.add(s);

                    }
                }
                list1.remove(0);
                for(String s:list1){
                    System.out.println(s);
                    bf.write(s);

                }*/

                String s=null;

                for(Map.Entry<Integer,Method> entry:map.entrySet()){
                    if(map.size()==entry.getKey()){

                        s=  entry.getValue().invoke(bd).toString();

                    }else{
                        s=  entry.getValue().invoke(bd)+",";
                    }

                    System.out.println(s+"---------------------------------------");
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
        System.out.println(map);
        return map;
    }


    public static List<Bd> makeData(int row){
        List<Bd> list=new ArrayList<Bd>();
        for(int i=0;i<row;i++){
            Bd  bd=new Bd();
            bd.setProjectNo(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            bd.setExpectedYield(String.valueOf(Math.abs((Math.random()*9+1))));
            bd.setProjectName(UUID.randomUUID().toString());
            bd.setLoanTime(MadeDate.reanomDate("2016-01-06 12:33:04","2018-01-04 14:23:01"));
            bd.setPlatformNo(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            bd.setProjectType("STANDARDPOWDER");
            bd.setRepaymentWay(MadeHkType.getHkType());
            bd.setProjectPeriod(String.valueOf((int)Math.abs((Math.random()*9+1)*100)));
            bd.setTotalInvestment(String.valueOf((int)Math.abs((Math.random()*9+1)*1000)));
            bd.setTotalLoanMoney(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            bd.setAmount(String.valueOf((int)Math.abs((Math.random()*9+1)*100000000)));
            bd.setSubjectNo(SubjectNo2.getSingleSubjectNo());
            list.add(bd);
        }
        return list;
    }
}

