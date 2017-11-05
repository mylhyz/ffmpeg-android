package com.viper.android.ffmpeg;

import android.app.Application;

/**
 * Created by mylhyz on 2017/11/5.
 * <p>
 * global application context
 */

public class FFmpegApp extends Application {
    static {
        System.loadLibrary("avcodec-57");
        System.loadLibrary("avdevice-57");
        System.loadLibrary("avfilter-6");
        System.loadLibrary("avformat-57");
        System.loadLibrary("avutil-55");
        System.loadLibrary("postproc-54");
        System.loadLibrary("swresample-2");
        System.loadLibrary("swscale-4");
        System.loadLibrary("native-lib");
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
