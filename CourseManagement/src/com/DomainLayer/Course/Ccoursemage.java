package com.DomainLayer.Course;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.DataLayer.CountManagementModule.deleteCount;
import com.DataLayer.CountManagementModule.userInfoAllClass;
import com.DataLayer.CourseMangementModule.addPeriod;
import com.DataLayer.CourseMangementModule.deletePeriod;
import com.DataLayer.CourseMangementModule.queryPeriod;
import com.DataLayer.Model.Period;
import com.DataLayer.Model.departmentmanager;
import com.DataLayer.Model.teacher;
import com.DomainLayer.Account.AccountInformation;
import com.DomainLayer.Account.Addaccount;
import com.DomainLayer.Account.AccountInformation.MessageItem;
import com.UIxml.ListViewCompat1;
import com.UIxml.SlideView;
import com.UIxml.SlideView.OnSlideListener;
import com.control.R;

public class Ccoursemage extends Activity implements OnItemClickListener,
		OnClickListener, OnSlideListener {

	private static final String TAG = "MainActivity";

	int iflag = 0;// 判断新学期列表中是否有内容

	private ListViewCompat1 mListView;
	SlideAdapter slideAdapter;
	private List<MessageItem> mMessageItems = new ArrayList<Ccoursemage.MessageItem>();

	private SlideView mLastSlideViewWithStatusOn;
	List<String> ListV = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.coursemanage);
		queryPeriod period = new queryPeriod();
		period.docomfirm();// 连接服务器，获取信息
		List<Period> periods = new ArrayList<Period>();
		ListView lv = (ListView) this.findViewById(R.id.listhis);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "该功能尚未上线！", 200).show();
			}
		});

		periods = period.getPeriors();
		// 解析数据，根据状态值flag判断对应控件
		for (Period period2 : periods) {
			if (period2.getFlag().equals("1")) {
				iflag = 1;
				mListView = (ListViewCompat1) this.findViewById(R.id.listnow);
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
				mListView = (ListViewCompat1) this.findViewById(R.id.listnow);
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
			if (period2.getFlag().equals("3") ) {
				iflag = 1;
				mListView = (ListViewCompat1) this.findViewById(R.id.listnow);
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
			if (period2.getFlag().equals("4")) {
				iflag = 1;
				mListView = (ListViewCompat1) this.findViewById(R.id.listnow);
				MessageItem item = new MessageItem();
				item.iconRes = R.drawable.semester_64;
				item.title = "新学期";
				item.msg = period2.getPeriodid();
				item.time = "系负责人审核中";
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

		// 添加新学期
		ImageButton addc = (ImageButton) this.findViewById(R.id.addcourse);
		addc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				AlertDialog.Builder builder = new AlertDialog.Builder(
						Ccoursemage.this);
				LayoutInflater factory = LayoutInflater.from(Ccoursemage.this);
				final View textEntryView = factory.inflate(R.layout.dialog,
						null);
				builder.setTitle("创建新学期");
				builder.setView(textEntryView);
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// 事件处理
								if (iflag == 1) {
									Toast.makeText(getApplicationContext(),
											"已存在新学期，请删除后重试！", 200).show();

								} else {
									EditText newper = (EditText) textEntryView
											.findViewById(R.id.etUserName);
									addPeriod addper = new addPeriod();
									addper.setPeriodid(newper.getText()
											.toString());
									addper.docomfirm();
									iflag = 1;
									mListView = (ListViewCompat1) findViewById(R.id.listnow);
									MessageItem item = new MessageItem();
									item.iconRes = R.drawable.semester_64;
									item.title = "新学期";
									item.msg = newper.getText().toString();
									item.time = "未开始";
									mMessageItems.add(item);
									slideAdapter = new SlideAdapter();
									mListView.setAdapter(slideAdapter);
									Toast.makeText(getApplicationContext(),
											"添加成功！", 200).show();
								}

							}

						});
				builder.setNegativeButton("取消",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

							}
						});
				builder.create().show();

			}
		});
		ImageButton back = (ImageButton) this.findViewById(R.id.back);
		// 返回上一级
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right); // 切换动画

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
				slideView = new SlideView(Ccoursemage.this);
				slideView.setContentView(itemView);

				holder = new ViewHolder(slideView);
				slideView.setOnSlideListener(Ccoursemage.this);
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
			holder.leftHolder.setOnClickListener(Ccoursemage.this);
			holder.rightHolder.setOnClickListener(Ccoursemage.this);
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
			leftHolder = (ViewGroup) view.findViewById(R.id.left_holder);
			rightHolder = (ViewGroup) view.findViewById(R.id.right_holder);
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
				if (mMessageItems.get(0).time.equals("未开始")) {
					Intent intent = new Intent(Ccoursemage.this,
							AddcsTable.class);
					intent.putExtra("per", mMessageItems.get(0).msg);
					startActivity(intent);
					finish();
					overridePendingTransition(R.anim.in_from_right,
							R.anim.out_to_left); // 切换动画

				} else if(mMessageItems.get(0).time.equals("进行中")){
					Toast.makeText(getApplicationContext(), "选课时间不能查看！", 200).show();

				}else {
					Intent intent = new Intent(Ccoursemage.this,
							Y_check.class);
					intent.putExtra("periodid", mMessageItems.get(0).msg);
					startActivity(intent);
					finish();
					overridePendingTransition(R.anim.in_from_right,
							R.anim.out_to_left); // 切换动画

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

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.left_holder) {
			Log.e(TAG, "onClick v=" + v);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("提示").setMessage("确定删除此条报课信息？")
					.setNegativeButton("取消", null);
			builder.setPositiveButton("删除",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							deletePeriod delete = new deletePeriod();
							delete.setPeriodid(mMessageItems.get(mListView
									.getPosition()).msg);
							if (delete.docomfirm().equals("y1")) {
								iflag = 0;
								mMessageItems.remove(mListView.getPosition());
								slideAdapter.notifyDataSetChanged();
								Toast.makeText(getApplicationContext(),
										"删除成功！", 200).show();
							} else {
								Toast.makeText(getApplicationContext(),
										"删除失败！", 200).show();
							}

						}
					});
			builder.show();
		} else if (v.getId() == R.id.right_holder) {
			Log.e(TAG, "onClick v=" + v);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("提示").setMessage("确定删除此条报课信息？")
					.setNegativeButton("取消", null);
			builder.setPositiveButton("删除",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							deletePeriod delete = new deletePeriod();
							delete.setPeriodid(mMessageItems.get(mListView
									.getPosition()).msg);
							if (delete.docomfirm().equals("y1")) {
								iflag = 0;
								mMessageItems.remove(mListView.getPosition());
								slideAdapter.notifyDataSetChanged();
								Toast.makeText(getApplicationContext(),
										"删除成功！", 200).show();
							} else {
								Toast.makeText(getApplicationContext(),
										"删除失败！", 200).show();
							}
						}
					});
			builder.show();
		}
	}
}
