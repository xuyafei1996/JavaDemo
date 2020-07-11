package StudentManagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    //����ѧ����Ϣ
    public static void addStudent(ArrayList<Student> array) throws IOException {
        Scanner sc = new Scanner(System.in);
        String sid;
        //ѧ���ظ������ظ�����
        while (true) {
            System.out.println("������ѧ��ѧ�ţ�");
            sid = sc.nextLine();
            boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("�������ѧ���Ѿ���ռ�ã�����������");
            } else {
                break;
            }
        }

        System.out.println("������ѧ��������");
        String name = sc.nextLine();
        System.out.println("������ѧ�����䣺");
        String age = sc.nextLine();
        System.out.println("������ѧ����ס�أ�");
        String address = sc.nextLine();

        //����ѧ�����󣬰Ѽ���¼������ݸ�ֵ��ѧ������ĳ�Ա����
        Student s = new Student(sid,name,age,address);
        //��ѧ���������ӵ�������
        array.add(s);
        //�������ӳɹ���ʾ
        System.out.println("����ѧ���ɹ�");
    }

    //�ж�ѧ���Ƿ�ʹ��
    public static boolean isUsed(ArrayList<Student> array, String sid) {
        //����뼯���е�ĳһ��ѧ��ѧ����ͬ������true;���������ͬ������false
        boolean flag = false;
        for(int i=0; i<array.size(); i++) {
            Student s = array.get(i);
            if(s.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //�鿴����ѧ����Ϣ
    public static void findAllStudent(ArrayList<Student> array) {
        //�жϼ������Ƿ������ݣ����û����ʾ��ʾ��Ϣ
        if (array.size() == 0) {
            System.out.println("����Ϣ������������Ϣ�ٲ�ѯ");
            //Ϊ���ó���������ִ�У�����������д��return;
            return;
        }

        //��ʾ��ͷ��Ϣ
        //\t��ʵ��һ��tab����λ��
        //������������ȡ�����ն�Ӧ��ʽ��ʾѧ����Ϣ��������ʾ���䡰�ꡱ
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println("ѧ��:"+s.getSid() + "\t,����:" + s.getName() + "\t,����:" + s.getAge() + "��\t,��ַ��" + s.getAddress());
        }
    }

    //����һ������������ɾ��ѧ����Ϣ
    public static void deleteStudent(ArrayList<Student> array) {
        //����¼��Ҫɾ����ѧ��ѧ��,��ʾ��ʾ��Ϣ
        Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫɾ����ѧ����ѧ�ţ�");
        String sid = sc.nextLine();

        //��ɾ��/�޸�ѧ������ǰ����ѧ���Ƿ���ڽ����ж�
        //��������ڣ���ʾ��ʾ��Ϣ
        //������ڣ�ִ��ɾ��/�޸Ĳ���

        int index = -1;

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("����Ϣ�����ڣ�����������");
        } else {
            array.remove(index);
            //����ɾ���ɹ���ʾ
            System.out.println("ɾ��ѧ���ɹ�");
        }
    }

    //����ѧ�ţ���ѯѧ����Ϣ
    public void findStudentByID(ArrayList<Student> array) {
        System.out.println("������Ҫ��ѯ��ѧ�ţ�");
        Scanner scanner = new Scanner(System.in);
        String sid = scanner.nextLine();
        boolean flag = false;
        for(int i=0; i<array.size(); i++) {
            Student s = array.get(i);
            if(s.getSid().equals(sid)) {
                flag = true;
                System.out.println("ѧ��:"+s.getSid() + "\t,����:" + s.getName() + "\t,����:" + s.getAge() + "��\t,��ַ��" + s.getAddress());
                break;
            }
        }
        if (!flag)
            System.out.println("ѧ�������ڣ�");
    }

    //����һ�������������޸�ѧ����Ϣ
    public static void updateStudent(ArrayList<Student> array) {
        //����¼��Ҫ�޸ĵ�ѧ��ѧ�ţ���ʾ��ʾ��Ϣ
        Scanner sc = new Scanner(System.in);
        String sid;
        //ѧ���ظ������ظ�����
        while (true) {
            System.out.println("������ѧ��ѧ�ţ�");
            sid = sc.nextLine();
            boolean flag = isUsed(array, sid);
            if (!flag) {
                System.out.println("�������ѧ�Ų����ڣ�����������");
            } else {
                break;
            }
        }

        //����¼��Ҫ�޸ĵ�ѧ����Ϣ
        System.out.println("������ѧ����������");
        String name = sc.nextLine();
        System.out.println("������ѧ�������䣺");
        String age = sc.nextLine();
        System.out.println("������ѧ���¾�ס�أ�");
        String address = sc.nextLine();

        //����ѧ������
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        //���������޸Ķ�Ӧ��ѧ����Ϣ
        for (int i = 0; i < array.size(); i++) {
            Student student = array.get(i);
            if (student.getSid().equals(sid)) {
                array.set(i, s);
            }
        }

        //�����޸ĳɹ���ʾ
        System.out.println("�޸�ѧ���ɹ�");
    }

    public void StoreStudent(ArrayList<Student> array) throws IOException {
        //��ѧ����Ϣ¼���ļ�
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\student.txt"));
        for (Student s:array){
            StringBuilder sb = new StringBuilder();
            sb.append(s.getSid()).append(",").append(s.getName()).append(",")
                    .append(s.getAge()).append(",").append(s.getAddress());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}