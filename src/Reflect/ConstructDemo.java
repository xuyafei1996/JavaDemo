package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConstructDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        //获取Class对象
        Class<?> c = Class.forName("Reflect.Student");

        //获取构造方法public Student(String name, int age, String address)
        Constructor<?> con1 = c.getConstructor(String.class, int.class, String.class);
        //T newInstance(Object... initargs)
        Object obj1 = con1.newInstance("林青霞", 30, "西安");
        System.out.println(obj1);

        Constructor<?> con2 = c.getDeclaredConstructor(String.class);
        //暴力反射，取消访问检查
        con2.setAccessible(true);
        Object obj2 = con2.newInstance("林青霞");
        System.out.println(obj2);

        System.out.println("获取成员变量……");
        Field[] fields = c.getDeclaredFields();
        for(Field field : fields) {
            System.out.println(field);
        }
        System.out.println("--------");

        //获取无参构造方法创建对象
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();
        //将指定的对象参数中由此 Field对象表示的字段设置为指定的新值
        Field nameField = c.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj, "林青霞");
        System.out.println(obj);

        Field ageField = c.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(obj,30);
        System.out.println(obj);

        Field addressField = c.getDeclaredField("address");
        addressField.setAccessible(true);
        addressField.set(obj,"西安");
        System.out.println(obj);
        System.out.println("--------");

        //返回所有公共成员方法对象的数组，包括继承的
        Method[] methods = c.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println(method);
        }
        System.out.println("--------");

        Method m = c.getMethod("method1");
        m.invoke(obj);
        System.out.println("--------");
        Method m2 = c.getMethod("method2", String.class);
        m2.invoke(obj,"林青霞");

    }
}
