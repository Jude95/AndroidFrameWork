package com.example.os;

/**
 * Created by Mr.Jude on 2015/8/3.
 */
public class Message {

    //一大堆可携带属性
    public int what;
    public int arg1;
    public int arg2;
    public Object obj;


    Runnable callback;

    /**
     * 目标Handler。
     * 一般都是发出此Message的Handler.
     */
    Handler target;

    public Message(Runnable callback, int what) {
        this.callback = callback;
        this.what = what;
    }
}
