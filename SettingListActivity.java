package com.bignerdranch.android.triplogger;

import android.support.v4.app.Fragment;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class SettingListActivity extends SingleFragmentActivity{
    protected Fragment createFragment(){
        return new SettingListFragment();
    }

}
