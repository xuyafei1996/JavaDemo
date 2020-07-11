package FileDemo;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        //File(String pathname)：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
        File f1 = new File("E:\\itcast\\java.txt");
        System.out.println(f1);
        //创建文件
        System.out.println(f1.createNewFile());
        System.out.println("--------");

        //File(String parent, String child)：从父路径名字符串和子路径名字符串创建新的 File实例。
        File f2 = new File("E:\\itcast","java.txt");
        System.out.println(f2);
        //创建目录JavaSE
        System.out.println(f2.mkdir());
        System.out.println("--------");

        //File(File parent, String child)：从父抽象路径名和子路径名字符串创建新的 File实例。
        File f3 = new File("E:\\itcast\\JavaWEB\\HTML");
        File f4 = new File(f3,"java.txt");
        System.out.println(f4);
        //创建多级目录
        System.out.println(f3.mkdirs());
        System.out.println("--------");

        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        System.out.println(f1.exists());
        System.out.println("--------");
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getPath());
        System.out.println(f1.getName());
        System.out.println("--------");
        //需求：删除文件
        System.out.println(f1.delete());
        System.out.println("--------");
        //需求：删除目录
        System.out.println(f3.delete());
        System.out.println("--------");
    }
}
