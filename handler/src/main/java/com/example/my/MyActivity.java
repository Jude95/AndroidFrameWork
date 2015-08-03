package com.example.my;

import com.example.os.Handler;
import com.example.ui.Activity;

/**
 * Created by Mr.Jude on 2015/8/3.
 */
public class MyActivity extends Activity {
    @Override
    public void OnCreate() {
        super.OnCreate();
        System.out.println(Thread.currentThread().getId());
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getId());
                    }
                });
            }
        }).start();

    }
}
