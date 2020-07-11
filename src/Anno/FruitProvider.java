package Anno;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**��Ӧ�̱��*/
    public int id() default -1;
    /*** ��Ӧ������*/
    public String name() default "";
    /** * ��Ӧ�̵�ַ*/
    public String address() default "";
}