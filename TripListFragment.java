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
public class TripListFragment extends Fragment {

    private RecyclerView mTripRecyclerView;
    private TripAdapter mAdapter;
    private Button mNewButton;
    private Button mSettingButton;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trip_list, container, false);

        mNewButton = (Button) view.findViewById(R.id.log);
        mNewButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Trip trip = new Trip ();
                TripLab.get(getActivity()).addTrip(trip);
                Log.d("TEST", "The new trip id is : " + trip.getId());
                Intent intent = TripActivity.newIntent(getActivity(), trip.getId());
                startActivity(intent);
            }
        });

        mSettingButton = (Button) view.findViewById(R.id.setting);
        mSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Setting setting = new Setting();

                Intent intent = SettingActivity.newIntent(getActivity());
                startActivity(intent);
            }
        });




        mTripRecyclerView = (RecyclerView) view
                .findViewById(R.id.trip_recycler_view);
        mTripRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        updateUI ();
        return view;
    }

    public void onResume(){
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        TripLab tripLab = TripLab.get(getActivity());
        List<Trip> trips = tripLab.getTrips();

        if (mAdapter == null){
            mAdapter = new TripAdapter(trips);
            mTripRecyclerView.setAdapter(mAdapter);
        }else{
            mAdapter.setTrips(trips);
            mAdapter.notifyDataSetChanged();
        }
    }


    private class TripHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private TextView mTripTypeTextView;
        private TextView mDestinationTextView;
        private TextView mDurationTextView;
        private TextView mCommentTextView;

        private Trip mTrip;

        public TripHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_trip_title_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_trip_date_text_view);
            mTripTypeTextView = (TextView) itemView.findViewById(R.id.list_item_trip_trip_type_text_view);
            mDestinationTextView = (TextView) itemView.findViewById(R.id.list_item_trip_destination_text_view);
            mDurationTextView = (TextView) itemView.findViewById(R.id.list_item_trip_duration_text_view);
            mCommentTextView = (TextView) itemView.findViewById(R.id.list_item_trip_comment_text_view);
        }
        public void bindTrip(Trip trip){
            mTrip = trip;
            mTitleTextView.setText(mTrip.getTitle());
            mDateTextView.setText(mTrip.getDate().toString());
            // mTripCheckBox.setChecked(mTrip.isSolved());
        }

        @Override
        public void onClick(View view) {

            Intent intent = TripActivity.newIntent(getActivity(), mTrip.getId());
            startActivity(intent);
        }
    }

    private class TripAdapter extends RecyclerView.Adapter<TripHolder> {
        private List<Trip> mTrips;

        public TripAdapter(List<Trip> trips) {
            mTrips = trips;
        }

        public TripHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_trip, parent, false);
            return new TripHolder(view);
        }
        public void onBindViewHolder(TripHolder holder, int position){
            Trip trip = mTrips.get(position);
            holder.bindTrip(trip);
        }
        public int getItemCount(){
            Log.d("TEST", "The count of trips is: " + mTrips.size());
            return mTrips.size();
        }

        public void setTrips(List<Trip> trips) {
            mTrips= trips;
        }
    }




}
