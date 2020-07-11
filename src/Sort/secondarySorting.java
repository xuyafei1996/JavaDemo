package Sort;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * ������������
 * ��������
 * - ��TreeSet���ϴ洢���ѧ����Ϣ(���������ĳɼ�����ѧ�ɼ�)���������ü���
 * - Ҫ�󣺰����ִܷӸߵ��ͳ��֣��ܷ���ͬ�����ĳɼ��ţ����ĳɼ���ͬ��������
 * */
public class secondarySorting {
    public static void main(String[] args) {
        //����TreeSet���϶���ͨ���Ƚ��������������
        TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //��Ҫ����
                int num = s2.getSum() - s1.getSum();
                //��Ҫ����
                int num2 = num == 0 ? s2.getChinese() - s1.getChinese() : num;
                int num3 = num2 == 0 ? s2.getName().compareTo(s1.getName()) : num2;
                return num3;
            }
        });

        //����ѧ������,�����ӵ�����
        ts.add(new Student("����ϼ", 98, 100));
        ts.add(new Student("������", 95, 95));
        ts.add(new Student("������", 100, 93));
        ts.add(new Student("����", 100, 97));
        ts.add(new Student("������", 98, 98));
        ts.add(new Student("������", 97, 99));
        ts.add(new Student("������", 97, 99));

        //��������
        for (Student s : ts) {
            System.out.println(s.getName() + "," + s.getChinese() + "," + s.getMath() + "," + s.getSum());
        }
    }

    public static class Student{
        private String name;
        private int chinese;
        private int math;

        public Student() {
        }

        public Student(String name, int chinese, int math) {
            this.name = name;
            this.chinese = chinese;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getChinese() {
            return chinese;
        }

        public void setChinese(int chinese) {
            this.chinese = chinese;
        }

        public int getMath() {
            return math;
        }

        public void setMath(int math) {
            this.math = math;
        }

        public int getSum() {
            return this.chinese + this.math;
        }
    }
}