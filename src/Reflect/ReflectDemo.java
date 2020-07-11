package Reflect;

import SetDemo.Student;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //ʹ�����class��������ȡ�����Ӧ��Class����
        Class<Student> c1 = Student.class;
        System.out.println(c1);

        Class<Student> c2 = Student.class;
        System.out.println(c1 == c2);
        System.out.println("--------");

        //���ö����getClass()���������ظö����������Ӧ��Class����
        Student s = new Student();
        Class<? extends Student> c3 = s.getClass();
        System.out.println(c1 == c3);
        System.out.println("--------");

        //ʹ��Class���еľ�̬����forName(String className)
        Class<?> c4 = Class.forName("SetDemo.Student");
        System.out.println(c1 == c4);
    }
}