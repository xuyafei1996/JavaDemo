package API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateDemo {
    public static void main(String[] args) throws ParseException {
        //当前时间
        Date d1 = new Date();
        System.out.println(d1);

        //初始化为表示从标准基准时间起指定的毫秒数
        long datetime = 1000*60*60;
        Date d2 = new Date(datetime);
        System.out.println(d2);

        //getTime():获取从1970年1月1日 00:00:00到现在的毫秒值
        Date d3 = new Date();
        System.out.println(d3.getTime());
        System.out.println(d3.getTime() * 1.0 / 1000 / 60 / 60 / 24 / 365 + "年");

        //public void setTime(long time):设置时间，给的是毫秒值
        Date d4 = new Date();
//        long time = 1000*60*60;
        long time = System.currentTimeMillis();
        d4.setTime(time);
        System.out.println(d4);

        //格式化：从 Date 到 String
        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String s = sdf.format(d);
        System.out.println(s);
        System.out.println("--------");

        //从 String 到 Date
        String ss = "2048-08-09 11:11:11";
        //ParseException
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dd = sdf2.parse(ss);
        System.out.println(dd);

        //获取日历类对象
        Calendar c = Calendar.getInstance();
        //get(int field):返回给定日历字段的值
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;//MONTH：0~11
        int date = c.get(Calendar.DATE);
        System.out.println(year + "年" + month + "月" + date + "日");

        //add(int field, int amount):将指定的时间量添加或减去给定的日历字段
        //需求:3年前的今天
        c.add(Calendar.YEAR,-3);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        date = c.get(Calendar.DATE);
        System.out.println(year + "年" + month + "月" + date + "日");

        //需求2:10年后的10天前
        c.add(Calendar.YEAR,10);
        c.add(Calendar.DATE,-10);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        date = c.get(Calendar.DATE);
        System.out.println(year + "年" + month + "月" + date + "日");

        //set(int year,int month,int date):设置当前日历的年月日
        c.set(2050,10,10);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        date = c.get(Calendar.DATE);
        System.out.println(year + "年" + month + "月" + date + "日");

        //获取任意一年的二月有多少天
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年：");
        int Year = sc.nextInt();
        //设置日历对象的年、月、日
        //★3月对于的month是2
        c.set(Year, 2, 1);
        //3月1日往前推一天，就是2月的最后一天
        c.add(Calendar.DATE, -1);
        //获取这一天输出即可
        int datediff = c.get(Calendar.DATE);
        System.out.println(Year + "年的2月份有" + datediff + "天");
    }
}
