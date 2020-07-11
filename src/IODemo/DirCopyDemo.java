package IODemo;

import java.io.*;

/**
 * 【问题描述】
 * 将一个文件夹 复制到 另一路径
 * 【算法思路】
 * 1.创建数据源File对象；
 * 2.创建目的地File对象；
 * 3.复制文件夹：write()
 * 4.判断源File，若是文件，直接用字节流复制
 *               若是目录，创建新目录，遍历其中File，重复第3不
 * 【实现方式】
 * 1.文件夹用File()复制
 * 2.文件用IO流复制
 * */
public class DirCopyDemo {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("D:\\tmp");
        File descFile = new File("E:\\");
        copyFolder(srcFile,descFile);
    }

    private static void copyFolder(File srcFile, File descFile) throws IOException {
        //源文件是目录
        if (srcFile.isDirectory()){
            //在目标目录下创建文件
            String srcFilname = srcFile.getName();
            File newFolder = new File(descFile,srcFilname);
            if (!newFolder.exists()){
                newFolder.mkdir();
            }else {
                System.out.println("目录已存在！");
            }

            File[] fileArray = srcFile.listFiles();
            for (File file:fileArray){
                //递归复制
                copyFolder(file,newFolder);
            }
        }else {
            //源文件是文件，直接复合
            File newFile = new File(descFile,srcFile.getName());
            copyFile(srcFile,newFile);
        }
    }

    private static void copyFile(File srcfile, File descfile) throws IOException {
        //从源路径读入内存
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcfile));
        //从内存写入目标路径
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
