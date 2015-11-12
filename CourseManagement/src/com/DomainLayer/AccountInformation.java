package com.DomainLayer;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.UIxml.ListViewCompat;
import com.UIxml.SlideView;
import com.UIxml.SlideView.OnSlideListener;
import com.control.R;

public class AccountInformation extends Activity implements OnItemClickListener, OnClickListener,
        OnSlideListener {

    private static final String TAG = "MainActivity";

    private ListViewCompat mListView;
    SlideAdapter slideAdapter;
    private List<MessageItem> mMessageItems = new ArrayList<AccountInformation.MessageItem>();

    private SlideView mLastSlideViewWithStatusOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_information);
        initView();
        Button Add;
        Add=(Button) findViewById(R.id.add);
        Add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(AccountInformation.this, Addaccount.class);
				startActivity(intent);
				overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left); //切换动画
				
			}
        });

    }

    private void initView() {
        mListView = (ListViewCompat) findViewById(R.id.list);

        for (int i = 0; i < 10; i++) {
            MessageItem item = new MessageItem();
            if (i % 3 == 0) {
                item.iconRes = R.drawable.default_qq_avatar;
                item.title = "系负责人";
                item.msg = "点击查看详细信息";
                item.time = "18:18";
            } else {
                item.iconRes = R.drawable.wechat_icon;
                item.title = "教师";
                item.msg = "点击查看详细信息";
                item.time = "11月12日";
            }
            mMessageItems.add(item);
        }
        
//        footer = LayoutInflater.from(this).inflate(R.layout.footer, null);
//        mListView.addFooterView(footer);
        slideAdapter = new SlideAdapter();
        mListView.setAdapter(slideAdapter);
        mListView.setOnItemClickListener(this);
    }

    private class SlideAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        SlideAdapter() {
            super();
            mInflater = getLayoutInflater();
        }

        @Override
        public int getCount() {
            return mMessageItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mMessageItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            SlideView slideView = (SlideView) convertView;
            if (slideView == null) {
                View itemView = mInflater.inflate(R.layout.list_item, null);

                slideView = new SlideView(AccountInformation.this);
                slideView.setContentView(itemView);

                holder = new ViewHolder(slideView);
                slideView.setOnSlideListener(AccountInformation.this);
                slideView.setTag(holder);
            } else {
                holder = (ViewHolder) slideView.getTag();
            }
            MessageItem item = mMessageItems.get(position);
            item.slideView = slideView;
            item.slideView.reset();
            holder.icon.setImageResource(item.iconRes);
            holder.title.setText(item.title);
            holder.msg.setText(item.msg);
            holder.time.setText(item.time);
            holder.leftHolder.setOnClickListener(AccountInformation.this);
            holder.rightHolder.setOnClickListener(AccountInformation.this);
            return slideView;
        }

    }

    public class MessageItem {
        public int iconRes;
        public String title;
        public String msg;
        public String time;
        public SlideView slideView;
    }

    private static class ViewHolder {
        public ImageView icon;
        public TextView title;
        public TextView msg;
        public TextView time;
        public ViewGroup leftHolder;
        public ViewGroup rightHolder;

        ViewHolder(View view) {
            icon = (ImageView) view.findViewById(R.id.icon);
            title = (TextView) view.findViewById(R.id.title);
            msg = (TextView) view.findViewById(R.id.msg);
            time = (TextView) view.findViewById(R.id.time);
            leftHolder = (ViewGroup)view.findViewById(R.id.left_holder);
            rightHolder = (ViewGroup)view.findViewById(R.id.right_holder);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
        Log.e(TAG, "onItemClick position=" + position);
        SlideView slideView =  mMessageItems.get(position).slideView;
        if(slideView.ismIsMoveClick()){//如果是滑动中触发的点击事件，不做处理
        	return;
        }
        if (slideView.close() && slideView.getScrollX() == 0) {
			if (mLastSlideViewWithStatusOn == null || mLastSlideViewWithStatusOn.getScrollX() == 0) {
				//此处添加item的点击事件
				Toast.makeText(this, "onItemClick position=" + position, 100).show();
			}
		}
    }

    @Override
    public void onSlide(View view, int status) {
        if (mLastSlideViewWithStatusOn != null && mLastSlideViewWithStatusOn != view) {
            mLastSlideViewWithStatusOn.shrink();
        }

        if (status == SLIDE_STATUS_ON) {
            mLastSlideViewWithStatusOn = (SlideView) view;
        }
    }

    @Override
    public void onClick(View v) {
    	if (v.getId() == R.id.left_holder) {
            Log.e(TAG, "onClick v=" + v);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("提示").setMessage("确定删此条目？")  
					.setNegativeButton("取消", null);
			builder.setPositiveButton("删除", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					mMessageItems.remove(mListView.getPosition());
					slideAdapter.notifyDataSetChanged();
				}
			});
			builder.show();
        }else if (v.getId() == R.id.right_holder) {
            Log.e(TAG, "onClick v=" + v);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("提示").setMessage("确定删此条目？")  
					.setNegativeButton("取消", null);
			builder.setPositiveButton("删除", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					mMessageItems.remove(mListView.getPosition());
					slideAdapter.notifyDataSetChanged();
				}
			});
			builder.show();
        }
    }
}
