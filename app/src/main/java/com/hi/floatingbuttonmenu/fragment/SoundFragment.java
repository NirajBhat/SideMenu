package com.hi.floatingbuttonmenu.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hi.floatingbuttonmenu.R;

import yalantis.com.sidemenu.interfaces.ScreenShotable;

/**
 * Created by hi on 22-06-2018.
 */

public class SoundFragment  extends Fragment implements ScreenShotable {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sound,container,false);
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

