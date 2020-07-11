package IODemo;

import java.io.*;

public class ConversionStreamDemo {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\text.txt"),"GBK");
        osw.write("中国");
        osw.close();

        //InputStreamReader isr = new InputStreamReader(new FileInputStream("myCharStream\\osw.txt"));
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\target.txt"),"GBK");
        //一次读取一个字符数据
        int ch;
        while ((ch=isr.read())!=-1) {
            System.out.print((char)ch);
        }
        isr.close();
    }
}
