package com.hi.floatingbuttonmenu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hi.floatingbuttonmenu.fragment.aircraftfragmentpackage.DynamicAircraftFragment;
import com.hi.floatingbuttonmenu.fragment.aircraftfragmentpackage.DynamicAircraftFragmentSecond;
import com.hi.floatingbuttonmenu.interfacepackage.CallbackTabsInterface;


import java.util.ArrayList;

/**
 * Created by hi on 25-06-2018.
 */

public class AircraftAdapter extends FragmentPagerAdapter {
    ArrayList<String> mStringArrayList;
    private CallbackTabsInterface callbackAircraftInterface;
    public AircraftAdapter(FragmentManager fm, ArrayList<String> mArrayList) {
        super(fm);
        this.mStringArrayList = mArrayList;
        this.callbackAircraftInterface = callbackAircraftInterface;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return DynamicAircraftFragment.newInstanceAircraft(position,mStringArrayList.get(position));
            case 1:
                return DynamicAircraftFragmentSecond.newInstanceAircraftSecond(position,mStringArrayList.get(position));
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
