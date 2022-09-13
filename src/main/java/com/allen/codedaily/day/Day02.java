package com.allen.codedaily.day;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 可数循环（Counted Loop）
 * JDK10（包含）及以上版本，不会出现以上现象，HotSpot 实现了 Loop Strip Mining 优化
 *
 * @author allen
 * @date 2022/9/13 17:19
 */
public class Day02 {
    public static AtomicInteger num = new AtomicInteger(0);

    //public static AtomicLong num = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () ->{
            // 第一种情况
            //for (int i = 0; i < 1000000000; i++){
            //    num.getAndAdd(i);
            //}

            // 第二中情况
            //for (long i = 0; i < 1000000000; i++){
            //    num.getAndAdd(i);
            //}

            // 第三种情况
            for (int i = 0; i < 1000000000; i++){
                num.getAndAdd(i);
                // prevent gc
                if (i % 1000 == 0){
                    try {
                        // 这个关键操作
                        Thread.sleep(0);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }

            System.out.println(Thread.currentThread().getName() + " : 执行结束!");
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("num = "+ num);
        // 从代码的输出结果来看
        // int: 主线程等待；long：主线程正常结束；Thread.sleep: 主线程正常结束

        // 1.启动了两个长的，不间断的循环（内部没有安全点检查）
        // 2.主线程进入睡眠 1 秒钟
        // 3.再 1000ms 之后，JVM尝试再 safePoint 停止，以便java线程进行定期清理，但是直到可数循环完成后才能执行此操作
        // 4.主线程的 Thread.sleep 方法从 native 返回，发现安全店操作正在进行中，于是把自己挂起，直到操作结束
    }
}
