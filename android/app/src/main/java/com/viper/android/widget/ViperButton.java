package com.viper.android.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by mylhyz on 2017/11/5.
 * custom button
 */

public class ViperButton extends AppCompatButton {

    public ViperButton(Context context) {
        super(context);
        disableAllCaps();
    }

    public ViperButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        disableAllCaps();
    }

    public ViperButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        disableAllCaps();
    }

    private void disableAllCaps() {
        setAllCaps(false);
    }
}
