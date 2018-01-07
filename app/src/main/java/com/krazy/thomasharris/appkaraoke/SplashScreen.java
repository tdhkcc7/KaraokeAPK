package com.krazy.thomasharris.appkaraoke;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen( SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withBackgroundResource(R.drawable.intro);

        View view  = config.create();
        setContentView(view);
    }
}

//        EasySplashScreen config = new EasySplashScreen( SplashScreen.this)
//                .withFullScreen()
//                .withTargetActivity(MainActivity.class)
//                .withSplashTimeOut(3000)
//                .withBackgroundColor(Color.parseColor("#ffffff"))
//                .withBackgroundResource(R.drawable.intro)
//                .withLogo(R.mipmap.ic_launcher)
//                .withHeaderText("Hello")
//                .withFooterText("Verson 1.0")
//                .withBeforeLogoText("Tra cứu mã số Karaoke")
//                .withAfterLogoText("CKN");
//
//        config.getAfterLogoTextView().setTextSize(30);
//        config.getHeaderTextView().setTextColor(Color.BLACK);
//        config.getFooterTextView().setTextColor(Color.BLACK);
//        config.getBeforeLogoTextView().setTextColor(Color.BLACK);
//        config.getAfterLogoTextView().setTextColor(Color.BLACK);