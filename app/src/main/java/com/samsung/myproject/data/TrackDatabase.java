package com.samsung.myproject.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.samsung.myproject.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Track.class}, version = 1, exportSchema = false)
public abstract class TrackDatabase extends RoomDatabase {
    public abstract TrackDao trackDao();
    private static TrackDatabase instance;

    static TrackDatabase getTrackDatabase(final Context context) {
        if (instance == null) {
            synchronized (TrackDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), TrackDatabase.class, "track_database").fallbackToDestructiveMigration().addCallback(trackDatabaseCallback).build();
                }
            }
        }

        return instance;
    }

    private static RoomDatabase.Callback trackDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase database) {
            super.onOpen(database);

            new PopulateDatabaseAsync(instance).execute();
        }
    };

    private static class PopulateDatabaseAsync extends AsyncTask<Void, Void, Void> {
        private final TrackDao trackDao;
        //tracks

        PopulateDatabaseAsync(TrackDatabase database) {
            trackDao = database.trackDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            trackDao.deleteAllTracks();

            Track track = new Track(android.R.drawable.ic_input_add, "Add");
            trackDao.insert(track);

            return null;
        }
    }
}
