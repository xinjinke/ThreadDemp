package com.demo;


import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangxinhe
 * @date 2018/5/4 13:57
 */
public class Producer implements Runnable {

    private volatile boolean isRunning = true;

    private BlockingQueue<PCData> queue;

    private static AtomicInteger count = new AtomicInteger();

    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data = null;

        Random r = new Random();

        System.out.println("start producting id :" + Thread.currentThread().getId());

        try {
            while (isRunning){
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new PCData(count.incrementAndGet());

                System.out.println(data+" 加入队列");
                if(!queue.offer(data,2, TimeUnit.SECONDS)){
                    System.out.println(" 加入列队失败");
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop(){
        isRunning = false;
    }
}
