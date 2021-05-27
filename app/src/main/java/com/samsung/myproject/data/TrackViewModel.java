package com.samsung.myproject.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class TrackViewModel extends ViewModel {
    private TrackRepository trackRepository;
    private LiveData<List<Track>> allTracks;

    public TrackViewModel() {

        trackRepository = new TrackRepository();
        allTracks = trackRepository.getAllTracks();
    }

    public LiveData<List<Track>> getAllTracks() {
        return allTracks;
    }

    public void insert(Track track) {
        trackRepository.insert(track);
    }
}
