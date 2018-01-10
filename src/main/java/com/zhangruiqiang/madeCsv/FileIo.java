
package com.zhangruiqiang.madeCsv;


import java.io.*;
import java.security.MessageDigest;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileIo {
    public  static String folderPath="D://zipdata//";
    public static void write(List<String> list){

            //File file=new File("D://XMTtest","XMTest.csv");
            File folder=new File(folderPath);
            if(!folder.exists()){
                System.out.println("文件夹不存在，创建中");
                folder.mkdir();
                System.out.println("创建完成");
            }
            File file=new File(folder,"PLATFORM_INFO.csv");
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

    public static String  overZip(String name){
        try {
            OutputStream ot=new FileOutputStream("D://"+name+".zip");
            CheckedOutputStream cos=new CheckedOutputStream(ot,new CRC32());
            ZipOutputStream zos=new ZipOutputStream(cos);
            File file=new File(folderPath);
            ZipFile(zos,file);
            zos.close();
            cos.close();
            ot.close();
            System.out.println("压缩完成");

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        File fz=new File("D:\\"+name+".zip");
        getMd5FileHash(fz);
        return fz.getAbsolutePath();
    }

    public static void ZipFile(ZipOutputStream zos,File file) throws IOException {
        if(file.isDirectory()){
            zos.putNextEntry(new ZipEntry(file.getPath().substring(file.getPath().indexOf("XMTest"))+File.separator));
            for(File f1 :file.listFiles())
            {

                ZipFile(zos,f1);
            }
        }else{

            System.out.println("正在压缩文件:"+file.getName());
            //创建压缩文件
            //zos.putNextEntry(new ZipEntry(file.getPath().substring(file.getPath().indexOf(folderPath+file.getName()))));
            zos.putNextEntry(new ZipEntry(file.getName()));
            //用字节方式读取源文件
            InputStream is = new FileInputStream(file.getPath());
            //创建一个缓存区
            BufferedInputStream bis = new BufferedInputStream(is);
            //字节数组,每次读取1024个字节
            byte [] b = new byte[1024];
            //循环读取，边读边写
            while(bis.read(b)!=-1)
            {
                zos.write(b);//写入压缩文件
            }
            //关闭流
            is.close();
            bis.close();


           // zos.close();
        }

    }

  /*  public static  List<T> readCsv(String file){

        List<T> list=new ArrayList<T>();
        try {

            BufferedReader bf =new BufferedReader(new FileReader(file));
            System.out.println("fileopen");
            Pattern p=Pattern.compile("\\s*|\t|\r|\n");
            String message=null;


            String dest=null;
            while((message=bf.readLine())!=null){
                Matcher m=p.matcher(message);
                dest=m.replaceAll("");
                if((message.length())>50) {
                    System.out.println(message);
                    String s[]=message.split(",");


                    SourceFile sf=new SourceFile();
                    sf.setUserid(s[0].replace("\"",""));
                    sf.setDate(s[1].split("\\s")[0].replace("\"",""));
                    sf.setTime(s[1].split("\\s")[1].replace("\"",""));
                    sf.setMoney(s[2].replace("\"",""));
                    list.add(sf);


                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }*/



    public  static String getMd5FileHash(File file)  {
        System.out.println(file.length());
        return getFileHash(file,"MD5");
    }


    public  static String getFileHash(File file, String hashType)

    {
        try {

            InputStream fis = new FileInputStream(file);

            byte buffer[] = new byte[1024];
            MessageDigest md5 = MessageDigest.getInstance(hashType);
            for(int numRead = 0; (numRead = fis.read(buffer)) > 0;)
            {
                md5.update(buffer, 0, numRead);
            }
            byte[] b = md5.digest();
            StringBuffer sb = new StringBuffer();
            for(int i = 0;i<b.length;i++){
                int v = (int) b[i];
                v = v < 0 ? 0x100 + v : v;
                String cc = Integer.toHexString(v);
                if (cc.length() == 1)
                    sb.append('0');
                sb.append(cc);
            }
            System.out.println(sb);
            return sb.toString();

        } catch (Exception e) {
            // TODO: handle exception
        }
        return  "";
    }


}
