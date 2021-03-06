package com.DomainLayer.TeAccount;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.DUtils.CheckNet;
import com.DataLayer.CourseMangementModule.deletePeriod;
import com.DataLayer.CourseMangementModule.queryPeriod;
import com.DataLayer.Model.Period;
import com.DomainLayer.Course.AddcsTable;
import com.UIxml.ListViewCompat2;
import com.UIxml.SlideView;
import com.UIxml.SlideView.OnSlideListener;
import com.control.R;

public class TeMainManage extends Activity implements OnItemClickListener,
		OnSlideListener {

	// userID userid = (userID) getApplication();
	// String aString =userid.getID();
	private static final String TAG = "TeMainManage";

	int iflag = 0;// 判断新学期列表中是否有内容

	private ListViewCompat2 mListView;
	SlideAdapter slideAdapter;
	private List<MessageItem> mMessageItems = new ArrayList<TeMainManage.MessageItem>();

	private SlideView mLastSlideViewWithStatusOn;
	List<String> ListV = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.te_main);
		
		ListView lv = (ListView) this.findViewById(R.id.te_listhis);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "该功能尚未上线！", 200).show();
			}
		});
		
		queryPeriod period = new queryPeriod();
		period.docomfirm();// 连接服务器，获取信息
		List<Period> periods = new ArrayList<Period>();
		periods = period.getPeriors();
		// 解析数据，根据状态值flag判断对应控件
		for (Period period2 : periods) {

			if (period2.getFlag().equals("1")) {
				iflag = 1;
				mListView = (ListViewCompat2) this
						.findViewById(R.id.te_listnow);
				MessageItem item = new MessageItem();
				item.iconRes = R.drawable.semester_64;
				item.title = "新学期";
				item.msg = period2.getPeriodid();
				item.time = "未开始";
				mMessageItems.add(item);
				slideAdapter = new SlideAdapter();
				mListView.setAdapter(slideAdapter);
				mListView.setOnItemClickListener(this);
			}
			if (period2.getFlag().equals("2")) {
				iflag = 1;
				mListView = (ListViewCompat2) this
						.findViewById(R.id.te_listnow);
				MessageItem item = new MessageItem();
				item.iconRes = R.drawable.semester_64;
				item.title = "新学期";
				item.msg = period2.getPeriodid();
				item.time = "即将开始";
				mMessageItems.add(item);
				slideAdapter = new SlideAdapter();
				mListView.setAdapter(slideAdapter);
				mListView.setOnItemClickListener(this);

			}

			if (period2.getFlag().equals("3") || period2.getFlag().equals("4")) {
				iflag = 1;
				mListView = (ListViewCompat2) this
						.findViewById(R.id.te_listnow);
				MessageItem item = new MessageItem();
				item.iconRes = R.drawable.semester_64;
				item.title = "新学期";
				item.msg = period2.getPeriodid();
				item.time = "进行中";
				mMessageItems.add(item);
				slideAdapter = new SlideAdapter();
				mListView.setAdapter(slideAdapter);
				mListView.setOnItemClickListener(this);

			}
			if (period2.getFlag().equals("5")) {
				
				String str = period2.getPeriodid();
				ListV.add(str);
				lv.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1, ListV));
			}

		}

		ImageButton back = (ImageButton) this.findViewById(R.id.te_back);
		ImageButton inforButton = (ImageButton) findViewById(R.id.te_information);

		// 返回上一级
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right); // 切换动画

			}
		});
		// 跳转个人信息界面
		inforButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 检查是否联网
				CheckNet checkNet = new CheckNet(
						getApplicationContext(),
						(ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE));

				if (checkNet.checknet()) {
					Intent intent = new Intent();
					intent.setClass(TeMainManage.this, TePersonMsg.class);
					startActivity(intent);
					overridePendingTransition(R.anim.in_from_right,
							R.anim.out_to_left); // 切换动画
				}

			}
		});

	}

	public class SlideAdapter extends BaseAdapter {

		private LayoutInflater mInflater;

		public SlideAdapter() {
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
				slideView = new SlideView(TeMainManage.this);
				slideView.setContentView(itemView);

				holder = new ViewHolder(slideView);
				slideView.setOnSlideListener(TeMainManage.this);
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

		ViewHolder(View view) {
			icon = (ImageView) view.findViewById(R.id.icon);
			title = (TextView) view.findViewById(R.id.title);
			msg = (TextView) view.findViewById(R.id.msg);
			time = (TextView) view.findViewById(R.id.time);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		SlideView slideView = mMessageItems.get(position).slideView;
		if (slideView.ismIsMoveClick()) {// 如果是滑动中触发的点击事件，不做处理
			return;
		}
		if (slideView.close() && slideView.getScrollX() == 0) {
			if (mLastSlideViewWithStatusOn == null
					|| mLastSlideViewWithStatusOn.getScrollX() == 0) {
				MessageItem item = (MessageItem) parent
						.getItemAtPosition(position);
				// 此处添加item的点击事件

				 if (mMessageItems.get(0).time.equals("进行中")) {
				 Intent intent = new Intent(TeMainManage.this,
				 SelectCourse.class);
				 intent.putExtra("per", mMessageItems.get(0).msg);
				 startActivity(intent);
				 overridePendingTransition(R.anim.in_from_right,
				 R.anim.out_to_left); // 切换动画
				 }
				 else{
					 Toast.makeText(getApplicationContext(), "当前不是选课时间!", 200).show();
				 }
				

			}
		}
	}

	@Override
	public void onSlide(View view, int status) {
		if (mLastSlideViewWithStatusOn != null
				&& mLastSlideViewWithStatusOn != view) {
			mLastSlideViewWithStatusOn.shrink();
		}

		if (status == SLIDE_STATUS_ON) {
			mLastSlideViewWithStatusOn = (SlideView) view;
		}
	}

}
