package com.samsung.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.samsung.myproject.data.Track;

import java.util.ArrayList;
import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder> {
    private final LayoutInflater layoutInflater;
    private List<Track> tracks;

    OnTrackListener trackListener;

    public TrackAdapter(Context context, OnTrackListener trackListener) {
        layoutInflater = LayoutInflater.from(context);
        this.trackListener = trackListener;
    }

    @Override
    public TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.track_row, parent, false);
        return new TrackViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TrackViewHolder holder, int position) {
        if (tracks != null) {
            Track currentTrack = tracks.get(position);

            holder.imageButton.setImageResource(currentTrack.getImageResource());
            holder.textView.setText(currentTrack.getTrack());

        } else {
            holder.imageButton.setImageResource(android.R.drawable.ic_input_add);
            holder.textView.setText("Add");
        }
    }

    public Track getTrackAt(int position) {
        return tracks.get(position);
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (tracks != null) {
            return tracks.size();
        } else {
            return 0;
        }
    }

    public class TrackViewHolder extends RecyclerView.ViewHolder {
        private final ImageButton imageButton;
        private final TextView textView;

        public TrackViewHolder(@NonNull View itemView) {
            super(itemView);

            imageButton = itemView.findViewById(R.id.imageButton2);
            textView = itemView.findViewById(R.id.textView2);

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    trackListener.onTrackClick(imageButton);
                }
            });

            imageButton.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    trackListener.onTrackLongClick(imageButton);

                    return false;
                }
            });
        }
    }
}
