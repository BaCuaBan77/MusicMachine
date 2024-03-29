package com.example.longle.musicmachine;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button mDownloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DownloadThread thread = new DownloadThread();
        thread.setName("Download Thread");
        thread.start();

        mDownloadButton = findViewById(R.id.downloadButton);

        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Downloading", Toast.LENGTH_SHORT).show();

                //Send messages or runnable to Handler for processing
                for (String song : Playlist.songs) {
                    Message message = Message.obtain();
                    message.obj = song;
                    thread.mHandler.handleMessage(message);
                }


            }
        });
    }
}
