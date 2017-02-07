package org.mdsd2017.android.dummybroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyLocalReceiver extends BroadcastReceiver {

    private static final String TAG = MyLocalReceiver.class.getSimpleName();

    public MyLocalReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        Log.v(MyLocalReceiver.TAG, "Custom action event caught!");
        Toast.makeText(context, "CUSTOM-ACTION triggered", Toast.LENGTH_SHORT).show();
    }
}
