package com.uptech.up;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        //FONT CHANGER
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "fonts/quicksand.otf");
        TextView myTextView = (TextView)findViewById(R.id.textView);
        TextView myTextView2 = (TextView)findViewById(R.id.textView2);
        TextView myTextView3 = (TextView)findViewById(R.id.textView3);
        TextView myTextView4 = (TextView)findViewById(R.id.textView4);
        TextView myTextView5 = (TextView)findViewById(R.id.textView5);

        myTextView.setTypeface(myTypeface);
        myTextView2.setTypeface(myTypeface);
        myTextView3.setTypeface(myTypeface);
        myTextView4.setTypeface(myTypeface);
        myTextView5.setTypeface(myTypeface);
    }

    public void startTracking (View v){
        Intent myIntent = new Intent(this, TrackingActivity.class);
        startActivity(myIntent);
    }

    public void startGrowth (View v){
        Intent myIntent = new Intent(this, GrowthActivity.class);
        startActivity(myIntent);
    }

    public void startStatistics (View v){
        Intent myIntent = new Intent(this, StatisticsActivity.class);
        startActivity(myIntent);
    }

    public void startHistory (View v){
        Intent myIntent = new Intent(this, HistoryActivity.class);
        startActivity(myIntent);
    }
}
