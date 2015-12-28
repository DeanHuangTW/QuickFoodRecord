package com.example.quickfoodrecord;

import com.example.quickfoodrecord.helper.Command;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment implements OnClickListener{
    private Button mBtnRecord;
    private Button mBtnQuery;
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mBtnRecord = (Button) view.findViewById(R.id.button_record);
        mBtnRecord.setOnClickListener(this);
        mBtnQuery = (Button) view.findViewById(R.id.button_query);
        mBtnQuery.setOnClickListener(this);
        return view;        
    }

    @Override
    public void onClick(View view) {
        if (view == mBtnRecord) {
            Message msg = Message.obtain(
                    ((MainActivity) getActivity()).getMainHandler(), 
                    Command.FRAGMENT_RECORD.ordinal());
            msg.sendToTarget();
        } else if( view == mBtnQuery) {
            Message msg = Message.obtain(
                    ((MainActivity) getActivity()).getMainHandler(), 
                    Command.FRAGMENT_QUERY.ordinal());
            msg.sendToTarget();
        }
    }
}
