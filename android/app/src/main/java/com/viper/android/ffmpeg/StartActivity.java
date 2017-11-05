package com.viper.android.ffmpeg;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by mylhyz on 2017/11/5.
 * utils for start activity
 */

public class StartActivity {

    public static void start(Activity activity, Class<?> clazz) {
        Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);
    }
}
