package net.androidbootcamp.facialexpression;



import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable faceAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgFrame=(ImageView)findViewById(R.id.imgFaces);
        imgFrame.setBackgroundResource(R.drawable.animation);
        faceAnimation =(AnimationDrawable)imgFrame.getBackground();
        Button button1 =(Button)findViewById(R.id.btnStart);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                faceAnimation.start();
            }
        });


    }

}