package IODemo;

import java.io.*;

/**
 * ������������
 * ��һ���ļ��� ���Ƶ� ��һ·��
 * ���㷨˼·��
 * 1.��������ԴFile����
 * 2.����Ŀ�ĵ�File����
 * 3.�����ļ��У�write()
 * 4.�ж�ԴFile�������ļ���ֱ�����ֽ�������
 *               ����Ŀ¼��������Ŀ¼����������File���ظ���3��
 * ��ʵ�ַ�ʽ��
 * 1.�ļ�����File()����
 * 2.�ļ���IO������
 * */
public class DirCopyDemo {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("D:\\tmp");
        File descFile = new File("E:\\");
        copyFolder(srcFile,descFile);
    }

    private static void copyFolder(File srcFile, File descFile) throws IOException {
        //Դ�ļ���Ŀ¼
        if (srcFile.isDirectory()){
            //��Ŀ��Ŀ¼�´����ļ�
            String srcFilname = srcFile.getName();
            File newFolder = new File(descFile,srcFilname);
            if (!newFolder.exists()){
                newFolder.mkdir();
            }else {
                System.out.println("Ŀ¼�Ѵ��ڣ�");
            }

            File[] fileArray = srcFile.listFiles();
            for (File file:fileArray){
                //�ݹ鸴��
                copyFolder(file,newFolder);
            }
        }else {
            //Դ�ļ����ļ���ֱ�Ӹ���
            File newFile = new File(descFile,srcFile.getName());
            copyFile(srcFile,newFile);
        }
    }

    private static void copyFile(File srcfile, File descfile) throws IOException {
        //��Դ·�������ڴ�
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcfile));
        //���ڴ�д��Ŀ��·��
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(descfile));

        byte[] bytes = new byte[1024];
        int len;
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();
    }


}