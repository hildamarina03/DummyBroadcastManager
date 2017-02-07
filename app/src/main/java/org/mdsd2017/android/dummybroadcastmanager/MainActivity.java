package org.mdsd2017.android.dummybroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private BroadcastReceiver myLocalReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button trigBroadcast_Btn = (Button) this.findViewById(R.id.btnTrigBroadcast);
        trigBroadcast_Btn.setOnClickListener(this);

        final Button trigLocalBroadcast_Btn = (Button) this.findViewById(R.id.btnTrigLocalBroadcast);
        trigLocalBroadcast_Btn.setOnClickListener(this);

    }

    @Override
    protected void onResume()
    {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

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


        }

    }
}
