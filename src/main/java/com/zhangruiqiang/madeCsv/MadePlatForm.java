
package com.zhangruiqiang.madeCsv;

import com.zhangruiqiang.madeCsv.entity.FieldSort;
import com.zhangruiqiang.madeCsv.entity.PlatMes;
import com.zhangruiqiang.madeCsv.util.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MadePlatForm {
    public static void main(String[] args)  {

        Class clazz= null;
        try {
            clazz = Class.forName("com.zhangruiqiang.madeCsv.entity.PlatMes");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clazz);
        Field[] fields=clazz.getDeclaredFields();
        List<String> list=new ArrayList<String>();
        for(Field field:fields){
            list.add(field.toString().substring(field.toString().lastIndexOf(".")+1));
        }
        for(Field field: fields){
            System.out.println(field.toString());

        }
        FileIo.write(list);
        //int number= (int) (Math.random()*9+1);
        //System.out.println(Math.random()*9+1);
        List list1=makeData(3);
        wiritFile(list1);

    }

    public static void doPlatFormInfo(int row){
        Class clazz= null;
        try {
            clazz = Class.forName("com.zhangruiqiang.madeCsv.entity.PlatMes");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clazz);
        Field[] fields=clazz.getDeclaredFields();
        List<String> list=new ArrayList<String>();
        for(Field field:fields){
            list.add(field.toString().substring(field.toString().lastIndexOf(".")+1));
        }
        for(Field field: fields){
            System.out.println(field.toString());

        }
        FileIo.write(list);
        //int number= (int) (Math.random()*9+1);
        //System.out.println(Math.random()*9+1);
        MadeUserNo.domadeUserNoList(row);
        SubjectNo2.domadeSubjectNoList(row);
        List list1=makeData(row);
        wiritFile(list1);

    }
    public static void wiritFile(List<Object> list){
        String folderPath="D://zipdata//";
        File file=new File(folderPath,"PLATFORM_INFO.csv");
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
            PlatMes platMes= (PlatMes) list.get(i);
            Class clazz=platMes.getClass();


            try {
                System.out.println(clazz);

                Method[] methods=clazz.getMethods();
                List<Method> listm=rMethod(methods);
                System.out.println(listm);
                Map<Integer,Method> map=rMethoda(listm);
                System.out.println(map);
                List<String> list1=new ArrayList<String>();


                String s=null;

                for(Map.Entry<Integer,Method> entry:map.entrySet()){
                    if(map.size()==entry.getKey()){

                        s=  entry.getValue().invoke(platMes).toString();
                    }else{
                        s=  entry.getValue().invoke(platMes)+",";
                        System.out.println(entry.getValue().toString());
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



/*  for(int i=0;i<list.size();i++){

            System.out.println(list.get(i));
            PlatMes platMes= (PlatMes) list.get(i);

            try {
                *//*
*/
/*bf.write(platMes.getPlatformNo()+",");
                bf.write(platMes.getGetPlatformName()+",");
                bf.write(platMes.getLegal()+",");
                bf.write(platMes.getIdCardType()+",");
                bf.write(platMes.getIdCardNo()+",");
                bf.write(platMes.getEnterpriseName()+",");
                bf.write(platMes.getBusinessLicense()+",");
                bf.write(platMes.getOrgNo()+",");
                bf.write(platMes.getTaxNo()+",");
                bf.write(platMes.getBankLicense()+",");
                bf.write(platMes.getCreditCode()+",");
                bf.write(platMes.getUnifiedCode()+",");
                bf.write(platMes.getWebSiteName()+",");
                bf.write(platMes.getWebSiteUrl()+",");
                bf.write(platMes.getPlatformOperationTime()+",");
                bf.write(platMes.getPlatformlastModifyTime()+",");
                bf.write(platMes.getRegisteredAddress()+",");
                bf.write(platMes.getContactAddress()+",");
                bf.write(platMes.getContacts()+",");
                bf.write(platMes.getContactsMobile());*//*
*/
/*

                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write(2333+",");
                bf.write("2333");
               *//*
*/
/* if(i==list.size()-1){
                    bf.write("23333");
                }else{
                    bf.write(23333+",");
                }*//*
*/
/*
                System.out.println(platMes.getBankLicense());
                *//*
*/
/*if(i!=list.size()-1){

                    bf.write(",");
                }*//*
*/
/*
                bf.write("\r\n");
               *//*
*/
/* if(i==list.size()-1) {
                    bf.write("\r\n");
                }*//*
*/
/*
            } catch (IOException e) {
                e.printStackTrace();
            }


        }*/


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

    public static List<PlatMes> makeData(int row){
        List<PlatMes> list=new ArrayList<PlatMes>();
        for(int i=0;i<row;i++){
            PlatMes platMes=new PlatMes();
            platMes.setRecordType(MadeRecordType.getRecordTyoe());
            platMes.setPlatformNo(MadePlatFormNo.platformnolist.get(i));
            platMes.setPlatformName(MadePlatformName.getPlatFormName());
            platMes.setLegal(MadeName.madeName());
            platMes.setIdCardType("PRC_ID");
            platMes.setIdCardNo(MadeIdNumber.getIdNumber());
            platMes.setEnterpriseName(MadePlatformName.getPlatFormName());
            platMes.setBusinessLicense(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            platMes.setOrgNo(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            platMes.setTaxNo(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            platMes.setBankLicense(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            platMes.setCreditCode(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            platMes.setUnifiedCode(String.valueOf((int)Math.abs((Math.random()*9+1)*1000000000)));
            platMes.setWebSiteName(MadeWebSiteandUrl.geWebSiteName());
            platMes.setWebSiteUrl(MadeWebSiteandUrl.getWebSiteUrl());
            platMes.setPlatformOperationTime(MadeDate.reanomDate("2016-12-03 12:33:04","2018-01-04 14:23:01").toString());
            platMes.setPlatformlastModifyTime(MadeDate.reanomDate("2016-12-03 12:33:04","2018-01-04 14:23:01").toString());
            platMes.setRegisteredAddress(MadeAddress.getResAddress());
            System.out.println(MadeAddress.getProvince()+"}}}}}}}}}}}}}}}}}");
            platMes.setProvience(MadeAddress.getProvince());
            System.out.println(MadeAddress.getCity()+"}}}}}}}}}}}}");
            platMes.setCity(MadeAddress.getCity());
            System.out.println(MadeAddress.getDistrict()+"}}}}}}}}}}}}}}}");
            platMes.setDistrict(MadeAddress.getDistrict());
            platMes.setContactAddress(MadeAddress.getResAddress());
            platMes.setContacts(MadeName.madeName());
            platMes.setContactsMobile(MadePhone.getPhone());
            platMes.setSubjectNo(SubjectNo2.getSingleSubjectNo());
            list.add(platMes);
            System.out.println(platMes.toString());
        }
        return list;
    }
}

