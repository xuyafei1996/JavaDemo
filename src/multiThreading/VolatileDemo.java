package multiThreading;

import java.util.ArrayList;
import java.util.List;

public class VolatileDemo {
        //�ṩһ������
        // volatile���ε���list�ĵ�ַ���߳�1�޸�list�����ݺ�ˢ�������ʱ���ǲ�ȷ���ģ��߳�2������ʱ����ܲ�һ��
        volatile List list = new ArrayList();
        //����һ��add����
        public void add(Object o){
            list.add(o);
        }
        //����һ��size����
        public int size(){
            return list.size();
        }
        public static void main(String[] args) {
            VolatileDemo volatileDemo = new VolatileDemo();
            //�½�һ���߳�B,���ڼ�������ĸ���
            new Thread(()->{
                while(true){
                    if(volatileDemo.size()==5){
                        break;
                    }
                }
                System.out.println("�߳�t2 ����");
            },"t2").start();
            //����һ���߳�A,����Object��������
            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    volatileDemo.add(new Object());
                    System.out.println("add "+i);
                    //�߳�2������list�󣬸���һ�θ��µ�ʱ��
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //Ϊ��ֵ֤�Ŀɼ��ԣ����߳�1����һ��list��Ϣһ�ᣬ�õȵ�������ֵˢ������ȥ
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"t1").start();
        }
    }
