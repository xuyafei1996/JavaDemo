package GenericityDemo;

import java.util.ArrayList;
import java.util.List;

//该测试类操作一个泛型T的对象
public class Test1<T> {
    //list中的对象类型，与T保持一致
    private List<T> list = new ArrayList<>();
    public static void main(String[] args) {
//        Test1<String> test1 = new Test1<>();
//        test1.list.add("a");
//        System.out.println(test1.list);
        Test1<Integer> test1 = new Test1<>();
        test1.list.add(1);
        System.out.println(test1.list);

    }
}
