package API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateDemo {
    public static void main(String[] args) throws ParseException {
        //��ǰʱ��
        Date d1 = new Date();
        System.out.println(d1);

        //��ʼ��Ϊ��ʾ�ӱ�׼��׼ʱ����ָ���ĺ�����
        long datetime = 1000*60*60;
        Date d2 = new Date(datetime);
        System.out.println(d2);

        //getTime():��ȡ��1970��1��1�� 00:00:00�����ڵĺ���ֵ
        Date d3 = new Date();
        System.out.println(d3.getTime());
        System.out.println(d3.getTime() * 1.0 / 1000 / 60 / 60 / 24 / 365 + "��");

        //public void setTime(long time):����ʱ�䣬�����Ǻ���ֵ
        Date d4 = new Date();
//        long time = 1000*60*60;
        long time = System.currentTimeMillis();
        d4.setTime(time);
        System.out.println(d4);

        //��ʽ������ Date �� String
        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
        String s = sdf.format(d);
        System.out.println(s);
        System.out.println("--------");

        //�� String �� Date
        String ss = "2048-08-09 11:11:11";
        //ParseException
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dd = sdf2.parse(ss);
        System.out.println(dd);

        //��ȡ���������
        Calendar c = Calendar.getInstance();
        //get(int field):���ظ��������ֶε�ֵ
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;//MONTH��0~11
        int date = c.get(Calendar.DATE);
        System.out.println(year + "��" + month + "��" + date + "��");

        //add(int field, int amount):��ָ����ʱ�������ӻ��ȥ�����������ֶ�
        //����:3��ǰ�Ľ���
        c.add(Calendar.YEAR,-3);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        date = c.get(Calendar.DATE);
        System.out.println(year + "��" + month + "��" + date + "��");

        //����2:10����10��ǰ
        c.add(Calendar.YEAR,10);
        c.add(Calendar.DATE,-10);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        date = c.get(Calendar.DATE);
        System.out.println(year + "��" + month + "��" + date + "��");

        //set(int year,int month,int date):���õ�ǰ������������
        c.set(2050,10,10);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        date = c.get(Calendar.DATE);
        System.out.println(year + "��" + month + "��" + date + "��");

        //��ȡ����һ��Ķ����ж�����
        Scanner sc = new Scanner(System.in);
        System.out.println("�������꣺");
        int Year = sc.nextInt();
        //��������������ꡢ�¡���
        //��3�¶��ڵ�month��2
        c.set(Year, 2, 1);
        //3��1����ǰ��һ�죬����2�µ����һ��
        c.add(Calendar.DATE, -1);
        //��ȡ��һ���������
        int datediff = c.get(Calendar.DATE);
        System.out.println(Year + "���2�·���" + datediff + "��");
    }
}