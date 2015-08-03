package com.example.os;

/**
 * Created by Mr.Jude on 2015/8/3.
 */
public class Looper {
    private static ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();
    static MessageQueue mQueue;

    Looper(){
        mQueue = new MessageQueue();
    }

    public static void prepare(){
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper());
    };

    public static void loop(){
        final Looper me = myLooper();
        if (me == null) {
            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
        }
        while (true){
            Message message = mQueue.next();
            if (message == null)return;
            else
                message.getCallback().run();
        }
    }
    public static Looper myLooper(){ return sThreadLocal.get();}
}
