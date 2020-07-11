package FileDemo;

import java.io.File;

/**
 * ������������
 * ����ĳ·���µ��������ݣ������ļ�·�������ڿ���̨
 * */
public class FileIterator {
    public static void main(String[] args) {
        //���ݸ�����·������һ��File����
        File srcFile = new File("D:\\software");
        //���÷���
        getAllFilePath(srcFile);
    }

    private static void getAllFilePath(File srcFile) {
        //��ȡ������FileĿ¼�����е��ļ�����Ŀ¼��File����
        File[] fileArray = srcFile.listFiles();
        //������File���飬�õ�ÿһ��File����
        if(fileArray != null) {
            for(File file : fileArray) {
                //�жϸ�File�����Ƿ���Ŀ¼
                if(file.isDirectory()) {
                    //�ǣ��ݹ����
                    getAllFilePath(file);
                } else {
                    //���ǣ���ȡ����·������ڿ���̨
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}