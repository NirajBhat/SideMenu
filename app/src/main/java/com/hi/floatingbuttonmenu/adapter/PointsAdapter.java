package com.hi.floatingbuttonmenu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hi.floatingbuttonmenu.fragment.pointfragmentpackage.DynamicPointsFragment;
import com.hi.floatingbuttonmenu.fragment.pointfragmentpackage.DynamicPointsFragmentSecond;

import java.util.ArrayList;

/**
 * Created by hi on 13-07-2018.
 */

public class PointsAdapter extends FragmentPagerAdapter {
    ArrayList<String> mStringArrayList;

    public PointsAdapter(FragmentManager fm, ArrayList<String> mArrayList) {
        super(fm);
        this.mStringArrayList = mArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
           DynamicPointsFragment.newInstancePoints(position, mStringArrayList.get(position));
            case 1:
                DynamicPointsFragmentSecond.newInstancePointSecond(position,mStringArrayList.get(position));
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
