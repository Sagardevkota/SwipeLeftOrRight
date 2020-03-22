package com.example.swipe;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class swipe extends GestureDetector.SimpleOnGestureListener{
    // Minimal x and y axis swipe distance.
    private static int MIN_SWIPE_DISTANCE_X = 100;
    private static int MIN_SWIPE_DISTANCE_Y = 100;
    private static int MIN_SCROLL_DISTANCE_Y = 100;

    // Maximal x and y axis swipe distance.
    private static int MAX_SWIPE_DISTANCE_X = 1000;
    private static int MAX_SWIPE_DISTANCE_Y = 1000;
    private static int MAX_SCROLL_DISTANCE_Y = 1000;


    private static String direction;

    Context context;

   public swipe(Context context){
        this.context=context;

    }

    @Override
    public boolean onDown(MotionEvent e) {



        return false;
    }


    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {

        setGesture("single tap up");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {






        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        setGesture("long press");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        // Get swipe delta value in x axis.
        float deltaX = e1.getX() - e2.getX();

        // Get swipe delta value in y axis.
        float deltaY = e1.getY() - e2.getY();

        // Get absolute value.
        float deltaXAbs = Math.abs(deltaX);
        float deltaYAbs = Math.abs(deltaY);

        // Only when swipe distance between minimal and maximal distance value then we treat it as effective swipe
        if((deltaXAbs >= MIN_SWIPE_DISTANCE_X) && (deltaXAbs <= MAX_SWIPE_DISTANCE_X))
        {
            if(deltaX > 0)
            {
                Toast.makeText(context,"swiped to left",Toast.LENGTH_SHORT).show();
                setGesture("left");
                Log.d("Tag","swiped to left");
            }else
            {

                Toast.makeText(context,"swiped to right",Toast.LENGTH_SHORT).show();
                setGesture("right");
                Log.d("Tag","swiped to right");

            }
        }

        // Only when swipe distance between minimal and maximal distance value then we treat it as effective swipe
        if((deltaYAbs >= MIN_SWIPE_DISTANCE_Y) && (deltaYAbs <= MAX_SWIPE_DISTANCE_Y))
        {
            if(deltaY > 0)
            {
                Toast.makeText(context,"swiped to down",Toast.LENGTH_SHORT).show();
                setGesture("down");
                Log.d("Tag","swiped to down");
            }else
            {

                Toast.makeText(context,"swiped to up",Toast.LENGTH_SHORT).show();
                setGesture("up");
                Log.d("Tag","swiped to up");

            }
        }



        return true;



    }

    public void setGesture(String mdirection){
       this.direction=mdirection;


    }

    public String getGesture(){
       return  direction;
    }

}
