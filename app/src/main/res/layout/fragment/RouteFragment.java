package com.hi.gpsmaps.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hi.gpsmaps.R;

import java.util.ArrayList;

/**
 * Created by hi on 22-06-2018.
 */

public class RouteFragment extends Fragment {
    ArrayList<Long> routeData = new ArrayList<>();
    ListView mListView;
    Context mContext;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.route,container,false);
        mContext = getActivity();

        String[] mRouteData = {"BENGALURU - MUMBAI","BENGALURU - DELHI","DELHI - AMRAVATI","BENGALURU - TIRUVANATAPURAM"
                             ,"AMRAVATI - HYDERABAD","BANGALURU - CHENAI","DELHI - CHENAI","MUMBAI - DELHI","MUMBAI - CHENAI",
                "HYDERABAD - BENGALURU","HYDERABAD - CHENAI","DELHI - HYDERABAD","HYDERABAD - GOA","GOA - BENGALURU","DELHI - GOA"
                    ,"HYDERABAD - KOCHI","HYDERABAD - MUMBAI"};

        ArrayAdapter adapter = new ArrayAdapter<String>(mContext,R.layout.route_data_list,mRouteData);
        mListView = view.findViewById(R.id.route_list);
        mListView.setAdapter(adapter);
        return view;

    }
}

