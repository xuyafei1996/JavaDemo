package SetDemo;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        //����HashSet���϶���
        HashSet<Student> hs = new HashSet<Student>();
        //����ѧ������,�����ӵ�����
        hs.add(new Student("����ϼ", 30));
        hs.add(new Student("������", 35));
        hs.add(new Student("������", 33));
        hs.add(new Student("������", 33));
        //��������(��ǿfor)
        for (Student s : hs) {
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
}