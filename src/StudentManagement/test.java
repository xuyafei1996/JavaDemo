package StudentManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        //创建集合对象，用于保存学生数据信息
        ArrayList<Student> array = new ArrayList<Student>();
        StudentManager manager = new StudentManager();
        //用循环完成再次回到主界面
        while (true) {
            //用输出语句完成主界面的编写
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 按照学号查询");
            System.out.println("6 保存学生信息");
            System.out.println("7 退出");
            System.out.println("请输入你的选择：");

            //用Scanner实现键盘录入数据
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            //用switch语句完成操作的选择
            switch (line) {
                case "1":
                    manager.addStudent(array);
                    break;
                case "2":
                    manager.deleteStudent(array);
                    break;
                case "3":
                    manager.updateStudent(array);
                    break;
                case "4":
                    manager.findAllStudent(array);
                    break;
                case "5":
                    manager.findStudentByID(array);
                    break;
                case "6":
                    manager.StoreStudent(array);
                    break;
                case "7":
                    System.out.println("谢谢使用");
                    System.exit(0); //JVM退出
            }
        }
    }
}
