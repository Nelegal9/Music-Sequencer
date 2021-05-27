package com.samsung.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    static int MICROPHONE_PERMISSION_CODE = 200;

    ImageButton saveAndUploadButton, playStopButton, recordButton;

    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    boolean isRecording, isPlaying;

    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storageReference = FirebaseStorage.getInstance().getReference();

        if (isMicrophonePresent()) {
            getMicrophonePermission();
        }

        saveAndUploadButton = findViewById(R.id.saveButton);
        saveAndUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadFile();
            }
        });

        recordButton = findViewById(R.id.recordButton);
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRecording) {
                    try {
                        isRecording = true;
                        startRecording();
                    } catch (Exception e) {
                        e.printStackTrace();

                        Toast.makeText(getApplicationContext(), "Couldn't Record", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    isRecording = false;
                    stopRecording();
                }
            }
        });

        playStopButton = findViewById(R.id.playStopButton);
        playStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying) {
                    isPlaying = true;
                    play();

                } else {
                    isPlaying = false;
                    stopPlay();
                }
            }
        });
    }

    private boolean isMicrophonePresent() {
        if (this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)) {
            return true;
        } else {
            return false;
        }
    }

    private void getMicrophonePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.RECORD_AUDIO }, MICROPHONE_PERMISSION_CODE);
        }
    }

    private void startRecording() {
        try {
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            mediaRecorder.setOutputFile(getRecordingFilePath());
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            mediaRecorder.prepare();
            mediaRecorder.start();

            Toast.makeText(getApplicationContext(), "Recording...", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();

            Toast.makeText(getApplicationContext(), "Couldn't Record", Toast.LENGTH_SHORT).show();
        }
    }

    private String getRecordingFilePath() {
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File musicDirectory = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File audioFile = new File(musicDirectory, "testRecording" + ".mp3");

        return audioFile.getPath();
    }

    private void stopRecording() {
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;

        Toast.makeText(getApplicationContext(), "Recording Stopped", Toast.LENGTH_SHORT).show();
    }

    private void play() {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(getRecordingFilePath());
            mediaPlayer.prepare();
            mediaPlayer.start();

            playStopButton.setImageResource(R.drawable.ic_stop);
            Toast.makeText(getApplicationContext(), "Playing...", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();

            Toast.makeText(getApplicationContext(), "Couldn't Play", Toast.LENGTH_SHORT).show();
        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                isPlaying = false;
                stopPlay();
            }
        });
    }

    private void stopPlay() {
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
        playStopButton.setImageResource(R.drawable.ic_play);
        Toast.makeText(getApplicationContext(), "Playing Stopped", Toast.LENGTH_SHORT).show();

    }

    private void uploadFile() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Uploading...");


        Uri uri = Uri.fromFile(new File("path/to/music/testRecording.mp3"));
        StorageReference testRecordingRef = storageReference.child("music/testRecording.mp3");

        testRecordingRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failed. Nothing Special", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}