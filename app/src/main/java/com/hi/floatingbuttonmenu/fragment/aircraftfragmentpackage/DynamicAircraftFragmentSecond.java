package com.hi.floatingbuttonmenu.fragment.aircraftfragmentpackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hi.floatingbuttonmenu.R;

/**
 * Created by hi on 16-07-2018.
 */

public class DynamicAircraftFragmentSecond extends Fragment {
    int mIntPage;
    String mStringTitle;
    int mTabPosition;


    public static DynamicAircraftFragmentSecond newInstanceAircraftSecond(int page, String title){
        DynamicAircraftFragmentSecond fragment = new DynamicAircraftFragmentSecond();
        Bundle bundle = new Bundle();
        bundle.putInt("int",page);
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIntPage = getArguments().getInt("int",0);
        mStringTitle = getArguments().getString("title");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dynamicaircraftfragmentsecond, container, false);
        Log.d("TAG", "onCreateView:switch " +mTabPosition);
        return view;
    }

}
