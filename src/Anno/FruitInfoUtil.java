package Anno;

import java.lang.reflect.Field;

public class FruitInfoUtil {
    //����ĳ�����Ϣ
    public static void getFruitInfo(Class<?> clazz) {
        String strFruitProvicer = "";
        //ͨ�����䣬��ȡ���������ֶ�
        //�紫Apple.class,���ȡ�ֶ�appleProvider
        Field[] fields = clazz.getDeclaredFields();//ͨ�������ȡ����ע��
        for (Field field : fields) {
            //�ֶ��Ƿ���@FruitProviderע���ע
            if (field.isAnnotationPresent(FruitProvider.class)) {
                //����ע����Ϣ
                FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
                //����ע����Ϣ
                strFruitProvicer = " ��Ӧ�̱�ţ�" + fruitProvider.id() + " ��Ӧ�����ƣ�"
                        + fruitProvider.name() + " ��Ӧ�̵�ַ��"+ fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }
}