package com.bignerdranch.android.triplogger;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class SettingActivity extends FragmentActivity {
    private static final String EXTRA_Setting_ID = "\"com.bignerdranch.android.triplogger.setting_id";

    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext,SettingActivity.class);
        return intent;
    }

    protected Fragment createFragment(){
        return SettingFragment.newInstance();
    }

}
