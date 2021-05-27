package com.samsung.myproject.fragments;

import android.media.SoundPool;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.samsung.myproject.R;

public class DrumsFragment extends Fragment implements View.OnClickListener {
    View view;

    SoundPool soundPool;

    //region Integers
    int crash, tom, bleep, ride;
    int subKick, shaker, closedHiHat, openHiHat;
    int kick, snare, clap, rimShot;
    //endregion

    //region Image Buttons
    ImageButton crashButton, tomButton, bleepButton, rideButton;
    ImageButton subKickButton, shakerButton, closedHiHatButton, openHiHatButton;
    ImageButton kickButton, snareButton, clapButton, rimShotButton;
    //endregion

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_drums, container, false);
        // Inflate the layout for this fragment

        InitializeDrums();
        LoadSounds();

        return view;
    }

    private void InitializeDrums() {
        //region First Row
        crashButton = view.findViewById(R.id.crashButton);
        crashButton.setOnClickListener(this);

        tomButton = view.findViewById(R.id.tomButton);
        tomButton.setOnClickListener(this);

        bleepButton = view.findViewById(R.id.bleepButton);
        bleepButton.setOnClickListener(this);

        rideButton = view.findViewById(R.id.rideButton);
        rideButton.setOnClickListener(this);
        //endregion

        //region Second Row
        subKickButton = view.findViewById(R.id.subKickButton);
        subKickButton.setOnClickListener(this);

        shakerButton = view.findViewById(R.id.shakerButton);
        shakerButton.setOnClickListener(this);

        closedHiHatButton = view.findViewById(R.id.closedHiHatButton);
        closedHiHatButton.setOnClickListener(this);

        openHiHatButton = view.findViewById(R.id.openHiHatButton);
        openHiHatButton.setOnClickListener(this);
        //endregion

        //region Third Row
        kickButton = view.findViewById(R.id.kickButton);
        kickButton.setOnClickListener(this);

        snareButton = view.findViewById(R.id.snareButton);
        snareButton.setOnClickListener(this);

        clapButton = view.findViewById(R.id.clapButton);
        clapButton.setOnClickListener(this);

        rimShotButton = view.findViewById(R.id.rimShotButton);
        rimShotButton.setOnClickListener(this);
        //endregion
    }

    //TODO: ADD ABILITY TO CHANGE SOUNDS
    private void LoadSounds() {
        soundPool = new SoundPool.Builder().setMaxStreams(6).build();

        //region First Row
        crash = soundPool.load(getContext(), R.raw.crash, 1);
        tom = soundPool.load(getContext(), R.raw.tom, 1);
        bleep = soundPool.load(getContext(), R.raw.bleep, 1);
        ride = soundPool.load(getContext(), R.raw.ride, 1);
        //endregion

        //region Second Row
        subKick = soundPool.load(getContext(), R.raw.sub_kick, 1);
        shaker = soundPool.load(getContext(), R.raw.shaker, 1);
        closedHiHat = soundPool.load(getContext(), R.raw.closed_hi_hat, 1);
        openHiHat = soundPool.load(getContext(), R.raw.open_hi_hat, 1);
        //endregion

        //region Third Row
        kick = soundPool.load(getContext(), R.raw.kick, 1);
        clap = soundPool.load(getContext(), R.raw.clap, 1);
        snare = soundPool.load(getContext(), R.raw.snare, 1);
        rimShot = soundPool.load(getContext(), R.raw.rim_shot, 1);
        //endregion
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //region First Row
            case R.id.crashButton:
                soundPool.play(crash, 1, 1, 0, 0, 1);
                break;

            case R.id.tomButton:
                soundPool.play(tom, 1, 1, 0, 0, 1);
                break;

            case R.id.bleepButton:
                soundPool.play(bleep, 1, 1, 0, 0, 1);
                break;

            case R.id.rideButton:
                soundPool.play(ride, 1, 1, 0, 0, 1);
                break;
            //endregion

            //region Second Row
            case R.id.subKickButton:
                soundPool.play(subKick, 1, 1, 0, 0, 1);
                break;

            case R.id.shakerButton:
                soundPool.play(shaker, 1, 1, 0, 0, 1);
                break;

            case R.id.closedHiHatButton:
                soundPool.play(closedHiHat, 1, 1, 0, 0, 1);
                break;

            case R.id.openHiHatButton:
                soundPool.play(openHiHat, 1, 1, 0, 0, 1);
                break;
            //endregion

            //region Third Row
            case R.id.kickButton:
                soundPool.play(kick, 1, 1, 0, 0, 1);
                break;

            case R.id.snareButton:
                soundPool.play(snare, 1, 1, 0, 0, 1);
                break;

            case R.id.clapButton:
                soundPool.play(clap, 1, 1, 0, 0, 1);
                break;

            case R.id.rimShotButton:
                soundPool.play(rimShot, 1, 1, 0, 0, 1);
                break;
            //endregion
        }
    }
}