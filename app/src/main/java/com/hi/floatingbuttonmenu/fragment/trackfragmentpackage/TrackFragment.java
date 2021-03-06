package com.hi.floatingbuttonmenu.fragment.trackfragmentpackage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hi.floatingbuttonmenu.R;
import com.hi.floatingbuttonmenu.adapter.TrackAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import yalantis.com.sidemenu.interfaces.ScreenShotable;

/**
 * Created by hi on 22-06-2018.
 */

public class TrackFragment extends Fragment implements ScreenShotable{
    String[] mtrackItemList;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    TrackAdapter mTrackAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.track,container,false);
        mTabLayout = view.findViewById(R.id.tracktabLayout);
        mViewPager = view.findViewById(R.id.trackViewpager);
        mtrackItemList = (getActivity().getResources().getStringArray(R.array.trackItems));
        ArrayList<String> mStrings = new ArrayList<String>(Arrays.asList(mtrackItemList));
        if(mTrackAdapter == null){
            mTrackAdapter = new TrackAdapter(getActivity().getSupportFragmentManager(),mStrings);
            mViewPager.setAdapter(mTrackAdapter);
        }else {
            mTrackAdapter.setData(mStrings);
        }
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.GRAVITY_FILL);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTrackAdapter.notifyDataSetChanged();
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

