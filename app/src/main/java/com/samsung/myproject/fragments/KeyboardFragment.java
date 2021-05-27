package com.samsung.myproject.fragments;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;

import com.chibde.visualizer.BarVisualizer;
import com.samsung.myproject.R;

public class KeyboardFragment extends Fragment implements View.OnClickListener {
    View view;

    SoundPool soundPool;
    HorizontalScrollView horizontalScrollView;

    //region Integers
    /*ADD OPTIONAL OCTAVES
    int cMinus2, chMinus2, dMinus2, ebMinus2, eMinus2, fMinus2, fhMinus2, gMinus2, ghMinus2, aMinus2, bbMinus2, bMinus2;
    int cMinus1, chMinus1, dMinus1, ebMinus1, eMinus1, fMinus1, fhMinus1, gMinus1, ghMinus1, aMinus1, bbMinus1, bMinus1;
    int c0, ch0, d0, eb0, e0, f0, fh0, g0, gh0, a0, bb0, b0;
    int c1, ch1, d1, eb1, e1, f1, fh1, g1, gh1, a1, bb1, b1;
    int c2, ch2, d2, eb2, e2, f2, fh2, g2, gh2, a2, bb2, b2;
    */
    int c3, ch3, d3, eb3, e3, f3, fh3, g3, gh3, a3, bb3, b3;
    int c4, ch4, d4, eb4, e4, f4, fh4, g4, gh4, a4, bb4, b4;
    int c5, ch5, d5, eb5, e5, f5, fh5, g5, gh5, a5, bb5, b5;
    int c6, ch6, d6, eb6, e6, f6, fh6, g6, gh6, a6, bb6, b6;
    int c7, ch7, d7, eb7, e7, f7, fh7, g7, gh7, a7, bb7, b7;
    /*OPTIONAL OCTAVES
    int c8, ch8, d8, eb8, e8, f8, fh8, g8, gh8, a8, bb8, b8;
    */
    //endregion

    //region Buttons
    /*OPTIONAL OCTAVES
    Button keyCMinus2, keyCHMinus2, keyDMinus2, keyEBMinus2, keyEMinus2, keyFMinus2, keyFHMinus2, keyGMinus2, keyGHMinus2, keyAMinus2, keyBBMinus2, keyBMinus2;
    Button keyCMinus1, keyCHMinus1, keyDMinus1, keyEBMinus1, keyEMinus1, keyFMinus1, keyFHMinus1, keyGMinus1, keyGHMinus1, keyAMinus1, keyBBMinus1, keyBMinus1;
    Button keyC0, keyCH0, keyD0, keyEB0, keyE0, keyF0, keyFH0, keyG0, keyGH0, keyA0, keyBB0, keyB0;
    Button keyC1, keyCH1, keyD1, keyEB1, keyE1, keyF1, keyFH1, keyG1, keyGH1, keyA1, keyBB1, keyB1;
    Button keyC2, keyCH2, keyD2, keyEB2, keyE2, keyF2, keyFH2, keyG2, keyGH2, keyA2, keyBB2, keyB2;
    */
    Button keyC3, keyCH3, keyD3, keyEB3, keyE3, keyF3, keyFH3, keyG3, keyGH3, keyA3, keyBB3, keyB3;
    Button keyC4, keyCH4, keyD4, keyEB4, keyE4, keyF4, keyFH4, keyG4, keyGH4, keyA4, keyBB4, keyB4;
    Button keyC5, keyCH5, keyD5, keyEB5, keyE5, keyF5, keyFH5, keyG5, keyGH5, keyA5, keyBB5, keyB5;
    Button keyC6, keyCH6, keyD6, keyEB6, keyE6, keyF6, keyFH6, keyG6, keyGH6, keyA6, keyBB6, keyB6;
    Button keyC7, keyCH7, keyD7, keyEB7, keyE7, keyF7, keyFH7, keyG7, keyGH7, keyA7, keyBB7, keyB7;
    /*OPTIONAL OCTAVES
    Button keyC8, keyCH8, keyD8, keyEB8, keyE8, keyF8, keyFH8, keyG8, keyGH8, keyA8, keyBB8, keyB8;
    */
    //endregion

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_keyboard, container, false);
        // Inflate the layout for this fragment


        InitializeKeyboard();
        LoadSounds();

        return view;
    }

    private void InitializeKeyboard() {
        horizontalScrollView = view.findViewById(R.id.HorizontalScrollView);

        /*OPTIONAL OCTAVES:
        //region Initialize Octave -2 Buttons
        keyCMinus2 = view.findViewById(R.id.keyCMinus2);
        keyCMinus2.setOnClickListener(this);
        keyCHMinus2 = view.findViewById(R.id.keyCHMinus2);
        keyCHMinus2.setOnClickListener(this);
        keyDMinus2 = view.findViewById(R.id.keyDMinus2);
        keyDMinus2.setOnClickListener(this);
        keyEBMinus2 = view.findViewById(R.id.keyEBMinus2);
        keyEBMinus2.setOnClickListener(this);
        keyEMinus2 = view.findViewById(R.id.keyEMinus2);
        keyEMinus2.setOnClickListener(this);
        keyFMinus2 = view.findViewById(R.id.keyFMinus2);
        keyFMinus2.setOnClickListener(this);
        keyFHMinus2 = view.findViewById(R.id.keyFHMinus2);
        keyFHMinus2.setOnClickListener(this);
        keyGMinus2 = view.findViewById(R.id.keyGMinus2);
        keyGMinus2.setOnClickListener(this);
        keyGHMinus2 = view.findViewById(R.id.keyGHMinus2);
        keyGHMinus2.setOnClickListener(this);
        keyAMinus2 = view.findViewById(R.id.keyAMinus2);
        keyAMinus2.setOnClickListener(this);
        keyBBMinus2 = view.findViewById(R.id.keyBBMinus2);
        keyBBMinus2.setOnClickListener(this);
        keyBMinus2 = view.findViewById(R.id.keyBMinus2);
        keyBMinus2.setOnClickListener(this);
        //endregion
        endregion*/

        /*OPTIONAL OCTAVES:
        //region Initialize Octave -1 Buttons
        keyCMinus1 = view.findViewById(R.id.keyCMinus1);
        keyCMinus1.setOnClickListener(this);
        keyCHMinus1 = view.findViewById(R.id.keyCHMinus1);
        keyCHMinus1.setOnClickListener(this);
        keyDMinus1 = view.findViewById(R.id.keyDMinus1);
        keyDMinus1.setOnClickListener(this);
        keyEBMinus1 = view.findViewById(R.id.keyEBMinus1);
        keyEBMinus1.setOnClickListener(this);
        keyEMinus1 = view.findViewById(R.id.keyEMinus1);
        keyEMinus1.setOnClickListener(this);
        keyFMinus1 = view.findViewById(R.id.keyFMinus1);
        keyFMinus1.setOnClickListener(this);
        keyFHMinus1 = view.findViewById(R.id.keyFHMinus1);
        keyFHMinus1.setOnClickListener(this);
        keyGMinus1 = view.findViewById(R.id.keyGMinus1);
        keyGMinus1.setOnClickListener(this);
        keyGHMinus1 = view.findViewById(R.id.keyGHMinus1);
        keyGHMinus1.setOnClickListener(this);
        keyAMinus1 = view.findViewById(R.id.keyAMinus1);
        keyAMinus1.setOnClickListener(this);
        keyBBMinus1 = view.findViewById(R.id.keyBBMinus1);
        keyBBMinus1.setOnClickListener(this);
        keyBMinus1 = view.findViewById(R.id.keyBMinus1);
        keyBMinus1.setOnClickListener(this);
        //endregion
        endregion*/

        /*OPTIONAL OCTAVES:
        //region Initialize Octave 0 Buttons
        keyC0 = view.findViewById(R.id.keyC0);
        keyC0.setOnClickListener(this);
        keyCH0 = view.findViewById(R.id.keyCH0);
        keyCH0.setOnClickListener(this);
        keyD0 = view.findViewById(R.id.keyD0);
        keyD0.setOnClickListener(this);
        keyEB0 = view.findViewById(R.id.keyEB0);
        keyEB0.setOnClickListener(this);
        keyE0 = view.findViewById(R.id.keyE0);
        keyE0.setOnClickListener(this);
        keyF0 = view.findViewById(R.id.keyF0);
        keyF0.setOnClickListener(this);
        keyFH0 = view.findViewById(R.id.keyFH0);
        keyFH0.setOnClickListener(this);
        keyG0 = view.findViewById(R.id.keyG0);
        keyG0.setOnClickListener(this);
        keyGH0 = view.findViewById(R.id.keyGH0);
        keyGH0.setOnClickListener(this);
        keyA0 = view.findViewById(R.id.keyA0);
        keyA0.setOnClickListener(this);
        keyBB0 = view.findViewById(R.id.keyBB0);
        keyBB0.setOnClickListener(this);
        keyB0 = view.findViewById(R.id.keyB0);
        keyB0.setOnClickListener(this);
        //endregion
        endregion*/

        /*OPTIONAL OCTAVES:
        //region Initialize Octave 1 Buttons
        keyC1 = view.findViewById(R.id.keyC1);
        keyC1.setOnClickListener(this);
        keyCH1 = view.findViewById(R.id.keyCH1);
        keyCH1.setOnClickListener(this);
        keyD1 = view.findViewById(R.id.keyD1);
        keyD1.setOnClickListener(this);
        keyEB1 = view.findViewById(R.id.keyEB1);
        keyEB1.setOnClickListener(this);
        keyE1 = view.findViewById(R.id.keyE1);
        keyE1.setOnClickListener(this);
        keyF1 = view.findViewById(R.id.keyF1);
        keyF1.setOnClickListener(this);
        keyFH1 = view.findViewById(R.id.keyFH1);
        keyFH1.setOnClickListener(this);
        keyG1 = view.findViewById(R.id.keyG1);
        keyG1.setOnClickListener(this);
        keyGH1 = view.findViewById(R.id.keyGH1);
        keyGH1.setOnClickListener(this);
        keyA1 = view.findViewById(R.id.keyA1);
        keyA1.setOnClickListener(this);
        keyBB1 = view.findViewById(R.id.keyBB1);
        keyBB1.setOnClickListener(this);
        keyB1 = view.findViewById(R.id.keyB1);
        keyB1.setOnClickListener(this);
        //endregion
        endregion*/

        /*OPTIONAL OCTAVES:
        //region Initialize Octave 2 Buttons
        keyC2 = view.findViewById(R.id.keyC2);
        keyC2.setOnClickListener(this);
        keyCH2 = view.findViewById(R.id.keyCH2);
        keyCH2.setOnClickListener(this);
        keyD2 = view.findViewById(R.id.keyD2);
        keyD2.setOnClickListener(this);
        keyEB2 = view.findViewById(R.id.keyEB2);
        keyEB2.setOnClickListener(this);
        keyE2 = view.findViewById(R.id.keyE2);
        keyE2.setOnClickListener(this);
        keyF2 = view.findViewById(R.id.keyF2);
        keyF2.setOnClickListener(this);
        keyFH2 = view.findViewById(R.id.keyFH2);
        keyFH2.setOnClickListener(this);
        keyG2 = view.findViewById(R.id.keyG2);
        keyG2.setOnClickListener(this);
        keyGH2 = view.findViewById(R.id.keyGH2);
        keyGH2.setOnClickListener(this);
        keyA2 = view.findViewById(R.id.keyA2);
        keyA2.setOnClickListener(this);
        keyBB2 = view.findViewById(R.id.keyBB2);
        keyBB2.setOnClickListener(this);
        keyB2 = view.findViewById(R.id.keyB2);
        keyB2.setOnClickListener(this);
        //endregion
        endregion*/

        //region Initialize Octave 3 Buttons
        keyC3 = view.findViewById(R.id.keyC3);
        keyC3.setOnClickListener(this);

        keyCH3 = view.findViewById(R.id.keyCH3);
        keyCH3.setOnClickListener(this);

        keyD3 = view.findViewById(R.id.keyD3);
        keyD3.setOnClickListener(this);

        keyEB3 = view.findViewById(R.id.keyEB3);
        keyEB3.setOnClickListener(this);

        keyE3 = view.findViewById(R.id.keyE3);
        keyE3.setOnClickListener(this);

        keyF3 = view.findViewById(R.id.keyF3);
        keyF3.setOnClickListener(this);

        keyFH3 = view.findViewById(R.id.keyFH3);
        keyFH3.setOnClickListener(this);

        keyG3 = view.findViewById(R.id.keyG3);
        keyG3.setOnClickListener(this);

        keyGH3 = view.findViewById(R.id.keyGH3);
        keyGH3.setOnClickListener(this);

        keyA3 = view.findViewById(R.id.keyA3);
        keyA3.setOnClickListener(this);

        keyBB3 = view.findViewById(R.id.keyBB3);
        keyBB3.setOnClickListener(this);

        keyB3 = view.findViewById(R.id.keyB3);
        keyB3.setOnClickListener(this);
        //endregion

        //region Initialize Octave 4 Buttons
        keyC4 = view.findViewById(R.id.keyC4);
        keyC4.setOnClickListener(this);

        keyCH4 = view.findViewById(R.id.keyCH4);
        keyCH4.setOnClickListener(this);

        keyD4 = view.findViewById(R.id.keyD4);
        keyD4.setOnClickListener(this);

        keyEB4 = view.findViewById(R.id.keyEB4);
        keyEB4.setOnClickListener(this);

        keyE4 = view.findViewById(R.id.keyE4);
        keyE4.setOnClickListener(this);

        keyF4 = view.findViewById(R.id.keyF4);
        keyF4.setOnClickListener(this);

        keyFH4 = view.findViewById(R.id.keyFH4);
        keyFH4.setOnClickListener(this);

        keyG4 = view.findViewById(R.id.keyG4);
        keyG4.setOnClickListener(this);

        keyGH4 = view.findViewById(R.id.keyGH4);
        keyGH4.setOnClickListener(this);

        keyA4 = view.findViewById(R.id.keyA4);
        keyA4.setOnClickListener(this);

        keyBB4 = view.findViewById(R.id.keyBB4);
        keyBB4.setOnClickListener(this);

        keyB4 = view.findViewById(R.id.keyB4);
        keyB4.setOnClickListener(this);
        //endregion

        //region Initialize Octave 5 Buttons
        keyC5 = view.findViewById(R.id.keyC5);
        keyC5.setOnClickListener(this);

        keyCH5 = view.findViewById(R.id.keyCH5);
        keyCH5.setOnClickListener(this);

        keyD5 = view.findViewById(R.id.keyD5);
        keyD5.setOnClickListener(this);

        keyEB5 = view.findViewById(R.id.keyEB5);
        keyEB5.setOnClickListener(this);

        keyE5 = view.findViewById(R.id.keyE5);
        keyE5.setOnClickListener(this);

        keyF5 = view.findViewById(R.id.keyF5);
        keyF5.setOnClickListener(this);

        keyFH5 = view.findViewById(R.id.keyFH5);
        keyFH5.setOnClickListener(this);

        keyG5 = view.findViewById(R.id.keyG5);
        keyG5.setOnClickListener(this);

        keyGH5 = view.findViewById(R.id.keyGH5);
        keyGH5.setOnClickListener(this);

        keyA5 = view.findViewById(R.id.keyA5);
        keyA5.setOnClickListener(this);

        keyBB5 = view.findViewById(R.id.keyBB5);
        keyBB5.setOnClickListener(this);

        keyB5 = view.findViewById(R.id.keyB5);
        keyB5.setOnClickListener(this);
        //endregion

        //region Initialize Octave 6 Buttons
        keyC6 = view.findViewById(R.id.keyC6);
        keyC6.setOnClickListener(this);

        keyCH6 = view.findViewById(R.id.keyCH6);
        keyCH6.setOnClickListener(this);

        keyD6 = view.findViewById(R.id.keyD6);
        keyD6.setOnClickListener(this);

        keyEB6 = view.findViewById(R.id.keyEB6);
        keyEB6.setOnClickListener(this);

        keyE6 = view.findViewById(R.id.keyE6);
        keyE6.setOnClickListener(this);

        keyF6 = view.findViewById(R.id.keyF6);
        keyF6.setOnClickListener(this);

        keyFH6 = view.findViewById(R.id.keyFH6);
        keyFH6.setOnClickListener(this);

        keyG6 = view.findViewById(R.id.keyG6);
        keyG6.setOnClickListener(this);

        keyGH6 = view.findViewById(R.id.keyGH6);
        keyGH6.setOnClickListener(this);

        keyA6 = view.findViewById(R.id.keyA6);
        keyA6.setOnClickListener(this);

        keyBB6 = view.findViewById(R.id.keyBB6);
        keyBB6.setOnClickListener(this);

        keyB6 = view.findViewById(R.id.keyB6);
        keyB6.setOnClickListener(this);
        //endregion

        //region Initialize Octave 7 Buttons
        keyC7 = view.findViewById(R.id.keyC7);
        keyC7.setOnClickListener(this);

        keyCH7 = view.findViewById(R.id.keyCH7);
        keyCH7.setOnClickListener(this);

        keyD7 = view.findViewById(R.id.keyD7);
        keyD7.setOnClickListener(this);

        keyEB7 = view.findViewById(R.id.keyEB7);
        keyEB7.setOnClickListener(this);

        keyE7 = view.findViewById(R.id.keyE7);
        keyE7.setOnClickListener(this);

        keyF7 = view.findViewById(R.id.keyF7);
        keyF7.setOnClickListener(this);

        keyFH7 = view.findViewById(R.id.keyFH7);
        keyFH7.setOnClickListener(this);

        keyG7 = view.findViewById(R.id.keyG7);
        keyG7.setOnClickListener(this);

        keyGH7 = view.findViewById(R.id.keyGH7);
        keyGH7.setOnClickListener(this);

        keyA7 = view.findViewById(R.id.keyA7);
        keyA7.setOnClickListener(this);

        keyBB7 = view.findViewById(R.id.keyBB7);
        keyBB7.setOnClickListener(this);

        keyB7 = view.findViewById(R.id.keyB7);
        keyB7.setOnClickListener(this);
        //endregion

        /*OPTIONAL OCTAVES
        //region Initialize Octave 8 Buttons
        keyC8 = view.findViewById(R.id.keyC8);
        keyC8.setOnClickListener(this);

        keyCH8 = view.findViewById(R.id.keyCH8);
        keyCH8.setOnClickListener(this);

        keyD8 = view.findViewById(R.id.keyD8);
        keyD8.setOnClickListener(this);

        keyEB8 = view.findViewById(R.id.keyEB8);
        keyEB8.setOnClickListener(this);

        keyE8 = view.findViewById(R.id.keyE8);
        keyE8.setOnClickListener(this);

        keyF8 = view.findViewById(R.id.keyF8);
        keyF8.setOnClickListener(this);

        keyFH8 = view.findViewById(R.id.keyFH8);
        keyFH8.setOnClickListener(this);

        keyG8 = view.findViewById(R.id.keyG8);
        keyG8.setOnClickListener(this);

        keyGH8 = view.findViewById(R.id.keyGH8);
        keyGH8.setOnClickListener(this);

        keyA8 = view.findViewById(R.id.keyA8);
        keyA8.setOnClickListener(this);

        keyBB8 = view.findViewById(R.id.keyBB8);
        keyBB8.setOnClickListener(this);

        keyB8 = view.findViewById(R.id.keyB8);
        keyB8.setOnClickListener(this);
        //endregion
        region*/
    }

    //TODO: ADD ABILITY TO CHANGE SOUNDS
    private void LoadSounds() {
        soundPool = new SoundPool.Builder().setMaxStreams(6).build();

        /*OPTIONAL OCTAVES
        //region Octave -2 Sounds
        cMinus2 = soundPool.load(getContext(), R.raw.cMinus2, 1);
        chMinus2 = soundPool.load(getContext(), R.raw.cMinus2, 1);
        dMinus2 = soundPool.load(getContext(), R.raw.cMinus2, 1);
        ebMinus2 = soundPool.load(getContext(), R.raw.cMinus2, 1);
        eMinus2 = soundPool.load(getContext(), R.raw.cMinus2, 1);
        fMinus2 = soundPool.load(getContext(), R.raw.cMinus2, 1);
        fhMinus2 = soundPool.load(getContext(), R.raw.cMinus2, 1);
        gMinus2 = soundPool.load(getContext(), R.raw.cMinus2, 1);
        ghMinus2 = soundPool.load(getContext(), R.raw.cMinus2, 1);
        aMinus2 = soundPool.load(getContext(), R.raw.cMinus2, 1);
        bbMinus2 = soundPool.load(getContext(), R.raw.cMinus2, 1);
        bMinus2 = soundPool.load(getContext(), R.raw.cMinus2, 1);
        //endregion
        */

        /*ADD OPTIONAL OCTAVES
        //region Octave -1 Sounds
        cMinus1 = soundPool.load(getContext(), R.raw.cMinus1, 1);
        chMinus1 = soundPool.load(getContext(), R.raw.cMinus1, 1);
        dMinus1 = soundPool.load(getContext(), R.raw.cMinus1, 1);
        ebMinus1 = soundPool.load(getContext(), R.raw.cMinus1, 1);
        eMinus1 = soundPool.load(getContext(), R.raw.cMinus1, 1);
        fMinus1 = soundPool.load(getContext(), R.raw.cMinus1, 1);
        fhMinus1 = soundPool.load(getContext(), R.raw.cMinus1, 1);
        gMinus1 = soundPool.load(getContext(), R.raw.cMinus1, 1);
        ghMinus1 = soundPool.load(getContext(), R.raw.cMinus1, 1);
        aMinus1 = soundPool.load(getContext(), R.raw.cMinus1, 1);
        bbMinus1 = soundPool.load(getContext(), R.raw.cMinus1, 1);
        bMinus1 = soundPool.load(getContext(), R.raw.cMinus1, 1);
        //endregion
        */

        /*ADD OPTIONAL OCTAVES
        //region Octave 0 Sounds
        c0 = soundPool.load(getContext(), R.raw.c0, 1);
        ch0 = soundPool.load(getContext(), R.raw.ch0, 1);
        d0 = soundPool.load(getContext(), R.raw.d0, 1);
        eb0 = soundPool.load(getContext(), R.raw.eb0, 1);
        e0 = soundPool.load(getContext(), R.raw.e0, 1);
        f0 = soundPool.load(getContext(), R.raw.f0, 1);
        fh0 = soundPool.load(getContext(), R.raw.fh0, 1);
        g0 = soundPool.load(getContext(), R.raw.g0, 1);
        gh0 = soundPool.load(getContext(), R.raw.gh0, 1);
        a0 = soundPool.load(getContext(), R.raw.a0, 1);
        bb0 = soundPool.load(getContext(), R.raw.bb0, 1);
        b0 = soundPool.load(getContext(), R.raw.b0, 1);
        //endregion
        */

        /*OPTIONAL OCTAVES
        //region Octave 1 Sounds
        c1 = soundPool.load(getContext(), R.raw.c1, 1);
        ch1 = soundPool.load(getContext(), R.raw.ch1, 1);
        d1 = soundPool.load(getContext(), R.raw.d1, 1);
        eb1 = soundPool.load(getContext(), R.raw.eb1, 1);
        e1 = soundPool.load(getContext(), R.raw.e1, 1);
        f1 = soundPool.load(getContext(), R.raw.f1, 1);
        fh1 = soundPool.load(getContext(), R.raw.fh1, 1);
        g1 = soundPool.load(getContext(), R.raw.g1, 1);
        gh1 = soundPool.load(getContext(), R.raw.gh1, 1);
        a1 = soundPool.load(getContext(), R.raw.a1, 1);
        bb1 = soundPool.load(getContext(), R.raw.bb1, 1);
        b1 = soundPool.load(getContext(), R.raw.b1, 1);
        //endregion
        */

        /*OPTIONAL OCTAVES
        //region Octave 2 Sounds
        c2 = soundPool.load(getContext(), R.raw.c2, 1);
        ch2 = soundPool.load(getContext(), R.raw.ch2, 1);
        d2 = soundPool.load(getContext(), R.raw.d2, 1);
        eb2 = soundPool.load(getContext(), R.raw.eb2, 1);
        e2 = soundPool.load(getContext(), R.raw.e2, 1);
        f2 = soundPool.load(getContext(), R.raw.f2, 1);
        fh2 = soundPool.load(getContext(), R.raw.fh2, 1);
        g2 = soundPool.load(getContext(), R.raw.g2, 1);
        gh2 = soundPool.load(getContext(), R.raw.gh2, 1);
        a2 = soundPool.load(getContext(), R.raw.a2, 1);
        bb2 = soundPool.load(getContext(), R.raw.bb2, 1);
        b2 = soundPool.load(getContext(), R.raw.b2, 1);
        //endregion
        */

        //region Octave 3 Sounds
        c3 = soundPool.load(getContext(), R.raw.c3, 1);
        ch3 = soundPool.load(getContext(), R.raw.ch3, 1);
        d3 = soundPool.load(getContext(), R.raw.d3, 1);
        eb3 = soundPool.load(getContext(), R.raw.eb3, 1);
        e3 = soundPool.load(getContext(), R.raw.e3, 1);
        f3 = soundPool.load(getContext(), R.raw.f3, 1);
        fh3 = soundPool.load(getContext(), R.raw.fh3, 1);
        g3 = soundPool.load(getContext(), R.raw.g3, 1);
        gh3 = soundPool.load(getContext(), R.raw.gh3, 1);
        a3 = soundPool.load(getContext(), R.raw.a3, 1);
        bb3 = soundPool.load(getContext(), R.raw.bb3, 1);
        b3 = soundPool.load(getContext(), R.raw.b3, 1);
        //endregion

        //region Octave 4 Sounds
        c4 = soundPool.load(getContext(), R.raw.c4, 1);
        ch4 = soundPool.load(getContext(), R.raw.ch4, 1);
        d4 = soundPool.load(getContext(), R.raw.d4, 1);
        eb4 = soundPool.load(getContext(), R.raw.eb4, 1);
        e4 = soundPool.load(getContext(), R.raw.e4, 1);
        f4 = soundPool.load(getContext(), R.raw.f4, 1);
        fh4 = soundPool.load(getContext(), R.raw.fh4, 1);
        g4 = soundPool.load(getContext(), R.raw.g4, 1);
        gh4 = soundPool.load(getContext(), R.raw.gh4, 1);
        a4 = soundPool.load(getContext(), R.raw.a4, 1);
        bb4 = soundPool.load(getContext(), R.raw.bb4, 1);
        b4 = soundPool.load(getContext(), R.raw.b4, 1);
        //endregion

        //region Octave 5 Sounds
        c5 = soundPool.load(getContext(), R.raw.c5, 1);
        ch5 = soundPool.load(getContext(), R.raw.ch5, 1);
        d5 = soundPool.load(getContext(), R.raw.d5, 1);
        eb5 = soundPool.load(getContext(), R.raw.eb5, 1);
        e5 = soundPool.load(getContext(), R.raw.e5, 1);
        f5 = soundPool.load(getContext(), R.raw.f5, 1);
        fh5 = soundPool.load(getContext(), R.raw.fh5, 1);
        g5 = soundPool.load(getContext(), R.raw.g5, 1);
        gh5 = soundPool.load(getContext(), R.raw.gh5, 1);
        a5 = soundPool.load(getContext(), R.raw.a5, 1);
        bb5 = soundPool.load(getContext(), R.raw.bb5, 1);
        b5 = soundPool.load(getContext(), R.raw.b5, 1);
        //endregion

        //region Octave 6 Sounds
        c6 = soundPool.load(getContext(), R.raw.c6, 1);
        ch6 = soundPool.load(getContext(), R.raw.ch6, 1);
        d6 = soundPool.load(getContext(), R.raw.d6, 1);
        eb6 = soundPool.load(getContext(), R.raw.eb6, 1);
        e6 = soundPool.load(getContext(), R.raw.e6, 1);
        f6 = soundPool.load(getContext(), R.raw.f6, 1);
        fh6 = soundPool.load(getContext(), R.raw.fh6, 1);
        g6 = soundPool.load(getContext(), R.raw.g6, 1);
        gh6 = soundPool.load(getContext(), R.raw.gh6, 1);
        a6 = soundPool.load(getContext(), R.raw.a6, 1);
        bb6 = soundPool.load(getContext(), R.raw.bb6, 1);
        b6 = soundPool.load(getContext(), R.raw.b6, 1);
        //endregion

        //region Octave 7 Sounds
        c7 = soundPool.load(getContext(), R.raw.c7, 1);
        ch7 = soundPool.load(getContext(), R.raw.ch7, 1);
        d7 = soundPool.load(getContext(), R.raw.d7, 1);
        eb7 = soundPool.load(getContext(), R.raw.eb7, 1);
        e7 = soundPool.load(getContext(), R.raw.e7, 1);
        f7 = soundPool.load(getContext(), R.raw.f7, 1);
        fh7 = soundPool.load(getContext(), R.raw.fh7, 1);
        g7 = soundPool.load(getContext(), R.raw.g7, 1);
        gh7 = soundPool.load(getContext(), R.raw.gh7, 1);
        a7 = soundPool.load(getContext(), R.raw.a7, 1);
        bb7 = soundPool.load(getContext(), R.raw.bb7, 1);
        b7 = soundPool.load(getContext(), R.raw.b7, 1);
        //endregion

        /*OPTIONAL OCTAVES
        //region Octave 8 Sounds
        c8 = soundPool.load(getContext(), R.raw.c8, 1);
        ch8 = soundPool.load(getContext(), R.raw.ch8, 1);
        d8 = soundPool.load(getContext(), R.raw.d8, 1);
        eb8 = soundPool.load(getContext(), R.raw.eb8, 1);
        e8 = soundPool.load(getContext(), R.raw.e8, 1);
        f8 = soundPool.load(getContext(), R.raw.f8, 1);
        fh8 = soundPool.load(getContext(), R.raw.fh8, 1);
        g8 = soundPool.load(getContext(), R.raw.g8, 1);
        gh8 = soundPool.load(getContext(), R.raw.gh8, 1);
        a8 = soundPool.load(getContext(), R.raw.a8, 1);
        bb8 = soundPool.load(getContext(), R.raw.bb8, 1);
        b8 = soundPool.load(getContext(), R.raw.b8, 1);
        //endregion
        */
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*OPTIONAL OCTAVES
            //region Octave -2 Cases
            case R.id.keyCMinus2:
                soundPool.play(cMinus2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyCHMinus2:
                soundPool.play(chMinus2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyDMinus2:
                soundPool.play(dMinus2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyEBMinus2:
                soundPool.play(ebMinus2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyEMinus2:
                soundPool.play(eMinus2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyFMinus2:
                soundPool.play(fMinus2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyFHMinus2:
                soundPool.play(fhMinus2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyGMinus2:
                soundPool.play(gMinus2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyGHMinus2:
                soundPool.play(ghMinus2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyAMinus2:
                soundPool.play(aMinus2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyBBMinus2:
                soundPool.play(bbMinus2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyBMinus2:
                soundPool.play(bMinus2, 1, 1, 0, 0, 1);
                break;
            //endregion
            */

            /*OPTIONAL OCTAVES
            //region Octave -1 Cases
            case R.id.keyCMinus1:
                soundPool.play(cMinus1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyCHMinus1:
                soundPool.play(chMinus1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyDMinus1:
                soundPool.play(dMinus1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyEBMinus1:
                soundPool.play(ebMinus1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyEMinus1:
                soundPool.play(eMinus1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyFMinus1:
                soundPool.play(fMinus1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyFHMinus1:
                soundPool.play(fhMinus1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyGMinus1:
                soundPool.play(gMinus1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyGHMinus1:
                soundPool.play(ghMinus1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyAMinus1:
                soundPool.play(aMinus1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyBBMinus1:
                soundPool.play(bbMinus1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyBMinus1:
                soundPool.play(bMinus1, 1, 1, 0, 0, 1);
                break;
            //endregion
            */

            /*OPTIONAL OCTAVES
            //region Octave 0 Cases
            case R.id.keyC0:
                soundPool.play(c0, 1, 1, 0, 0, 1);
                break;
            case R.id.keyCH0:
                soundPool.play(ch0, 1, 1, 0, 0, 1);
                break;
            case R.id.keyD0:
                soundPool.play(d0, 1, 1, 0, 0, 1);
                break;
            case R.id.keyEB0:
                soundPool.play(eb0, 1, 1, 0, 0, 1);
                break;
            case R.id.keyE0:
                soundPool.play(e0, 1, 1, 0, 0, 1);
                break;
            case R.id.keyF0:
                soundPool.play(f0, 1, 1, 0, 0, 1);
                break;
            case R.id.keyFH0:
                soundPool.play(fh0, 1, 1, 0, 0, 1);
                break;
            case R.id.keyG0:
                soundPool.play(g0, 1, 1, 0, 0, 1);
                break;
            case R.id.keyGH0:
                soundPool.play(gh0, 1, 1, 0, 0, 1);
                break;
            case R.id.keyA0:
                soundPool.play(a0, 1, 1, 0, 0, 1);
                break;
            case R.id.keyBB0:
                soundPool.play(bb0, 1, 1, 0, 0, 1);
                break;
            case R.id.keyB0:
                soundPool.play(b0, 1, 1, 0, 0, 1);
                break;
            //endregion
            */

            /*OPTIONAL OCTAVES
            //region Octave 1 Cases
            case R.id.keyC1:
                soundPool.play(c1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyCH1:
                soundPool.play(ch1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyD1:
                soundPool.play(d1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyEB1:
                soundPool.play(eb1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyE1:
                soundPool.play(e1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyF1:
                soundPool.play(f1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyFH1:
                soundPool.play(fh1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyG1:
                soundPool.play(g1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyGH1:
                soundPool.play(gh1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyA1:
                soundPool.play(a1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyBB1:
                soundPool.play(bb1, 1, 1, 0, 0, 1);
                break;
            case R.id.keyB1:
                soundPool.play(b1, 1, 1, 0, 0, 1);
                break;
            //endregion
            */

            /*OPTIONAL OCTAVES
            //region Octave 2 Cases
            case R.id.keyC2:
                soundPool.play(c2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyCH2:
                soundPool.play(ch2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyD2:
                soundPool.play(d2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyEB2:
                soundPool.play(eb2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyE2:
                soundPool.play(e2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyF2:
                soundPool.play(f2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyFH2:
                soundPool.play(fh2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyG2:
                soundPool.play(g2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyGH2:
                soundPool.play(gh2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyA2:
                soundPool.play(a2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyBB2:
                soundPool.play(bb2, 1, 1, 0, 0, 1);
                break;
            case R.id.keyB2:
                soundPool.play(b2, 1, 1, 0, 0, 1);
                break;
            //endregion
            */

            //region Octave 3 Cases
            case R.id.keyC3:
                soundPool.play(c3, 1, 1, 0, 0, 1);
                break;

            case R.id.keyCH3:
                soundPool.play(ch3, 1, 1, 0, 0, 1);
                break;

            case R.id.keyD3:
                soundPool.play(d3, 1, 1, 0, 0, 1);
                break;

            case R.id.keyEB3:
                soundPool.play(eb3, 1, 1, 0, 0, 1);
                break;

            case R.id.keyE3:
                soundPool.play(e3, 1, 1, 0, 0, 1);
                break;

            case R.id.keyF3:
                soundPool.play(f3, 1, 1, 0, 0, 1);
                break;

            case R.id.keyFH3:
                soundPool.play(fh3, 1, 1, 0, 0, 1);
                break;

            case R.id.keyG3:
                soundPool.play(g3, 1, 1, 0, 0, 1);
                break;

            case R.id.keyGH3:
                soundPool.play(gh3, 1, 1, 0, 0, 1);
                break;

            case R.id.keyA3:
                soundPool.play(a3, 1, 1, 0, 0, 1);
                break;

            case R.id.keyBB3:
                soundPool.play(bb3, 1, 1, 0, 0, 1);
                break;

            case R.id.keyB3:
                soundPool.play(b3, 1, 1, 0, 0, 1);
                break;
            //endregion

            //region Octave 4 Cases
            case R.id.keyC4:
                soundPool.play(c4, 1, 1, 0, 0, 1);
                break;

            case R.id.keyCH4:
                soundPool.play(ch4, 1, 1, 0, 0, 1);
                break;

            case R.id.keyD4:
                soundPool.play(d4, 1, 1, 0, 0, 1);
                break;

            case R.id.keyEB4:
                soundPool.play(eb4, 1, 1, 0, 0, 1);
                break;

            case R.id.keyE4:
                soundPool.play(e4, 1, 1, 0, 0, 1);
                break;

            case R.id.keyF4:
                soundPool.play(f4, 1, 1, 0, 0, 1);
                break;

            case R.id.keyFH4:
                soundPool.play(fh4, 1, 1, 0, 0, 1);
                break;

            case R.id.keyG4:
                soundPool.play(g4, 1, 1, 0, 0, 1);
                break;

            case R.id.keyGH4:
                soundPool.play(gh4, 1, 1, 0, 0, 1);
                break;

            case R.id.keyA4:
                soundPool.play(a4, 1, 1, 0, 0, 1);
                break;

            case R.id.keyBB4:
                soundPool.play(bb4, 1, 1, 0, 0, 1);
                break;

            case R.id.keyB4:
                soundPool.play(b4, 1, 1, 0, 0, 1);
                break;
            //endregion

            //region Octave 5 Cases
            case R.id.keyC5:
                soundPool.play(c5, 1, 1, 0, 0, 1);
                break;

            case R.id.keyCH5:
                soundPool.play(ch5, 1, 1, 0, 0, 1);
                break;

            case R.id.keyD5:
                soundPool.play(d5, 1, 1, 0, 0, 1);
                break;

            case R.id.keyEB5:
                soundPool.play(eb5, 1, 1, 0, 0, 1);
                break;

            case R.id.keyE5:
                soundPool.play(e5, 1, 1, 0, 0, 1);
                break;

            case R.id.keyF5:
                soundPool.play(f5, 1, 1, 0, 0, 1);
                break;

            case R.id.keyFH5:
                soundPool.play(fh5, 1, 1, 0, 0, 1);
                break;

            case R.id.keyG5:
                soundPool.play(g5, 1, 1, 0, 0, 1);
                break;

            case R.id.keyGH5:
                soundPool.play(gh5, 1, 1, 0, 0, 1);
                break;

            case R.id.keyA5:
                soundPool.play(a5, 1, 1, 0, 0, 1);
                break;

            case R.id.keyBB5:
                soundPool.play(bb5, 1, 1, 0, 0, 1);
                break;

            case R.id.keyB5:
                soundPool.play(b5, 1, 1, 0, 0, 1);
                break;
            //endregion

            //region Octave 6 Cases
            case R.id.keyC6:
                soundPool.play(c6, 1, 1, 0, 0, 1);
                break;

            case R.id.keyCH6:
                soundPool.play(ch6, 1, 1, 0, 0, 1);
                break;

            case R.id.keyD6:
                soundPool.play(d6, 1, 1, 0, 0, 1);
                break;

            case R.id.keyEB6:
                soundPool.play(eb6, 1, 1, 0, 0, 1);
                break;

            case R.id.keyE6:
                soundPool.play(e6, 1, 1, 0, 0, 1);
                break;

            case R.id.keyF6:
                soundPool.play(f6, 1, 1, 0, 0, 1);
                break;

            case R.id.keyFH6:
                soundPool.play(fh6, 1, 1, 0, 0, 1);
                break;

            case R.id.keyG6:
                soundPool.play(g6, 1, 1, 0, 0, 1);
                break;

            case R.id.keyGH6:
                soundPool.play(gh6, 1, 1, 0, 0, 1);
                break;

            case R.id.keyA6:
                soundPool.play(a6, 1, 1, 0, 0, 1);
                break;

            case R.id.keyBB6:
                soundPool.play(bb6, 1, 1, 0, 0, 1);
                break;

            case R.id.keyB6:
                soundPool.play(b6, 1, 1, 0, 0, 1);
                break;
            //endregion

            //region Octave 7 Cases
            case R.id.keyC7:
                soundPool.play(c7, 1, 1, 0, 0, 1);
                break;

            case R.id.keyCH7:
                soundPool.play(ch7, 1, 1, 0, 0, 1);
                break;

            case R.id.keyD7:
                soundPool.play(d7, 1, 1, 0, 0, 1);
                break;

            case R.id.keyEB7:
                soundPool.play(eb7, 1, 1, 0, 0, 1);
                break;

            case R.id.keyE7:
                soundPool.play(e7, 1, 1, 0, 0, 1);
                break;

            case R.id.keyF7:
                soundPool.play(f7, 1, 1, 0, 0, 1);
                break;

            case R.id.keyFH7:
                soundPool.play(fh7, 1, 1, 0, 0, 1);
                break;

            case R.id.keyG7:
                soundPool.play(g7, 1, 1, 0, 0, 1);
                break;

            case R.id.keyGH7:
                soundPool.play(gh7, 1, 1, 0, 0, 1);
                break;

            case R.id.keyA7:
                soundPool.play(a7, 1, 1, 0, 0, 1);
                break;

            case R.id.keyBB7:
                soundPool.play(bb7, 1, 1, 0, 0, 1);
                break;

            case R.id.keyB7:
                soundPool.play(b7, 1, 1, 0, 0, 1);
                break;
            //endregion

            /*OPTIONAL OCTAVES
            //region Octave 8 Cases
            case R.id.keyC8:
                soundPool.play(c8, 1, 1, 0, 0, 1);
                break;
            case R.id.keyCH8:
                soundPool.play(ch8, 1, 1, 0, 0, 1);
                break;
            case R.id.keyD8:
                soundPool.play(d8, 1, 1, 0, 0, 1);
                break;
            case R.id.keyEB8:
                soundPool.play(eb8, 1, 1, 0, 0, 1);
                break;
            case R.id.keyE8:
                soundPool.play(e8, 1, 1, 0, 0, 1);
                break;
            case R.id.keyC8:
                soundPool.play(f8, 1, 1, 0, 0, 1);
                break;
            case R.id.keyFH8:
                soundPool.play(fh8, 1, 1, 0, 0, 1);
                break;
            case R.id.keyG8:
                soundPool.play(g8, 1, 1, 0, 0, 1);
                break;
            case R.id.keyGH8:
                soundPool.play(gh8, 1, 1, 0, 0, 1);
                break;
            case R.id.keyA8:
                soundPool.play(a8, 1, 1, 0, 0, 1);
                break;
            case R.id.keyBB8:
                soundPool.play(bb8, 1, 1, 0, 0, 1);
                break;
            case R.id.keyB8:
                soundPool.play(b8, 1, 1, 0, 0, 1);
                break;
            //endregion
            */
        }
    }
}