package com.hi.floatingbuttonmenu.fragment.trackfragmentpackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hi.floatingbuttonmenu.R;

import com.hi.floatingbuttonmenu.adapter.TrackAdapter;

/**
 * Created by hi on 13-07-2018.
 */

public class DynamicTrackFragmentSecond extends Fragment {
    int mIntPage;
    String mStringTitle;
    int mTabPosition;
    TrackAdapter mTrackAdapter;

    public static DynamicTrackFragmentSecond newInstanceTrackSecond(int page, String title){
        DynamicTrackFragmentSecond fragment = new DynamicTrackFragmentSecond();
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
        View view = inflater.inflate(R.layout.dynamictrackfragmentsecond, container, false);
        Log.d("TAG", "onCreateView:switch " +mTabPosition);
        return view;
    }


}
