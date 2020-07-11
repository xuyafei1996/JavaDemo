package FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //Predicate<T>接受一个参数，返回一个布尔值
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true
        Predicate<Integer> predicate = n -> true;
        System.out.println("输出所有数据:");
        eval(list, n->true);

        Predicate<Integer> predicate1 = n -> n%2 == 0;
        System.out.println("输出所有偶数:");
        eval(list, n-> n%2 == 0 );
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list) {
            if(predicate.test(n)) {
                System.out.print(n + " ");
            }
        }
    }
}
