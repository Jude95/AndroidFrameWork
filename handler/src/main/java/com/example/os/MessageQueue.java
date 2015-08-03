package com.example.os;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Mr.Jude on 2015/8/3.
 */
public class MessageQueue {

    /**
     * 消息队列
     */
    private LinkedBlockingDeque<Message> queue = new LinkedBlockingDeque<>();
    //Android源码的实现貌似自己实现了一个线程安全的Queue，很复杂。这里简单模拟原理。其实这个BlockingDeque也自带同步锁未使用。


    /**
     * 锁
     */
    private final Object lock = new Object();

    /**
     * 返回一个message.没有则阻塞。直到有了再返回。
     * @return
     */
    Message next(){
        while (true){

            if (queue.peek() !=null){

                //如果队列里有Message，直接返回
                return queue.poll();

            }else {

                //如果队列里没有Message，则阻塞，等待新加入Message时唤醒
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }


    /**
     * 向队列加入一个Message，并唤醒前面的wait
     * 这个函数可以在任意线程调用。
     * @param message
     */
    void enqueueMessage(Message message){
        synchronized (lock){
            queue.push(message);
            lock.notify();
        }
    }
}
