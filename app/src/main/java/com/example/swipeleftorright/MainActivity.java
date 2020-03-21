package com.example.swipeleftorright;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.swipe.swipe;

public class MainActivity extends AppCompatActivity {

    GestureDetector mGestureDetector;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout myview=findViewById(R.id.my_view);
        context=getApplicationContext();
        mGestureDetector = new GestureDetector(this, new swipe(getApplicationContext()));


        myview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {



                return false;
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        //method onTouchEvent of GestureDetector class Analyzes the given motion event
        //and if applicable triggers the appropriate callbacks on the GestureDetector.OnGestureListener supplied.
        //Returns true if the GestureDetector.OnGestureListener consumed the event, else false.

        boolean eventConsumed=mGestureDetector.onTouchEvent(event);
        if (eventConsumed)
        {
            String direction= new swipe(getApplicationContext()).getDirection();
            Log.d("direction is" ,direction);
            if (direction.equals("left")){
                //write your code if user swipes to left
            }

            else {
                //write your code if user swipes to right
            }


            return true;
        }
        else
            return false;
    }


}
