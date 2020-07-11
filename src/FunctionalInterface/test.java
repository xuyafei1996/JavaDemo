package FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //Predicate<T>����һ������������һ������ֵ
        // n ��һ���������ݵ� Predicate �ӿڵ� test ����
        // n ��������� test �������� true
        Predicate<Integer> predicate = n -> true;
        System.out.println("�����������:");
        eval(list, n->true);

        Predicate<Integer> predicate1 = n -> n%2 == 0;
        System.out.println("�������ż��:");
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