package StudentManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        //�������϶������ڱ���ѧ��������Ϣ
        ArrayList<Student> array = new ArrayList<Student>();
        StudentManager manager = new StudentManager();
        //��ѭ������ٴλص�������
        while (true) {
            //�����������������ı�д
            System.out.println("--------��ӭ����ѧ������ϵͳ--------");
            System.out.println("1 ����ѧ��");
            System.out.println("2 ɾ��ѧ��");
            System.out.println("3 �޸�ѧ��");
            System.out.println("4 �鿴����ѧ��");
            System.out.println("5 ����ѧ�Ų�ѯ");
            System.out.println("6 ����ѧ����Ϣ");
            System.out.println("7 �˳�");
            System.out.println("���������ѡ��");

            //��Scannerʵ�ּ���¼������
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            //��switch�����ɲ�����ѡ��
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
                    System.out.println("ллʹ��");
                    System.exit(0); //JVM�˳�
            }
        }
    }
}