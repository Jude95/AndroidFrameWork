package com.example.view;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class MotionEvent {
    private float x;
    private float y;
    private int action;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
