package MapDemo;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * 【问题描述】
 * 键盘录入一个字符串，要求统计字符串中每个字符串出现的次数。
 * 举例：键盘录入“aababcabcdabcde”  在控制台输出：“a(5)b(4)c(3)d(2)e(1)”
 * */
public class HashMapDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();

        //创建HashMap集合，键是Character，值是Integer
//        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        TreeMap<Character, Integer> hm = new TreeMap<Character, Integer>();

        //遍历每一个字符
        for (int i = 0; i < line.length(); i++) {
            char key = line.charAt(i);
            //拿得到的每一个字符作为键到HashMap集合中去找对应的值
            Integer value = hm.get(key);
            if (value == null) {
                hm.put(key,1);
            } else {
                value++;
                hm.put(key,value);
            }
        }

        //遍历HashMap集合，得到键和值，按照要求进行拼接
        StringBuilder sb = new StringBuilder();
        //获取所有键的集合
        Set<Character> keySet = hm.keySet();
        for(Character key : keySet) {
            Integer value = hm.get(key);
            sb.append(key).append("(").append(value).append(")");
        }

        //输出结果
        System.out.println(sb.toString());
    }
}
