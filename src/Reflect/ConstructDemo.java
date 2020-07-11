package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConstructDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        //��ȡClass����
        Class<?> c = Class.forName("Reflect.Student");

        //��ȡ���췽��public Student(String name, int age, String address)
        Constructor<?> con1 = c.getConstructor(String.class, int.class, String.class);
        //T newInstance(Object... initargs)
        Object obj1 = con1.newInstance("����ϼ", 30, "����");
        System.out.println(obj1);

        Constructor<?> con2 = c.getDeclaredConstructor(String.class);
        //�������䣬ȡ�����ʼ��
        con2.setAccessible(true);
        Object obj2 = con2.newInstance("����ϼ");
        System.out.println(obj2);

        System.out.println("��ȡ��Ա��������");
        Field[] fields = c.getDeclaredFields();
        for(Field field : fields) {
            System.out.println(field);
        }
        System.out.println("--------");

        //��ȡ�޲ι��췽����������
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();
        //��ָ���Ķ���������ɴ� Field�����ʾ���ֶ�����Ϊָ������ֵ
        Field nameField = c.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj, "����ϼ");
        System.out.println(obj);

        Field ageField = c.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(obj,30);
        System.out.println(obj);

        Field addressField = c.getDeclaredField("address");
        addressField.setAccessible(true);
        addressField.set(obj,"����");
        System.out.println(obj);
        System.out.println("--------");

        //�������й�����Ա������������飬�����̳е�
        Method[] methods = c.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println(method);
        }
        System.out.println("--------");

        Method m = c.getMethod("method1");
        m.invoke(obj);
        System.out.println("--------");
        Method m2 = c.getMethod("method2", String.class);
        m2.invoke(obj,"����ϼ");

    }
}