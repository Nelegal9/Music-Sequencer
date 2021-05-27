package com.samsung.myproject.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.samsung.myproject.OnTrackListener;
import com.samsung.myproject.R;
import com.samsung.myproject.TrackAdapter;
import com.samsung.myproject.data.Track;
import com.samsung.myproject.data.TrackViewModel;

import java.util.List;

public class TrackFragment extends Fragment implements OnTrackListener {
    View view;
    private TrackViewModel trackViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_track, container, false);
        // Inflate the layout for this fragment

        RecyclerView recyclerView = view.findViewById(R.id.RecyclerView);
        final TrackAdapter trackAdapter = new TrackAdapter(getContext(), this);
        recyclerView.setAdapter(trackAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        trackViewModel = new TrackViewModel();
        trackViewModel.getAllTracks().observe(getViewLifecycleOwner(), new Observer<List<Track>>() {
            @Override
            public void onChanged(List<Track> tracks) {
                trackAdapter.setTracks(tracks);
            }
        });

        return view;
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END, 0) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int fromPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();

            //Collections.swap(trackViewModel, fromPosition, toPosition);

            recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);

            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };

    @Override
    public void onTrackClick(ImageButton imageButton) {
        PopupMenu popupMenu = new PopupMenu(getActivity(), imageButton);
        popupMenu.setForceShowIcon(true);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.keyboard:
                        addKeyboardToDatabase();

                        Toast.makeText(getActivity(), "Keyboard Selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.drums:
                        addDrumsToDatabase();

                        Toast.makeText(getActivity(), "Drums Selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.audioRecorder:
                        addAudioRecorderToDatabase();
                        Toast.makeText(getActivity(), "Audio Recorder Selected", Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });

        popupMenu.show();
    }

    @Override
    public void onTrackLongClick(ImageButton imageButton) {
    }

    private void addKeyboardToDatabase() {
        Navigation.findNavController(view).navigate(R.id.keyboardFragment);
        Track track = new Track(R.drawable.keyboard, "Keyboard");
        trackViewModel.insert(track);
    }

    private void addDrumsToDatabase() {
        Navigation.findNavController(view).navigate(R.id.drumsFragment);
        Track track = new Track(R.drawable.drums, "Drums");
        trackViewModel.insert(track);
    }

    private void addAudioRecorderToDatabase() {
        Navigation.findNavController(view).navigate(R.id.audioRecorderFragment);
        Track track = new Track(R.drawable.microphone, "Audio Recorder");
        trackViewModel.insert(track);
    }
}