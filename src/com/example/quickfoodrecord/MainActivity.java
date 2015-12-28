package com.example.quickfoodrecord;

import com.example.quickfoodrecord.helper.Command;
import com.example.quickfoodrecord.helper.UIComm;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MainActivity extends Activity {
    private final String TAG = "MainActivity";
    
    private MainHandler mMainHanlder;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mMainHanlder = new MainHandler();
        
        // Load MainFragment
        Message msg = Message.obtain(mMainHanlder, Command.FRAGMENT_MAIN.ordinal());
        msg.sendToTarget();
    }

    public Handler getMainHandler() {
        return mMainHanlder;
    }
    
    private class MainHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Log.i(TAG, "Get a handler message");
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            
            switch (Command.values()[msg.what]) {
            case FRAGMENT_MAIN:
                Log.i(TAG, "    FRAGMENT_MAIN");
                MainFragment mainFragment = new MainFragment();
                ft.replace(R.id.main_frame, mainFragment, UIComm.FragmentTAG[0]);
                ft.commitAllowingStateLoss();
                break;
            case FRAGMENT_RECORD:
                Log.i(TAG, "    FRAGMENT_RECORD");
                RecordFragment recordFragment = new RecordFragment();
                ft.replace(R.id.main_frame, recordFragment, UIComm.FragmentTAG[1]);
                ft.commitAllowingStateLoss();
                break;
            case FRAGMENT_QUERY:
                Log.i(TAG, "    FRAGMENT_QUERY");
                break;
            }
        }
    }
}
