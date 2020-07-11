package SetDemo;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        //创建HashSet集合对象
        HashSet<Student> hs = new HashSet<Student>();
        //创建学生对象,并添加到集合
        hs.add(new Student("林青霞", 30));
        hs.add(new Student("张曼玉", 35));
        hs.add(new Student("王祖贤", 33));
        hs.add(new Student("王祖贤", 33));
        //遍历集合(增强for)
        for (Student s : hs) {
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
}
