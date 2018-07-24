package com.hi.floatingbuttonmenu.fragment.pointfragmentpackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hi.floatingbuttonmenu.R;


/**
 * Created by hi on 13-07-2018.
 */

public class DynamicPointsFragment extends Fragment {

    int mIntPage;
    String mStringTitle;
    Button mButton;

    public static DynamicPointsFragment newInstancePoints(int page, String title){
        DynamicPointsFragment fragment = new DynamicPointsFragment();
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
        View view = inflater.inflate(R.layout.dynamicpointsitemfragment,container,false);
        mButton = view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}
