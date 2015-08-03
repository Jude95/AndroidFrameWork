package com.example.os;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Mr.Jude on 2015/8/3.
 */
public class MessageQueue {

    private LinkedBlockingDeque<Message> queue = new LinkedBlockingDeque<>();
    private Object lock = new Object();
    /**
     * 100%返回一个message.没有则阻塞。直到有了再返回。
     * @return
     */
    Message next(){
        while (true){
            if (queue.peek() !=null){
                return queue.poll();
            }else {
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


    void enqueueMessage(Message message){
        queue.push(message);
        synchronized (lock){
            lock.notify();
        }
    }
}
