package com.negi.ritika.spinthebottle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
ImageView mbottle;
    private  Random random=new Random();
    private int lastDir;
    private boolean spinning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbottle=findViewById(R.id.bottle);

    }
    public void spinBottle(View view) {
        if(!spinning) {
            int newDir = random.nextInt(1800);
            float pivotx = mbottle.getWidth() / 2;
            float pivoty = mbottle.getHeight() / 2;

            Animation animation = new RotateAnimation(lastDir, newDir, pivotx, pivoty);
            animation.setDuration(2500);
            animation.setFillAfter(true);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning=true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
spinning=false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            lastDir = newDir;
            mbottle.startAnimation(animation);
        }

    }
}
