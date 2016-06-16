package com.uptech.up;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //FONT CHANGER
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "fonts/quicksand.otf");
        Button myButton = (Button)findViewById(R.id.button);
        myButton.setTypeface(myTypeface);
    }


    public void startActivityWelcome(View v) {
        Intent myIntent = new Intent(this, WelcomeActivity.class);
        startActivity(myIntent);

    }
}
