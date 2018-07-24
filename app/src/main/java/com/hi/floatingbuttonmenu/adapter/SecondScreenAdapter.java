package com.hi.floatingbuttonmenu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hi.floatingbuttonmenu.R;
import com.hi.floatingbuttonmenu.interfacepackage.LinkRecyclertoFrameLayoutInterface;


/**
 * Created by hi on 19-06-2018.
 */

public  class SecondScreenAdapter extends RecyclerView.Adapter<SecondScreenAdapter.MyViewHolder> {
   private LinkRecyclertoFrameLayoutInterface anInterface;
    Context mContext;
    public SecondScreenAdapter(LinkRecyclertoFrameLayoutInterface anInterface, Context mContext) {
        this.anInterface = anInterface;
        this.mContext = mContext;
    }

    private static final String TAG = "SecondScreenAdapter";
    String[] image_name = {"GPS","Flights","Route","Points","Track","Aircraft","E6B","Alaram","Celestial","Message",
                           "Display","Sound","Setup"};
       int[] mImages = {R.drawable.gps, R.drawable.flights,R.drawable.routes,R.drawable.point,R.drawable.track,
               R.drawable.aircraft,R.mipmap.ic_launcher,R.drawable.alarm,R.mipmap.ic_launcher,R.drawable.message,
               R.drawable.display,R.drawable.sound,R.drawable.setup} ;
    // ArrayList<String> imageArrayList = new ArrayList<String>(Arrays.<String>asList(String.valueOf(mImages)));
     /* String[] image_name = (mContext.getResources().getStringArray(R.array.side_image_names));
      */

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.secondscreenlayoutforsideviewitems,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SecondScreenAdapter.MyViewHolder holder, final int position) {
        holder.mTextView.setText(image_name[position]);
        Log.d(TAG, "onBindViewHolder: " + mImages);
        Log.d(TAG, "onBindViewHolder: " + image_name);
        holder.mImageButton.setImageResource(mImages[position]);
       /* holder.mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Position " +position, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onClick: "+mImages[position]);
                anInterface.DataPosition(position);
            }
        })*/;

        // holder.mImageButton.setImageResource(Integer.parseInt(imageArrayList.get(position)));
       /* holder.mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // onClick(view);
                Fragment fragment = null;
                FragmentManager fragmentManager = ((AppCompatActivity)mContext).getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                //this is your frame layout id
                transaction.replace(R.id.frameLayoutForSideItemClick,fragment );
                transaction.addToBackStack(null);
                //transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();
                Bundle bundle = new Bundle();
                bundle.putInt("position",mImages[position]);
                anInterface.DataPosition(position);
               *//* Intent intent = new Intent(mContext,ThirdWorkingActivity.class);
                mContext.startActivity(intent);
                intent.putExtra("positiodata",bundle);*//*
                Log.d(TAG, "onClick: "+mImages[position]);

                switch (position){
                    case 0:
                        fragment = new AircraftFragment();
                        break;
                    case 1:
                        fragment = new GPSFragment();
                        break;
                }

            }
        });




*/
    }



    @Override
    public int getItemCount() {
        return image_name.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        ImageButton mImageButton;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.sideTextRecylerview);
            mImageButton = itemView.findViewById(R.id.sideImageRecyclerview);
           // mImageButton.setOnClickListener(this);
        }
/*
        @Override
        public void onClick(View view) {
             int positionOfButton = getAdapterPosition();
            mImageButton.setImageResource(positionOfButton);
            Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();
        }*/
    }

}
