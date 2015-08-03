package com.example.ui;

import com.example.my.MyActivity;
import com.example.os.Looper;

/**
 * Created by Mr.Jude on 2015/8/3.
 * 这里模拟UI线程。所有的Activity，Service都在这个线程上执行
 */
public class UIThread extends Thread {

    @Override
    public void run() {
        Looper.prepare();
        new MyActivity().OnCreate();
        Looper.loop();
    }
}
