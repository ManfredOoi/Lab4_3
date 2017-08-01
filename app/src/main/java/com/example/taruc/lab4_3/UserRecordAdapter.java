package com.example.taruc.lab4_3;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TAR UC on 7/28/2017.
 */

public class UserRecordAdapter extends ArrayAdapter<UserRecord> {
    public UserRecordAdapter(Activity context, int resource, List<UserRecord> list) { //activity call adapter, resource which part of activity want to dispplay data or called as layout present record
        super(context, resource, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { // to put data and the layout tgt, convert view is individual record,
        //  position is the position of the record, the first = 0
        // convertView  = layout of an activity
        // parent = layout of an activity

        UserRecord userRecord = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.user_record,
                            parent,
                            false);
        }

        TextView textViewPhone, textViewName, textViewEmail;

        textViewPhone = (TextView) convertView.findViewById(R.id.textViewPhone);
        textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        textViewEmail = (TextView) convertView.findViewById(R.id.textViewEmail);


        textViewPhone.setText(textViewPhone.getText() + " : " + userRecord.getPhone());
        textViewName.setText(userRecord.getName());
        textViewEmail.setText(textViewEmail.getText() + " : " + userRecord.getEmail());


        return convertView;

    }
}
