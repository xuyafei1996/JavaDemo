package Anno;

import java.lang.reflect.Field;

/**【测试类】
 * 传入目标类Apple的类信息：
 * 1.判断目标类上是否使用自定义注解@Ano_Class
 * 2.判断目标类方法上是否使用自定义注解@FruitProvider
 *   通过反射获取类的所有字段遍历字段，
 *   如果字段使用自定义注解@FruitProvider；
 *   进一步通过反射获得注解信息，读取注解中的id、name、address字段，并输出
 * */

public class Test {
    public static void main(String[] args) {

        //传入目标类Apple的类信息
        Class clazz = Apple.class;
        if (clazz.isAnnotationPresent(Ano_Class.class))
            System.out.println("1.使用了自定义类注解");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Ano_FruitProvider.class)) {
                Ano_FruitProvider anoFruitProvider = (Ano_FruitProvider) field.getAnnotation(Ano_FruitProvider.class);
                System.out.println("2.使用了自定义方法注解");
                String strFruitProvicer = "  供应商编号：" + anoFruitProvider.id() + " 供应商名称："
                        + anoFruitProvider.name() + " 供应商地址："+ anoFruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }
}
