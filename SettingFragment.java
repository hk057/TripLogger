package com.bignerdranch.android.triplogger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class SettingFragment extends Fragment {

    private static final String ARG_Setting_ID ="setting_id";

    private Setting mSetting;
    private EditText mName;
    private EditText mGender;
    private EditText mEmail;
    private EditText mSID;
    private EditText mComment;

    public static SettingFragment newInstance(){

        SettingFragment fragment = new SettingFragment();
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mSetting = SettingLab.get(getActivity()).getSetting();


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting, container, false);

        mName = (EditText) v.findViewById(R.id.setting_name);
        mName.setText(mSetting.getName());
        mName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // this space intentionally left blank
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mSetting.setName(s.toString());
            }

            public void afterTextChanged(Editable s) {

            }


        });



        mGender = (EditText) v.findViewById(R.id.setting_gender);
        mGender.setText(mSetting.getGender());
        mGender.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mComment = (EditText) v.findViewById(R.id.setting_comment);
        mComment.setText(mSetting.getComment());
        mComment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int before) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEmail = (EditText) v.findViewById(R.id.setting_email);
        mEmail.setText(mSetting.getEmail());
        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int before) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }


        });

        mSID = (EditText) v.findViewById(R.id.setting_sid);
        mSID.setText(mSetting.getSID());
        mSID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int before) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return v;

    }
}
