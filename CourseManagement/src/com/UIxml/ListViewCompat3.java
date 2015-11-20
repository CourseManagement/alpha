package com.UIxml;

import com.UIxml.SlideView;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class ListViewCompat3 extends ListView {

    private static final String TAG = "ListViewCompat3";

    private SlideView mFocusedItemView;

    private int position;
    
    public ListViewCompat3(Context context) {
        super(context);
    }

    public ListViewCompat3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewCompat3(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void shrinkListItem(int position) {
        View item = getChildAt(position);

        if (item != null) {
            try {
                ((SlideView) item).shrink();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
    }


    public int getPosition() {
		return position;
	}
}
