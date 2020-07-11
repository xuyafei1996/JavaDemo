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
        //�����ļ��������ָ��������д���ļ�
        //Step1.����ϵͳ���ܴ������ļ�
        //Step2.�������ֽ����������
        //Step3.���ֽ����������ָ�򴴽��õ��ļ�
//        FileOutputStream fos = new FileOutputStream(filePath+fileName);
        FileOutputStream fos = new FileOutputStream(filePath+fileName,true);//׷������ĩ

        //write(int b)����ָ�����ֽ�д����ļ������
        fos.write(97);
        byte[] bys = ",bcde".getBytes();
        fos.write(bys);
        //close()���ر��ļ������,�ͷ������Դ��
        fos.close();

        //��ȡ����
        int by;
        FileInputStream fis = new FileInputStream(filePath+fileName);
        while ((by=fis.read())!=-1){
            System.out.print((char)by);
        }
        fis.close();
    }
}