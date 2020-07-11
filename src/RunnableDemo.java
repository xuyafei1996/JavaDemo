import java.util.function.Consumer;

public class RunnableDemo {
    public static void main(String[] args) {
        //����һ
        operatorString("����ϼ", s -> System.out.println(s));
        //������
        operatorString("����ϼ", s -> System.out.println(new StringBuilder(s).reverse().toString()));

        System.out.println("--------");
        //������������ʹ��andThen���
        operatorString("����ϼ", s -> System.out.println(s), s -> System.out.println(new StringBuilder(s).reverse().toString()));
    }

    //����һ���������ò�ͬ�ķ�ʽ����ͬһ���ַ�����������
    private static void operatorString(String name, Consumer<String> con1, Consumer<String> con2) {
//        con1.accept(name);
//        con2.accept(name);
        con1.andThen(con2).accept(name);
    }

    //����һ������������һ���ַ�������
    private static void operatorString(String name, Consumer<String> con) {
        con.accept(name);
    }
}