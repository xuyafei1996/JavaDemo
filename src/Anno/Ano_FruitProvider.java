package Anno;
/**���Զ���ע�⡿
 * 1.����λ�ã���Ա����
 * 2.�����׶Σ�����ʱ��Ч����ͨ�������ȡע����Ϣ
 * 3.��ע�Ͱ�����javaDoc��
 * */
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Ano_FruitProvider {
    /**��Ӧ�̱��*/
    public int id() default -1;
    /*** ��Ӧ������*/
    public String name() default "";
    /** * ��Ӧ�̵�ַ*/
    public String address() default "";
}