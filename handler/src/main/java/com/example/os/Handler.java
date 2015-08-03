package com.example.os;

/**
 * Created by Mr.Jude on 2015/8/3.
 */
public class Handler {
    private Looper looper;
    public Handler(){
        looper = Looper.myLooper();
    }

    public void post(Runnable runnable){
        send(new Message(runnable,0));
    }

    public void send(Message message){
        looper.mQueue.enqueueMessage(message);
    }
}
