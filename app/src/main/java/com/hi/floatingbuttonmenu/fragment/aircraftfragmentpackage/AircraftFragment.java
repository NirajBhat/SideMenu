package com.hi.floatingbuttonmenu.fragment.aircraftfragmentpackage;

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
import com.hi.floatingbuttonmenu.adapter.AircraftAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import yalantis.com.sidemenu.interfaces.ScreenShotable;

/*import com.hi.gpsmaps.adapter.AircraftAdapter;*/

/**
 * Created by hi on 21-06-2018.
 */

public class AircraftFragment extends Fragment implements ScreenShotable {
    int mIntPage;
    String mStringTitle;
    String [] aircraftListName ;
    ViewPager mViewPager;
    TabLayout mTabLayout;
    AircraftAdapter aircraftAdapter;
    ArrayList<String> aircraftItemList;


    /*public static AircraftFragment newInstanceAircraft(int page,String title){
        AircraftFragment fragment = new AircraftFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("page",page);
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIntPage = getArguments().getInt("page",0);
        mStringTitle = getArguments().getString("title");

    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.aircaft,container,false);
        mViewPager = view.findViewById(R.id.aircraftViewpager);
        mTabLayout = view.findViewById(R.id.aircrafttabLayout);
        aircraftListName = (getActivity().getResources().getStringArray(R.array.aircraftItems));
        ArrayList<String> mAircraftTitleList = new ArrayList<String>(Arrays.asList(aircraftListName));
        if (aircraftAdapter == null){
            aircraftAdapter = new AircraftAdapter(getActivity().getSupportFragmentManager(),mAircraftTitleList);
            mViewPager.setAdapter(aircraftAdapter);
        }
        else{
            aircraftAdapter.setData(mAircraftTitleList);
        }
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        aircraftAdapter.notifyDataSetChanged();
       // setAircraftAdapter();
        return view;
    }

    @Override
    public void takeScreenShot() {

    }

    @Override
    public Bitmap getBitmap() {
        return null;
    }
  /*  void setAircraftAdapter(){
        if (aircraftAdapter == null){
            aircraftAdapter = new AircraftAdapter(getActivity().getSupportFragmentManager(),aircraftItemList);
            mViewPager.setAdapter(aircraftAdapter);
        }
        else {
            aircraftAdapter.setData(aircraftItemList);
        }
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        aircraftAdapter.notifyDataSetChanged();
    }*/


}
