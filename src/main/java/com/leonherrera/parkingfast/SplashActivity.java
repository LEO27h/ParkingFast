
package com.leonherrera.parkingfast;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Usuario on 13/09/2016.
 */

public class SplashActivity extends AppCompatActivity{


    private static final long SPLASH_DELAY = 3000;

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Establece modo

        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE); //Quitar AppBar

        setContentView(R.layout.activity_splash);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent().setClass(SplashActivity.this, LogginActivity.class);
                startActivity(i);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_DELAY);

    }

}
