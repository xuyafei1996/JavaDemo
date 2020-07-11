package SetDemo;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        //创建集合对象
        LinkedHashSet<Student> lhs = new LinkedHashSet<Student>();

        //添加元素
        //创建学生对象,并添加到集合
        lhs.add(new Student("林青霞", 30));
        lhs.add(new Student("张曼玉", 35));
        lhs.add(new Student("王祖贤", 33));
        lhs.add(new Student("王祖贤", 33));

        //遍历集合
        for(Student s : lhs) {
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
}
