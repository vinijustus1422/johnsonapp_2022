package com.triton.johnsonapp.activity;


import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.triton.johnsonapp.R;
import com.triton.johnsonapp.session.SessionManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SplashActivity extends AppCompatActivity {

    /**
     * Session to check whether user is login or not.
     */
    SessionManager sessionManager;

    // user level
    String user_level;

    int haslocationpermission;

    String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SimpleDateFormat currentDate = new SimpleDateFormat("dd.MM.yy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        TextView txt_version = (TextView)findViewById(R.id.txt_version);
        txt_version.setText("Version "+thisDate+".1");

        sessionManager = new SessionManager(this);

        Thread timerThread = new Thread() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {



                    Log.w(TAG,"ELSE"+sessionManager.isLoggedIn());


                    // check whether user is logged in or not
                        if (sessionManager.isLoggedIn()) {


                            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.new_right, R.anim.new_left);
                        }

                        else {

                            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.new_right, R.anim.new_left);
                        }



                }
            }
        };
        timerThread.start();
    }

}