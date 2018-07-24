package com.hi.floatingbuttonmenu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.hi.floatingbuttonmenu.fragment.trackfragmentpackage.DynamicTrackFragment;
import com.hi.floatingbuttonmenu.fragment.trackfragmentpackage.DynamicTrackFragmentSecond;
import com.hi.floatingbuttonmenu.interfacepackage.CallbackTabsInterface;

import java.util.ArrayList;

/**
 * Created by hi on 13-07-2018.
 */

public class TrackAdapter extends FragmentPagerAdapter {
    ArrayList<String> mStringArrayList;
    CallbackTabsInterface mTabsInterface;

    public TrackAdapter(FragmentManager fm, ArrayList<String> mArrayList) {
        super(fm);
        this.mStringArrayList = mArrayList;
    }

    public TrackAdapter(FragmentManager fm, CallbackTabsInterface mTabsInterface) {
        super(fm);
        this.mTabsInterface = mTabsInterface;
    }

    @Override
    public Fragment getItem(int position) {
        //return DynamicTrackFragment.newInstanceTrackSecond(position,mStringArrayList.get(position));
        switch(position){
            case 0:
                DynamicTrackFragment.newInstanceTrack(position,mStringArrayList.get(position));
            case 1:
               DynamicTrackFragmentSecond.newInstanceTrackSecond(position,mStringArrayList.get(position));
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mStringArrayList.size();
    }
    public void setData(ArrayList<String> data){
        this.mStringArrayList = data;
        notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        mStringArrayList.size();
        return mStringArrayList.get(position);
    }
}
