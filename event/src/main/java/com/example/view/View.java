package com.example.view;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class View {
    private OnClickListener listener;
    boolean clickAble;
    public void setListener( OnClickListener listener){
        this.listener = listener;
        clickAble = true;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        return onTouchEvent(ev);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 1)
            if (listener!=null){
                listener.onClick();
            }
        return clickAble;
    }


}
