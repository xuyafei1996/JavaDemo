package IODemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class picCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\col.png");
        FileOutputStream fos = new FileOutputStream("D:\\tmp\\col.png");
        byte[] bys = new byte[1024];
        int len;
        while ((len=fis.read(bys))!=-1){
            fos.write(bys,0,len);
        }
        fis.close();
        fos.close();
    }
}
