package com.samsung.myproject.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TrackDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Track track);

    @Query("DELETE FROM track_table")
    void deleteAllTracks();

    @Query("SELECT * FROM track_table ORDER BY imageResource ASC")
    LiveData<List<Track>> getAllTracks();
}
