package com.demo;

/**
 * @author zhangxinhe
 * @date 2018/5/3 14:55
 */
public class Ticket implements Runnable {

    private int ticket = 60;


    @Override
    public void run() {
        while (true){
             sale();
        }
    }
    private  void sale(){
        if (ticket > 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"窗口正在售票："+ticket--);
        }
    }
}
