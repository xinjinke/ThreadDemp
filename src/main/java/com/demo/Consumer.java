package com.demo;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhangxinhe
 * @date 2018/5/4 14:11
 */
public class Consumer implements Runnable {

    private BlockingQueue<PCData> queue;

    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        System.out.println("start consumer is : "+Thread.currentThread().getId());
        Random r = new Random();
        try{
            while(true){
                PCData data = queue.take();
                if(data != null)
                {
                    int re = data.getData() * data.getData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(),data.getData(),re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
}
