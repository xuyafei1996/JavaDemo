package IODemo;

import java.io.*;

public class ConversionStreamDemo {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\text.txt"),"GBK");
        osw.write("�й�");
        osw.close();

        //InputStreamReader isr = new InputStreamReader(new FileInputStream("myCharStream\\osw.txt"));
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\target.txt"),"GBK");
        //һ�ζ�ȡһ���ַ�����
        int ch;
        while ((ch=isr.read())!=-1) {
            System.out.print((char)ch);
        }
        isr.close();
    }
}