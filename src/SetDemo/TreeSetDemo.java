package SetDemo;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        //�������϶���
        TreeSet<Student> ts = new TreeSet<Student>();

        //����ѧ������,�����ӵ�����
        ts.add(new Student("xishi", 29));
        ts.add(new Student("wangzhaojun", 28));
        ts.add(new Student("diaochan", 30));
        ts.add(new Student("yangyuhuan", 33));
        ts.add(new Student("linqingxia",33));
        ts.add(new Student("linqingxia",33));

        //��������
        for (Student s : ts) {
            System.out.println(s.getName() + "," + s.getAge());
        }
    }

    public static class Student implements Comparable<Student>{
        private String name;
        private int age;
        public Student() {
        }
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        @Override
        public int compareTo(Student s) {
            //���������С��������
            int num = this.age - s.age;
            //������ͬʱ��������������ĸ˳������
            int num2 = num==0?this.name.compareTo(s.name):num;
            return num2;
        }
    }
}