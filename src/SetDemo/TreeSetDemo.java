package SetDemo;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        //创建集合对象
        TreeSet<Student> ts = new TreeSet<Student>();

        //创建学生对象,并添加到集合
        ts.add(new Student("xishi", 29));
        ts.add(new Student("wangzhaojun", 28));
        ts.add(new Student("diaochan", 30));
        ts.add(new Student("yangyuhuan", 33));
        ts.add(new Student("linqingxia",33));
        ts.add(new Student("linqingxia",33));

        //遍历集合
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
            //按照年龄从小到大排序
            int num = this.age - s.age;
            //年龄相同时，按照姓名的字母顺序排序
            int num2 = num==0?this.name.compareTo(s.name):num;
            return num2;
        }
    }
}
