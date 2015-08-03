package com.example.os;

/**
 * Created by Mr.Jude on 2015/8/3.
 */
public class Looper {

    /**
     * 每个线程都只有一个对象(Looper)。
     * ThreadLocal 本质可以简单理解为 HashMap<Thread,Object>.
     * 而get与set的Key默认为当前线程
     */
    private static ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();

    /**
     * 消息队列
     */
    static MessageQueue mQueue;


    Looper(){
        mQueue = new MessageQueue();
    }

    /**
     * 准备，new一个Looper放进ThreadLocal。
     */
    public static void prepare(){
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper());
    }

    /**
     * 当调用了这个方法，就开始在这个线程上无限循环
     */
    public static void loop(){
        final Looper me = myLooper();
        if (me == null) {
            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
        }


        while (true){
            // 获取下一个Message。这里永远会取到一个。
            // 只有当存进去null的时候才会返回null。
            // 而当队列为空时，会阻塞直到队列有Message了再返回。
            Message msg = mQueue.next();

            //如果取到null，就退出
            if (msg == null)return;

            //取到了就交给Message的目标Handler去处理。
            msg.target.dispatchMessage(msg);
        }
    }

    /**
     * 获取当前线程的Looper
     * @return
     */
    public static Looper myLooper(){ return sThreadLocal.get();}
}
