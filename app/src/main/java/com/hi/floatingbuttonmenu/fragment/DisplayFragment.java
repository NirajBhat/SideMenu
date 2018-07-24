package com.hi.floatingbuttonmenu.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.hi.floatingbuttonmenu.R;

import yalantis.com.sidemenu.interfaces.ScreenShotable;

/**
 * Created by hi on 22-06-2018.
 */

public class DisplayFragment extends Fragment implements ScreenShotable {
    private static final String SCREEN_BRIGHTNESS_VALUE_PREFIX = "Bacllight Intensity - ";
    TextView mScreenBrightnessValueTextView;
    SeekBar mBrigthnessSeekBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.display,container,false);
        mScreenBrightnessValueTextView = view.findViewById(R.id.change_screen_brightness_value_text_view);
        mBrigthnessSeekBar = view.findViewById(R.id.change_screen_brightness_seekbar);
        mBrigthnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Context mContext = getActivity();
                boolean mWriteValue = Settings.System.canWrite(mContext);
                if(mWriteValue){
                    // Because max screen brightness value is 255
                    // But max seekbar value is 100, so need to convert.
                    int screenBrightnessValue = progress*255/100;
                    // Set seekbar adjust screen brightness value in the text view.
                    mScreenBrightnessValueTextView.setText(SCREEN_BRIGHTNESS_VALUE_PREFIX + screenBrightnessValue);
                    // Change the screen brightness change mode to manual.
                    Settings.System.putInt(mContext.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS_MODE,Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
                    // Apply the screen brightness value to the system, this will change the value in Settings ---> Display ---> Brightness level.
                    Settings.System.putInt(mContext.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, screenBrightnessValue);
                }else {
                    // Show Can modify system settings panel to let user add WRITE_SETTINGS permission for this app.
                    Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                    mContext.startActivity(intent);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //Getting Current screen brightness.
        int mCurrentScreenBrightness = Settings.System.getInt(getContext().getContentResolver(),Settings.System.SCREEN_BRIGHTNESS,0);
        // Set current screen brightness value in the text view.
        mScreenBrightnessValueTextView.setText(SCREEN_BRIGHTNESS_VALUE_PREFIX + mCurrentScreenBrightness);
        // Set current screen brightness value to seekbar progress.
        mBrigthnessSeekBar.setProgress(mCurrentScreenBrightness);
        return view;
    }

    @Override
    public void takeScreenShot() {

    }

    @Override
    public Bitmap getBitmap() {
        return null;
    }
}

