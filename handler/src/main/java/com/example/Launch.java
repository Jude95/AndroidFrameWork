package com.example;

import com.example.ui.UIThread;

public class Launch {
    public static void main(String[] args) {
        new UIThread().start();
    }
}
