package Sort;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 【问题描述】
 * 二级排序：
 * - 用TreeSet集合存储多个学生信息(姓名，语文成绩，数学成绩)，并遍历该集合
 * - 要求：按照总分从高到低出现，总分相同按语文成绩排，语文成绩相同按姓名排
 * */
public class secondarySorting {
    public static void main(String[] args) {
        //创建TreeSet集合对象，通过比较器排序进行排序
        TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //主要条件
                int num = s2.getSum() - s1.getSum();
                //次要条件
                int num2 = num == 0 ? s2.getChinese() - s1.getChinese() : num;
                int num3 = num2 == 0 ? s2.getName().compareTo(s1.getName()) : num2;
                return num3;
            }
        });

        //创建学生对象,并添加到集合
        ts.add(new Student("林青霞", 98, 100));
        ts.add(new Student("张曼玉", 95, 95));
        ts.add(new Student("王祖贤", 100, 93));
        ts.add(new Student("柳岩", 100, 97));
        ts.add(new Student("风清扬", 98, 98));
        ts.add(new Student("左冷禅", 97, 99));
        ts.add(new Student("左冷禅", 97, 99));

        //遍历集合
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
