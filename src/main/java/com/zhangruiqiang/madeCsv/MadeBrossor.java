
package com.zhangruiqiang.madeCsv;

import com.zhangruiqiang.madeCsv.entity.FieldSort;
import com.zhangruiqiang.madeCsv.entity.Jpop;
import com.zhangruiqiang.madeCsv.util.*;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MadeBrossor {

    public static void main(String[] args)  {

        Class clazz= null;
        Object o=null;
        try {
            clazz = Class.forName("com.zhangruiqiang.madeCsv.entity.Jpop");
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

    public static void doBrossorInfo(int row){
        Class clazz= null;
        Object o=null;
        try {
            clazz = Class.forName("com.zhangruiqiang.madeCsv.entity.Jpop");
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
        System.out.println(SubjectNo2.list.size());
        System.out.println(SubjectNo2.list);
        writeFi(list);
        //int number= (int) (Math.random()*9+1);
        //System.out.println(Math.random()*9+1);
        //SubjectNo.domakeSingleSubjectNo(row);

        List list1=makeData(row);
        wiritFile(list1);
    }


    public static void writeFi(List list){
        String folder="D://zipdata//";
        File file=new File(folder,"BORROWER_INFO.csv");
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
        File file=new File(folderPath,"BORROWER_INFO.csv");
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
            Jpop jpop= (Jpop) list.get(i);
            Class clazz=jpop.getClass();
            System.out.println(clazz);


            try {



               Method[] methods=clazz.getMethods();
               List<Method> listM=rMethod(methods);
               Map<Integer,Method> map=rMethoda(listM);
                System.out.println(map);
               List<String> list1=new ArrayList<String>();
                System.out.println(listM);

            /* for(int j=listM.size()-1;j>=0;j--) {


                        String s=null;
                        if(j==0){
                            s=listM.get(j).invoke(jpop).toString();
                            System.out.println("++++++++++++++++"+s);

                        }else{
                            s=listM.get(j).invoke(jpop)+",";
                        }
                        list1.add(s);


                }
                list1.remove(0);
                System.out.println(list1);
                for(String s:list1){
                    System.out.println(s);
                    bf.write(s);

                }*/

               String s="";

                for(Map.Entry<Integer,Method> entry:map.entrySet()){
                    System.out.println("-------------------");
                    System.out.println(entry.getKey());
                    if(map.size()==entry.getKey()){
                        System.out.println(entry.getValue().invoke(jpop).toString());
                        s=  (String)entry.getValue().invoke(jpop);
                        System.out.println(s);
                    }else{
                        s=  entry.getValue().invoke(jpop)+",";
                    }
                    System.out.println(s+"_______________________");
                    if(s.contains("null")){
                        bf.write(s.replace("null",""));
                    }else {
                        bf.write(s);

                    }
                    System.out.println(s);
                 // bf.write(s);
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

    public static List<Jpop> makeData(int row){
        List<Jpop> list=new ArrayList<Jpop>();
        for(int i=0;i<row;i++){
            Jpop jpop=new Jpop();
            jpop.setUserNo(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            jpop.setPlatformNo(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            jpop.setUserType(MadeUserType.getUserType());
            jpop.setRealName(MadeName.madeName());
            jpop.setIdCardType("PRC_ID");
            jpop.setIdCardNo(MadeIdNumber.getIdNumber());
            if(jpop.getUserType()=="ORGANIZATION"){
                jpop.setLegal(MadeName.madeName());
                jpop.setBusinessLicense(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
                jpop.setOrgNo(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
                jpop.setTaxNo(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
                jpop.setBankLicense(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
                jpop.setCreditCode(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
                jpop.setUnifiedCode(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            }

            jpop.setBankcode(MadeBankCode.getBankCode());
            jpop.setAccountCreateTime(MadeDate.reanomDate("2016-12-03 12:33:04","2018-01-04 14:23:01").toString());
            jpop.setTotalBorrowingTimes(MadeBrrowCounts.getCounts());
            jpop.setTotalIoanAmount(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            jpop.setNonRepaymentProject(MadeBrrowCounts.getCounts());
            jpop.setNonRepaymentAmount(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
           // System.out.println(SubjectNo2.getSingleSubjectNo()+"))))))))))))))))))))))))))");
            jpop.setSubjectNo(SubjectNo2.getSingleSubjectNo());
            MadeAddress.getResAddress();
            jpop.setProvience(MadeAddress.getProvince());
            jpop.setCity(MadeAddress.getCity());
            jpop.setDistrict(MadeAddress.getDistrict());
            list.add(jpop);
        }
        return list;
    }
}

