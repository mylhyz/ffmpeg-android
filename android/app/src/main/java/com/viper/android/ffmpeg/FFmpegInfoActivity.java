package com.viper.android.ffmpeg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by mylhyz on 2017/11/5.
 * <p>
 * show compiled ffmpeg library info
 */

public class FFmpegInfoActivity extends BaseActivity {
    private TextView tvShomInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ffmpeg_info);

        tvShomInfo = findViewById(R.id.tv_show_info);

        findViewById(R.id.supported_protocol).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo(getSupportedProtocol());
            }
        });

        findViewById(R.id.supported_format).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo(getSupportedFormat());
            }
        });

        findViewById(R.id.supported_codec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo(getSupportedCodec());
            }
        });

        findViewById(R.id.supported_filter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo(getSupportedFilter());
            }
        });

        findViewById(R.id.show_configure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder builder = new StringBuilder();
                for (String item : getConfigureInfo().split(" ")) {
                    builder.append(item).append('\n');
                }
                showInfo(builder.toString());
            }
        });
    }

    public static native String getConfigureInfo();

    public static native String getSupportedProtocol();

    public static native String getSupportedFormat();

    public static native String getSupportedCodec();

    public static native String getSupportedFilter();

    private void showInfo(String info) {
        tvShomInfo.setText(info);
    }

    @Override
    protected boolean isShowBackHome() {
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
