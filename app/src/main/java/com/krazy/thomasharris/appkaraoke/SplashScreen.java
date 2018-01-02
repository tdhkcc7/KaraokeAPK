package com.krazy.thomasharris.appkaraoke;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen( SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withBackgroundColor(Color.parseColor("#ffffff"))
                .withLogo(R.mipmap.ic_launcher)
                .withHeaderText("abcccccc")
                .withFooterText("aaaaaaa")
                .withBeforeLogoText("dddddddd")
                .withAfterLogoText("uuuuuuu");

        config.getAfterLogoTextView().setTextSize(30);
        config.getHeaderTextView().setTextColor(Color.BLACK);
        config.getFooterTextView().setTextColor(Color.BLACK);
        config.getBeforeLogoTextView().setTextColor(Color.BLACK);
        config.getAfterLogoTextView().setTextColor(Color.BLACK);

        View view  = config.create();
        setContentView(view);
    }
}
