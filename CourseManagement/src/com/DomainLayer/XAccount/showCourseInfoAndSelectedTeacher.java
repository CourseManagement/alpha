package com.DomainLayer.XAccount;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.DataLayer.CourseMangementModule.queryTeacherByCourse;
import com.DataLayer.Model.teacher;
import com.DataLayer.Model.teacherAndSelectInfo;
import com.UIxml.ListViewCompat4;
import com.UIxml.SlideView;
import com.UIxml.SlideView.OnSlideListener;
import com.control.R;

/**
 * @parameter *
 */
public class showCourseInfoAndSelectedTeacher extends Activity implements
OnItemClickListener, OnClickListener, OnSlideListener{
	private ListViewCompat4 mListView;
	SlideAdapter slideAdapter;
	private List<MessageItem> mMessageItems = new ArrayList<showCourseInfoAndSelectedTeacher.MessageItem>();

	private SlideView mLastSlideViewWithStatusOn;

	private Intent intent;

	private TextView grade;
	private TextView num;
	private TextView mark;
	private TextView type;
	private TextView stime;
	private TextView sjtime;
	private TextView ptime;
	private String Coursegrade;
	private String Coursehour;
	private String Courseid;
	private String Coursemajor;
	private String Coursename;
	private String Coursepeople;
	private String Coursescore;
	private String Practicehour;
	private String Testhour;
	private String Nums;
	private String Type;
	private String Periodid;

	private ImageButton add;
	private ImageButton back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.course_check_detail);
		
		intent = this.getIntent();
		init();
		initView();
		

	}

	void init() {
		add = (ImageButton) this.findViewById(R.id.addcourse);
		back = (ImageButton) this.findViewById(R.id.back);

		grade = (TextView) this.findViewById(R.id.grade);
		num = (TextView) this.findViewById(R.id.num);
		mark = (TextView) this.findViewById(R.id.mark);
		type = (TextView) this.findViewById(R.id.type);
		stime = (TextView) this.findViewById(R.id.stime);
		sjtime = (TextView) this.findViewById(R.id.sjtime);
		ptime = (TextView) this.findViewById(R.id.ptime);

		Coursegrade = intent.getStringExtra("Coursegrade");
		Coursehour = intent.getStringExtra("Coursehour");
		Courseid = intent.getStringExtra("Courseid");
		Coursemajor = intent.getStringExtra("Coursemajor");
		Coursename = intent.getStringExtra("Coursename");
		Coursepeople = intent.getStringExtra("Coursepeople");
		Coursescore = intent.getStringExtra("Coursescore");
		Practicehour = intent.getStringExtra("Practicehour");
		Nums = intent.getStringExtra("Nums");
		Testhour = intent.getStringExtra("Testhour");
		Type = intent.getStringExtra("Type");
		Periodid = intent.getStringExtra("periodid");

		grade.setText(Coursegrade);
		num.setText(Coursepeople);
		mark.setText(Coursescore);
		type.setText(Type);
		stime.setText(Coursehour);
		sjtime.setText(Practicehour);
		ptime.setText(Testhour);
	}
	
	private void initView() {
		mListView = (ListViewCompat4) this.findViewById(R.id.list);
		queryTeacherByCourse teacherByCourse = new queryTeacherByCourse();
		System.out.println(Courseid+Periodid+"11111");
		teacherByCourse.setCourseid(Courseid);
		teacherByCourse.setPeriodid(Periodid);
		teacherByCourse.docomfirm();
		List<teacherAndSelectInfo> teacherAndSelectInfo1 = teacherByCourse.getTeachers();

		for (teacherAndSelectInfo Item : teacherAndSelectInfo1) {

			MessageItem item = new MessageItem();
			item.iconRes = R.drawable.t_64;
			item.title = Item.getName();
			item.msg = Item.getMessage();
			item.time = Item.getTime();
			mMessageItems.add(item);

		}


		slideAdapter = new SlideAdapter();
		mListView.setAdapter(slideAdapter);
		mListView.setOnItemClickListener(this);
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

				slideView = new SlideView(showCourseInfoAndSelectedTeacher.this);
				slideView.setContentView(itemView);

				holder = new ViewHolder(slideView);
				slideView.setOnSlideListener(showCourseInfoAndSelectedTeacher.this);
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
			holder.leftHolder.setOnClickListener(showCourseInfoAndSelectedTeacher.this);
			holder.rightHolder.setOnClickListener(showCourseInfoAndSelectedTeacher.this);
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
		if (slideView.ismIsMoveClick()) {// ����ǻ����д����ĵ���¼�����������
			return;
		}
		if (slideView.close() && slideView.getScrollX() == 0) {
			if (mLastSlideViewWithStatusOn == null
					|| mLastSlideViewWithStatusOn.getScrollX() == 0) {
				MessageItem item = (MessageItem) parent
						.getItemAtPosition(position);
				// �˴����item�ĵ���¼�
				
				
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
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("��ʾ").setMessage("ȷ��ɾ��������Ϣ��")
					.setNegativeButton("ȡ��", null);
			builder.setPositiveButton("ɾ��",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			builder.show();
		} else if (v.getId() == R.id.right_holder) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("��ʾ").setMessage("ȷ��ɾ��������Ϣ��")
					.setNegativeButton("ȡ��", null);
			builder.setPositiveButton("ɾ��",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							
						}
					});
			builder.show();
		}
	}

}
