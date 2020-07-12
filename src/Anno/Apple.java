package Anno;
/**【使用注解的类】
 * 使用自定义注解@Ano_Class，标记类；
 * 使用自定义注解@Ano_FruitProvide，标记成员变量；并配置注解中的字段信息
 * */
@Ano_Class
public class Apple {
    @Ano_FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路")
    private String appleProvider;
    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
    public String getAppleProvider() {
        return appleProvider;
    }
}
