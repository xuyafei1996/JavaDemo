package IODemo;

import java.io.*;

public class FileIOStreamDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\";
        String fileName = "text.txt";
        File file = new File(filePath+fileName);
        if (!file.exists()){
            file.createNewFile();
        }
        //创建文件输出流以指定的名称写入文件
        //Step1.调用系统功能创建了文件
        //Step2.创建了字节输出流对象
        //Step3.让字节输出流对象指向创建好的文件
//        FileOutputStream fos = new FileOutputStream(filePath+fileName);
        FileOutputStream fos = new FileOutputStream(filePath+fileName,true);//追加在文末

        //write(int b)：将指定的字节写入此文件输出流
        fos.write(97);
        byte[] bys = ",bcde".getBytes();
        fos.write(bys);
        //close()：关闭文件输出流,释放相关资源。
        fos.close();

        //读取数据
        int by;
        FileInputStream fis = new FileInputStream(filePath+fileName);
        while ((by=fis.read())!=-1){
            System.out.print((char)by);
        }
        fis.close();
    }
}
