package com.samsung.myproject.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "track_table")
public class Track {
    @PrimaryKey
    @NonNull
    private int imageResource;

    @ColumnInfo(name = "track")
    private String track;

    public Track(@NonNull int imageResource, String track) {
        this.imageResource = imageResource;
        this.track = track;
    }

    public int getImageResource() {
        return this.imageResource;
    }

    public String getTrack() {
        return this.track;
    }
}
