package Anno;

import java.lang.reflect.Field;

public class FruitInfoUtil {
    //传入某类的信息
    public static void getFruitInfo(Class<?> clazz) {
        String strFruitProvicer = "";
        //通过反射，获取该类所有字段
        //如传Apple.class,则获取字段appleProvider
        Field[] fields = clazz.getDeclaredFields();//通过反射获取处理注解
        for (Field field : fields) {
            //字段是否用@FruitProvider注解标注
            if (field.isAnnotationPresent(FruitProvider.class)) {
                //反射注解信息
                FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
                //处理注解信息
                strFruitProvicer = " 供应商编号：" + fruitProvider.id() + " 供应商名称："
                        + fruitProvider.name() + " 供应商地址："+ fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }
}
