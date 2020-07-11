package MapDemo;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * ������������
 * ����¼��һ���ַ�����Ҫ��ͳ���ַ�����ÿ���ַ������ֵĴ�����
 * ����������¼�롰aababcabcdabcde��  �ڿ���̨�������a(5)b(4)c(3)d(2)e(1)��
 * */
public class HashMapDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("������һ���ַ�����");
        String line = sc.nextLine();

        //����HashMap���ϣ�����Character��ֵ��Integer
//        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        TreeMap<Character, Integer> hm = new TreeMap<Character, Integer>();

        //����ÿһ���ַ�
        for (int i = 0; i < line.length(); i++) {
            char key = line.charAt(i);
            //�õõ���ÿһ���ַ���Ϊ����HashMap������ȥ�Ҷ�Ӧ��ֵ
            Integer value = hm.get(key);
            if (value == null) {
                hm.put(key,1);
            } else {
                value++;
                hm.put(key,value);
            }
        }

        //����HashMap���ϣ��õ�����ֵ������Ҫ�����ƴ��
        StringBuilder sb = new StringBuilder();
        //��ȡ���м��ļ���
        Set<Character> keySet = hm.keySet();
        for(Character key : keySet) {
            Integer value = hm.get(key);
            sb.append(key).append("(").append(value).append(")");
        }

        //������
        System.out.println(sb.toString());
    }
}