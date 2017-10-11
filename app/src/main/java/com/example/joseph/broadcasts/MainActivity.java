package com.example.joseph.broadcasts;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    int imageLevel;
    private Button button;
    DynamicReceiver dynamicReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.iv);
        imageLevel = 1;
        imageView.setImageLevel(imageLevel);
        button = (Button) findViewById(R.id.btnChangeLevel);

        StateListDrawable drawable = new StateListDrawable();

        // ON PRESS/CLICK BACKGROUND
        drawable.addState(new int[]{android.R.attr.state_pressed},new ColorDrawable(Color.RED));

        // DEFAULT BACKGROUND
        drawable.addState(new int[]{}, new ColorDrawable(Color.GREEN));

        button.setBackgroundDrawable(drawable);

    }

    public void changeLevel(View view) {

        if(imageLevel == 1){
            imageView.setImageLevel(2);
            imageLevel = 2;
        }
        else {
            imageView.setImageLevel(1);
            imageLevel = 1;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        dynamicReceiver = new DynamicReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(dynamicReceiver, intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(dynamicReceiver);


    }


}
