package com.example.view;

/**
 * Created by Mr.Jude on 2015/8/7.
 */

public class Activity {
    private View decorView;

    public void onCreate(){
        View v = new View();
        v.setListener(new OnClickListener() {
            @Override
            public void onClick() {

            }
        });
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (decorView.dispatchTouchEvent(ev)){
            return true;
        }
        return onTouchEvent(ev);
    }


    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
