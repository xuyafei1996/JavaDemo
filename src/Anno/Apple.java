package Anno;
/**
 * ʹ��ע��
 * */
public class Apple {
    @FruitProvider(id = 1, name = "�����츻ʿ����", address = "����ʡ�������Ӱ�·")
    private String appleProvider;
    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
    public String getAppleProvider() {
        return appleProvider;
    }
}