package IODemo;

import java.io.*;

public class BufferedIO {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        copyVideo();
        long endTime = System.currentTimeMillis();
        System.out.println("π≤∫ƒ ±£∫" + (endTime - startTime) + "∫¡√Î");
    }

    private static void copyVideo() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\Film\\Film\\video.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\tmp\\video.mp4"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bis.close();
        bos.close();
    }
}
