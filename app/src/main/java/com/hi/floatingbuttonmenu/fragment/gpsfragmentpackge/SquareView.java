package com.hi.floatingbuttonmenu.fragment.gpsfragmentpackge;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hi on 09-07-2018.
 */

public class SquareView  extends View {
    private float mRelativeSize = 1;

    public SquareView(Context context) {
        super(context);
    }

    public SquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mSize = (int) (Math.min(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec)) * mRelativeSize);
        setMeasuredDimension(mSize, mSize);
    }

    public void setRelativeSize(float size) {
        mRelativeSize = size;
        invalidate();
    }
}

