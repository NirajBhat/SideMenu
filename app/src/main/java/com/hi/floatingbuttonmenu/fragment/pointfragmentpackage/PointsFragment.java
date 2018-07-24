package com.hi.floatingbuttonmenu.fragment.pointfragmentpackage;

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
import com.hi.floatingbuttonmenu.adapter.PointsAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import yalantis.com.sidemenu.interfaces.ScreenShotable;

/**
 * Created by hi on 22-06-2018.
 */

public class PointsFragment extends Fragment implements ScreenShotable {
    String [] pointsListName ;
    ViewPager mViewPager;
    TabLayout mTabLayout;
    PointsAdapter mPointsAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.points,container,false);
        mViewPager = view.findViewById(R.id.pointsViewpager);
        mTabLayout =view.findViewById(R.id.ponitstabLayout);
        pointsListName = (getActivity().getResources().getStringArray(R.array.pointsItems));
        ArrayList<String> mStrings = new ArrayList<String>(Arrays.asList(pointsListName));
        if(mPointsAdapter == null){
            mPointsAdapter = new PointsAdapter(getActivity().getSupportFragmentManager(),mStrings);
            mViewPager.setAdapter(mPointsAdapter);
        }
        else {
            mPointsAdapter.setData(mStrings);
        }
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mPointsAdapter.notifyDataSetChanged();
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

