package com.viper.android.ffmpeg;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_show_ffmpeg_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartActivity.start(MainActivity.this, FFmpegInfoActivity.class);
            }
        });
    }
}
