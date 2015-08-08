package com.example.view;

import java.util.ArrayList;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class ViewGroup extends View{
    private ArrayList<View> arr;
    private View target;

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (!onInterceptTouchEvent(ev)){
            if (ev.getAction() == 0){
                for (int i = arr.size() - 1; i >= 0; i--) {
                    if (arr.get(i).dispatchTouchEvent(ev)/* && 事件在arr.get(i)的范围内 */){
                        target = arr.get(i);
                        return true;
                    }
                }
            }else{
                target.dispatchTouchEvent(ev);
            }
        }
        return onTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
