package SetDemo;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        //�������϶���
        LinkedHashSet<Student> lhs = new LinkedHashSet<Student>();

        //����Ԫ��
        //����ѧ������,�����ӵ�����
        lhs.add(new Student("����ϼ", 30));
        lhs.add(new Student("������", 35));
        lhs.add(new Student("������", 33));
        lhs.add(new Student("������", 33));

        //��������
        for(Student s : lhs) {
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
}