package com.viper.android.ffmpeg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by mylhyz on 2017/11/5.
 * <p>
 * show compiled ffmpeg library info
 */

public class FFmpegInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ffmpeg_info);

        TextView tv = findViewById(R.id.tv_show_ffmpeg_info);
        String info = getConfigureInfo();
        if (info != null) {
            String[] items = info.split(" ");
            StringBuilder builder = new StringBuilder();
            for (String item : items) {
                builder.append(item).append("\n\n");
            }
            tv.setText(builder.toString());
        }
    }

    public static native String getConfigureInfo();

    @Override
    protected boolean isShowBackHome() {
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
