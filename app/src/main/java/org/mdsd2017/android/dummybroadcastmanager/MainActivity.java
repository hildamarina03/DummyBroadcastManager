package org.mdsd2017.android.dummybroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

//    private BroadcastReceiver myLocalReceiver;

    private LocalBroadcastReceiver myLocalReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button trigBroadcast_Btn = (Button) this.findViewById(R.id.btnTrigBroadcast);
        trigBroadcast_Btn.setOnClickListener(this);


        this.myLocalReceiver = new LocalBroadcastReceiver();
        final Button trigLocalBroadcast_Btn = (Button) this.findViewById(R.id.btnTrigLocalBroadcast);
        trigLocalBroadcast_Btn.setOnClickListener(this);

    }

    @Override
    protected void onResume()
    {
        super.onResume();

        LocalBroadcastManager.getInstance(this).registerReceiver(this.myLocalReceiver, new IntentFilter("custom-intent-filter"));
        Log.i(MainActivity.TAG, "Receiver registered");

    }

    // consumed locally
    private class LocalBroadcastReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            Log.i(MainActivity.TAG, "triggered by LocalBroadcastManager");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        LocalBroadcastManager.getInstance(this).unregisterReceiver(myLocalReceiver);
        Log.i(MainActivity.TAG, "Receiver UNREGISTERED in onPause()");

    }


    @Override
    public void onClick(View whichView)
    {
        if (whichView.getId() == R.id.btnTrigBroadcast)
        {
            Log.v(MainActivity.TAG, "Button Trigger custom broadcast clicked ");

            Intent customIntent = new Intent();
            customIntent.setAction("android.intent.action.CUSTOM_ACTION");
            this.sendBroadcast(customIntent);
        }else if(whichView.getId() == R.id.btnTrigLocalBroadcast){
            Log.v(MainActivity.TAG, "Button Trigger local broadcast clicked ");

            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("custom-intent-filter"));


        }

    }
}
