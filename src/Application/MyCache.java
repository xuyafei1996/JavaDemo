package Application;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ������������
 *  ���һ������ϵͳ���ڲ�������ֱ�ӷ��أ�����ȥDB��ѯ
 */
public class MyCache {
    //����洢��
    private static Map<String,Object> cache = new HashMap<String,Object>();
    public static void main(String[] args) {
        System.out.println(get("123"));
    }

    //�����ݵķ���(��Ϊ���ܶ��̻߳�ȡ������Ҫ����)
    static ReadWriteLock rwl = new ReentrantReadWriteLock();
    public static Object get(String key){
        //�϶���
        rwl.readLock().lock();
        //�Ȳ黺���Ƿ���ֵ��û�о�ȥDB�鲢���뻺��
        Object value = cache.get(key);
        if (value==null){
            //û�����ݣ���DB��ѯ�����뻺��
            //���ͷŶ�������д����
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            //�ٴ��жϣ���ֹ���д�߳��ڴ˴��������ظ�д
            if (value==null){
                value = "aaa";//Query from DB
                cache.put(key,value);
            }
            //�ͷ�д�����ָ���д״̬
            rwl.readLock().lock();
            rwl.writeLock().unlock();
        }
        //����ͷŶ���
        rwl.readLock().unlock();
        return value;
    }
}