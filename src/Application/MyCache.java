package Application;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 【问题描述】
 *  设计一个缓存系统，内部有数据直接返回，否则去DB查询
 */
public class MyCache {
    //缓存存储器
    private static Map<String,Object> cache = new HashMap<String,Object>();
    public static void main(String[] args) {
        System.out.println(get("123"));
    }

    //读数据的方法(因为可能多线程获取，所有要互斥)
    static ReadWriteLock rwl = new ReentrantReadWriteLock();
    public static Object get(String key){
        //上读锁
        rwl.readLock().lock();
        //先查缓存是否有值，没有就去DB查并存入缓存
        Object value = cache.get(key);
        if (value==null){
            //没有数据，从DB查询并置入缓存
            //先释放读锁，上写锁；
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            //再次判断，防止多个写线程在此处堵塞，重复写
            if (value==null){
                value = "aaa";//Query from DB
                cache.put(key,value);
            }
            //释放写锁，恢复读写状态
            rwl.readLock().lock();
            rwl.writeLock().unlock();
        }
        //最后释放读锁
        rwl.readLock().unlock();
        return value;
    }
}
