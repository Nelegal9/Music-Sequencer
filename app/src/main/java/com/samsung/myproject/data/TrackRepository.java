package com.samsung.myproject.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.samsung.myproject.App;

import java.util.List;

public class TrackRepository {
    private TrackDao trackDao;
    private LiveData<List<Track>> allTracks;

    public TrackRepository() {
        TrackDatabase trackDatabase = TrackDatabase.getTrackDatabase(App.getApplication());
        trackDao = trackDatabase.trackDao();
        allTracks = trackDao.getAllTracks();
    }

    LiveData<List<Track>> getAllTracks() {
        return allTracks;
    }

    void insert(Track track) {
        new insertAsyncTask(trackDao).execute(track);
    }

    private static class insertAsyncTask extends AsyncTask<Track, Void, Void> {
        private TrackDao asyncTaskDao;

        insertAsyncTask(TrackDao trackDao) {
            asyncTaskDao = trackDao;
        }

        @Override
        protected Void doInBackground(final Track... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
