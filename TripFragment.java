package com.bignerdranch.android.triplogger;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.File;
import java.util.UUID;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class TripFragment extends Fragment {
    private static final String ARG_TRIP_ID = "trip_id";

    private static final int REQUEST_PHOTO= 2;


    private Trip mTrip;                                           // variable for the trip instance
    private EditText mTitleField;// this method will respond to the user input
    private File mPhotoFile;
    private Button mDateButton;
    private EditText mDestination;
    private EditText mDuration;
    private EditText mComment;
    private ImageButton mPhotoButton;
    private ImageView mPhotoView;
    private Button mDeleteButton;
    private Spinner mTripType;



    public static TripFragment newInstance(UUID tripId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_TRIP_ID, tripId);

        TripFragment fragment = new TripFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public void onCreate(Bundle savedInstanceState){              // implementation
        super.onCreate(savedInstanceState);
        UUID tripId = (UUID) getArguments().getSerializable(ARG_TRIP_ID);
        mTrip = TripLab.get(getActivity()).getTrip(tripId);
        if (mTrip == null) {
            Log.d("TEST", "cannot find the trip with ID: " + tripId.toString());
        }
        mPhotoFile = TripLab.get(getActivity()).getPhotoFile(mTrip);

    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_trip,container, false);


        mTitleField = (EditText)v.findViewById(R.id.trip_title);
        mTitleField.setText(mTrip.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after){
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(                  // this method will return a string, which after that use to set the trip title
                                                        CharSequence s, int start, int before, int count) {
                mTrip.setTitle(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                // this space also left blank too

            }
        });

        mDateButton = (Button)v.findViewById(R.id.trip_date);
        mDateButton.setText(mTrip.getDate().toString());
        mDateButton.setEnabled(false);


        mDestination =(EditText) v.findViewById(R.id.trip_destination);
        mDestination.setText(mTrip.getDestination());
        mDestination.addTextChangedListener(new TextWatcher() {
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
        mTripType = (Spinner) v.findViewById(R.id.TripType);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.trip_arrays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mTripType.setAdapter(adapter);



        mDuration =(EditText) v.findViewById(R.id.trip_duration);
        mDuration.setText(mTrip.getDuration());
        mDuration.addTextChangedListener(new TextWatcher() {
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

        mComment =(EditText) v.findViewById(R.id.trip_comment);
        mComment.setText(mTrip.getComment());
        mComment.addTextChangedListener(new TextWatcher() {
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









        mPhotoButton = (ImageButton)v.findViewById(R.id.trip_camera);
        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        PackageManager packageManager = getActivity().getPackageManager();

        boolean canTakePhoto = mPhotoFile != null &&

                captureImage.resolveActivity(packageManager) != null;
        mPhotoButton.setEnabled(canTakePhoto);

        if (canTakePhoto){
            Uri uri = Uri.fromFile(mPhotoFile);
            captureImage.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        }

        mPhotoButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivityForResult(captureImage, REQUEST_PHOTO);
            }
        });
        mPhotoView = (ImageView)v.findViewById(R.id.trip_photo);
        updatePhotoView();



        return v;

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != Activity.RESULT_OK){

        }else if (requestCode == REQUEST_PHOTO){
            updatePhotoView();
        }

    }
    private void updatePhotoView(){
        if (mPhotoFile == null || !mPhotoFile.exists()){
            mPhotoView.setImageDrawable(null);
        } else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(
                    mPhotoFile.getPath(),getActivity());
            mPhotoView.setImageBitmap(bitmap);
        }
    }

    public void onPause(){
        super.onPause();

        TripLab.get(getActivity()).updateTrip(mTrip);
    }



}


