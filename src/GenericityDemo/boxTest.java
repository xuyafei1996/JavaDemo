package GenericityDemo;

public class boxTest {
    public static void main(String[] args) {
//        Box box = new Box();
//        box.set(new Apple());
//        Apple apple = (Apple) box.get();//��ʹ�÷��ͣ���Ҫ����ǿת

        Box<Apple> box = new Box();
        box.set(new Apple());
        Apple apple = box.get();
        apple.show();
    }
}