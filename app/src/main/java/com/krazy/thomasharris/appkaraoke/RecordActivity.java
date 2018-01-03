package com.krazy.thomasharris.appkaraoke;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class RecordActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private MediaRecorder recorder;
    private String OUTPUT_FILE;
    Button start, stop, play, pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        OUTPUT_FILE = Environment.getExternalStorageState();

        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    beginRecording();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopRecording();
            }
        });

        play = (Button) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    playRecording();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        pause = (Button) findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseRecording();
            }
        });


    }

    public void pauseRecording() {
        if(mediaPlayer != null)
            mediaPlayer.stop();
    }

    public void ditchMediaPlayer() {
        if(mediaPlayer != null)
        {
            try{
                mediaPlayer.release();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void beginRecording() throws IOException {
        ditchMediaRecorder();
        File outFile = new File(OUTPUT_FILE);

        if(outFile.exists())
            outFile.delete();

        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        recorder.setOutputFile("/mnt/sdcard/sample.mp4");
        //recorder.setAudioSamplingRate(16000);
        recorder.prepare();
        recorder.start();
    }

    public void stopRecording()  {

        try{
            recorder.stop();
        }catch(RuntimeException stopException){
            //handle cleanup here
        }
    }

    public void ditchMediaRecorder() {
        if(recorder != null)
            recorder.release();
    }

    public void playRecording() throws IOException {
        ditchMediaPlayer();
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setDataSource("/mnt/sdcard/sample.mp4");
        mediaPlayer.prepare();
        mediaPlayer.start();
    }

}
