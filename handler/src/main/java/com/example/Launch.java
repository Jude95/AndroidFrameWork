package com.example;

import com.example.ui.UIThread;

public class Launch {
    //这里模拟系统进程
    public static void main(String[] args) {
        new UIThread().start();
    }
}
