package com.example.os;

/**
 * Created by Mr.Jude on 2015/8/3.
 */
public class Message {
    int what;
    Runnable callback;

    public Message(Runnable callback, int what) {
        this.callback = callback;
        this.what = what;
    }

    public int getWhat() {
        return what;
    }

    public void setWhat(int what) {
        this.what = what;
    }

    public Runnable getCallback() {
        return callback;
    }

    public void setCallback(Runnable callback) {
        this.callback = callback;
    }
}
