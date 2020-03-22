package com.example.swipeleftorright;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.swipe.swipe;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

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
            String gesture= new swipe(getApplicationContext()).getGesture();
            Log.d("direction is" ,gesture);
            String img;

            switch (gesture){

                case "left":

                 img="https://images.pexels.com/photos/212286/pexels-photo-212286.jpeg";
                    showImage(img);

                    break;
                case "right":
                  img="https://images.pexels.com/photos/7367/startup-photo.jpg";
                    showImage(img);

                    break;

                case "down":
                   img="https://images.pexels.com/photos/316465/pexels-photo-316465.jpeg";
                    showImage(img);

                    break;

                case "up":
                     img="https://images.pexels.com/photos/3082452/pexels-photo-3082452.jpeg";
                    showImage(img);

                    break;




            }



            return true;
        }
        else
            return false;
    }

    public void showImage(String image){

        ImageView img=findViewById(R.id.img);

        try{
            String url=image;

            Picasso.get()
                    .load(url)
                    .fit()
                    .into(img, new Callback() {
                        @Override
                        public void onSuccess() {
                            Log.d("Load","Successfull");

                        }

                        @Override
                        public void onError(Exception e) {
                            Log.d("Load",e.getMessage());
                        }
                    });}
        catch (Exception e){
            Log.d("error",e.getMessage());
        }

    }





}
