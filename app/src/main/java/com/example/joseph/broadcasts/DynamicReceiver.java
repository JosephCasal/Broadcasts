package com.example.joseph.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by joseph on 10/11/17.
 */

public class DynamicReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        switch (action){

            case Intent.ACTION_AIRPLANE_MODE_CHANGED:

                boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

                if(isAirplaneModeOn)
                    Toast.makeText(context, "Airplane Mode is on", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Airplane Mode is off", Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_BATTERY_CHANGED:

                Toast.makeText(context, "Battery changed", Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_TIME_TICK:

                Toast.makeText(context, "Time changed", Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_BATTERY_LOW:

                Toast.makeText(context, "Battery is low", Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_POWER_CONNECTED:

                Toast.makeText(context, "Power connected", Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_POWER_DISCONNECTED:

                Toast.makeText(context, "Power disconnected", Toast.LENGTH_SHORT).show();

                break;

        }
    }
}
