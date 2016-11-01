package com.bignerdranch.android.triplogger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class SettingListFragment extends Fragment {
    private RecyclerView mSettingRecyclerView;
    private SettingAdapter mAdapter;
    private Button mNewButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_list, container, false);

        mSettingRecyclerView = (RecyclerView) view
                .findViewById(R.id.setting_recycler_view);
        mSettingRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mNewButton = (Button) view.findViewById(R.id.new_setting_button);
        mNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Setting setting = new Setting ();
                SettingLab.get(getActivity()).addSetting(setting);
                Log.d("TEST", "The new trip id is : " + setting.getID());
                Intent intent = TripActivity.newIntent(getActivity(), setting.getID());
                startActivity(intent);
            }

        });
        updateUI();
        return view;

    }
    private void updateUI(){
        SettingLab settingLab = SettingLab.get(getActivity());
        List<Setting> settings = settingLab.getSettings();

        if (mAdapter == null) {
            mAdapter = new SettingAdapter(settings);
            mSettingRecyclerView.setAdapter(mAdapter);
        }else{
            mAdapter.setSettings(settings);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class SettingHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Setting mSetting;


        private TextView mNameTextView;
        private TextView mIDTextView;
        private TextView mGenderTextView;
        private TextView mEmailTextView;
        private TextView mCommentTextView;

        public SettingHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);



            mNameTextView = (TextView)
                    itemView.findViewById(R.id.list_item_setting_name_text_view);
            mIDTextView = (TextView)
                    itemView.findViewById(R.id.list_item_setting_id_text_view);
            mGenderTextView = (TextView)
                    itemView.findViewById(R.id.list_item_setting_gender_text_view);
            mEmailTextView = (TextView)
                    itemView.findViewById(R.id.list_item_setting_email_text_view);
            mCommentTextView = (TextView)
                    itemView.findViewById(R.id.list_item_setting_comment_text_view);


        }



        @Override
        public void onClick(View v) {
            Setting setting = new Setting ();
            SettingLab.get(getActivity()).addSetting(setting);
            Log.d("TEST", "The new setting id is : " + setting.getID());
            Intent intent = TripActivity.newIntent(getActivity(), mSetting.getID());
            startActivity(intent);

        }

        public void bindSetting(Setting setting){
            mSetting = setting;

            mNameTextView.setText(mSetting.getName());
            mIDTextView.setText(mSetting.getID().toString());
            mGenderTextView.setText(mSetting.getGender());
            mCommentTextView.setText(mSetting.getComment());
            mEmailTextView.setText(mSetting.getEmail());
        }
    }


    private class SettingAdapter extends RecyclerView.Adapter<SettingHolder>{
        private List<Setting> mSettings;

        public SettingAdapter(List<Setting> settings){
            mSettings = settings;
        }

        @Override
        public SettingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_setting, parent, false);
            return new SettingHolder(view);

        }

        @Override
        public void onBindViewHolder(SettingHolder holder, int position) {
            Setting setting = mSettings.get(position);
            Log.d("TEST", "Setting record number: " + mSettings.size());
            holder.bindSetting(setting);

        }

        @Override
        public int getItemCount() {
            return mSettings.size();
        }

        public void setSettings(List<Setting> settings) {
            mSettings = settings;
        }
    }



}
