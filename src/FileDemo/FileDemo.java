package FileDemo;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        //File(String pathname)��ͨ����������·�����ַ���ת��Ϊ����·�����������µ� Fileʵ����
        File f1 = new File("E:\\itcast\\java.txt");
        System.out.println(f1);
        //�����ļ�
        System.out.println(f1.createNewFile());
        System.out.println("--------");

        //File(String parent, String child)���Ӹ�·�����ַ�������·�����ַ��������µ� Fileʵ����
        File f2 = new File("E:\\itcast","java.txt");
        System.out.println(f2);
        //����Ŀ¼JavaSE
        System.out.println(f2.mkdir());
        System.out.println("--------");

        //File(File parent, String child)���Ӹ�����·��������·�����ַ��������µ� Fileʵ����
        File f3 = new File("E:\\itcast\\JavaWEB\\HTML");
        File f4 = new File(f3,"java.txt");
        System.out.println(f4);
        //�����༶Ŀ¼
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
        //����ɾ���ļ�
        System.out.println(f1.delete());
        System.out.println("--------");
        //����ɾ��Ŀ¼
        System.out.println(f3.delete());
        System.out.println("--------");
    }
}