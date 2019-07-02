package com.example.longle.musicmachine;

import android.os.Message;
import android.util.Log;

import java.util.logging.LogRecord;

public class DownloadHandler extends android.os.Handler {
    private static final String TAG = "DownloadHandler" ;

    @Override
    public void handleMessage(Message msg) {
        downloadSong(msg.obj.toString());
    }
    private void downloadSong(String song) {
        long endTime = System.currentTimeMillis() +10*1000;
        while(System.currentTimeMillis() < endTime){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "Downloading Music " + song);
    }
}
