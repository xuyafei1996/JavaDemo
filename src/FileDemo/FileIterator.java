package FileDemo;

import java.io.File;

/**
 * 【问题描述】
 * 遍历某路径下的所有内容，并把文件路径输入在控制台
 * */
public class FileIterator {
    public static void main(String[] args) {
        //根据给定的路径创建一个File对象
        File srcFile = new File("D:\\software");
        //调用方法
        getAllFilePath(srcFile);
    }

    private static void getAllFilePath(File srcFile) {
        //获取给定的File目录下所有的文件或者目录的File数组
        File[] fileArray = srcFile.listFiles();
        //遍历该File数组，得到每一个File对象
        if(fileArray != null) {
            for(File file : fileArray) {
                //判断该File对象是否是目录
                if(file.isDirectory()) {
                    //是：递归调用
                    getAllFilePath(file);
                } else {
                    //不是：获取绝对路径输出在控制台
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}
