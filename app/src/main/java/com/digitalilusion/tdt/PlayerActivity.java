package com.digitalilusion.tdt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayerActivity extends AppCompatActivity {

    private String url;
    private String label;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        videoView = (VideoView) findViewById(R.id.videoView);
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        if (extras.getString(Constants.LABEL) != null && extras.getString(Constants.URL) != null) {
            url = extras.getString(Constants.URL);
            label = extras.getString(Constants.LABEL);

            play(label, url);
        }


    }

    private void play(String label, String url) {

        setTitle(label);
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
                Toast.makeText(PlayerActivity.this, "Error: " + what + " - extra: " + extra, Toast.LENGTH_LONG).show();
                return false;
            }
        });
        //MediaController mc = new MediaController(this);
        videoView.setVideoURI(Uri.parse(url));
        //videoView.setMediaController(mc);
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {


                mediaPlayer.start();
            }
        });
        //videoView.start();

    }


}
