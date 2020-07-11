package IODemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        //文本复制
        FileInputStream fis = new FileInputStream("D:\\text.txt");
        FileOutputStream fos = new FileOutputStream("D:\\target.txt");

        //字节流复制文本
        byte[] bys = new byte[1024];
        int len;
        while ((len=fis.read(bys))!=-1){
            System.out.println(new String(bys,0,len));
        }
        fos.close();
        fis.close();

        //字节流复制图片

    }
}
