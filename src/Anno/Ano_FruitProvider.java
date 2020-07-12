package Anno;
/**【自定义注解】
 * 1.作用位置：成员变量
 * 2.保留阶段：运行时有效，可通过反射读取注解信息
 * 3.将注释包含在javaDoc中
 * */
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Ano_FruitProvider {
    /**供应商编号*/
    public int id() default -1;
    /*** 供应商名称*/
    public String name() default "";
    /** * 供应商地址*/
    public String address() default "";
}
