package org.mdsd2017.android.dummybroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CustomBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = CustomBroadcastReceiver.class.getSimpleName();

    public CustomBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(CustomBroadcastReceiver.TAG, "Custom action event caught!");
        Toast.makeText(context, "CUSTOM-ACTION triggered", Toast.LENGTH_SHORT).show();
    }
}
