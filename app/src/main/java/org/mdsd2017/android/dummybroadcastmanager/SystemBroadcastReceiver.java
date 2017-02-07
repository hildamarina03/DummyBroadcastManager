package org.mdsd2017.android.dummybroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SystemBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = SystemBroadcastReceiver.class.getSimpleName();

    public SystemBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        if(intent.getAction() == Intent.ACTION_BATTERY_LOW){
            Log.v(SystemBroadcastReceiver.TAG, "Battery low-event caught!");

        }else if(intent.getAction() == Intent.ACTION_AIRPLANE_MODE_CHANGED){
            Log.v(SystemBroadcastReceiver.TAG, "Airplane mode event caught!");

        }else{

            Log.v(SystemBroadcastReceiver.TAG, "Unidentified event caught!");


        }
    }
}

