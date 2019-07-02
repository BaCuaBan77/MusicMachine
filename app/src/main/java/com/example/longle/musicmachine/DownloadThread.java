package com.example.longle.musicmachine;

import android.os.Looper;
import android.util.Log;

public class DownloadThread extends Thread{
    private static final String TAG = "DownloadThread" ;
    public DownloadHandler mHandler;
    @Override
    public void run() {
        Looper.prepare();
        mHandler = new DownloadHandler();
        Looper.loop();
    }

}
