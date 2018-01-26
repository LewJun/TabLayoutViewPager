package com.example.tablayoutviewpager;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by LewJun on 2018/01/17.
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int mSpace;
    private int mSpanCount;

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) < mSpanCount) {
            outRect.top = mSpace * 2;
        } else {
            outRect.top = mSpace;
        }
        outRect.left = mSpace;
        outRect.right = mSpace;
        outRect.bottom = mSpace;
    }

    public SpaceItemDecoration(int space, int spanCount) {
        mSpace = space;
        mSpanCount = spanCount;
    }
}
