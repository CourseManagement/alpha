package com.UIxml;

import com.UIxml.SlideView;
import com.DomainLayer.TeAccount.TeMainManage.MessageItem;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

public class ListViewCompat2 extends ListView {

    private static final String TAG = "ListViewCompat2";

    private SlideView mFocusedItemView;

    private int position;
    
    public ListViewCompat2(Context context) {
        super(context);
    }

    public ListViewCompat2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewCompat2(Context context, AttributeSet attrs, int defStyle) {
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
