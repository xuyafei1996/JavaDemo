import java.util.ArrayList;
import java.util.List;

public class test<T> {
    //�½�һ���б����б�Ԫ����test<T>��ʹ�õ�Ԫ�����ͱ���һ��
    //ָ������Ԫ��ֻ����T����
    public List<T> list = new ArrayList<T>();
    public static void main(String[] args) {
        test<String> test = new test<String>();
        test.list.add("hello");
        System.out.println(test.list);
    }




//    public static void main(String[] args) {
//        //����ͨ�����<?>
//        List<?> list1 = new ArrayList<Object>();
//        List<?> list2 = new ArrayList<Number>();
//        List<?> list3 = new ArrayList<Integer>();
//        System.out.println("--------");
//
//        //����ͨ������ޣ�<? extends ����>
////        List<? extends Number> list4 = new ArrayList<Object>();
//        List<? extends Number> list5 = new ArrayList<Number>();
//        List<? extends Number> list6 = new ArrayList<Integer>();
//        System.out.println("--------");
//
//        //����ͨ������ޣ�<? super ����>
//        List<? super Number> list7 = new ArrayList<Object>();
//        List<? super Number> list8 = new ArrayList<Number>();
////        List<? super Number> list9 = new ArrayList<Integer>();
//
//    }
}