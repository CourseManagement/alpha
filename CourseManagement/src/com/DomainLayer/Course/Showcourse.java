package com.DomainLayer.Course;

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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.DataLayer.CourseMangementModule.deleteTeacherByCourse;
import com.DataLayer.CourseMangementModule.queryTeacherByCourse;
import com.DataLayer.CourseMangementModule.selectCourses;
import com.DataLayer.Model.selectCoursesInfo;
import com.DataLayer.Model.teacherAndSelectInfo;
import com.UIxml.ListViewCompat5;
import com.UIxml.SlideView;
import com.UIxml.SlideView.OnSlideListener;
import com.control.R;

public class Showcourse extends Activity implements
OnItemClickListener, OnClickListener, OnSlideListener {
private ListViewCompat5 mListView;
SlideAdapter slideAdapter;
private List<MessageItem> mMessageItems = new ArrayList<Showcourse.MessageItem>();

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

List<selectCoursesInfo> selectCoursesInfo = new ArrayList<selectCoursesInfo>();
selectCoursesInfo select1;

@Override
protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
super.onCreate(savedInstanceState);
requestWindowFeature(Window.FEATURE_NO_TITLE);
setContentView(R.layout.y_test);

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

back.setOnClickListener(new OnClickListener() {

	@Override
	public void onClick(View v) {
		onBackPressed();
		overridePendingTransition(android.R.anim.slide_in_left,
				android.R.anim.slide_out_right); // �л�����

	}
});
add.setOnClickListener(new OnClickListener() {

	@Override
	public void onClick(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(
				Showcourse.this);
		LayoutInflater factory = LayoutInflater.from(Showcourse.this);
		final View textEntryView = factory.inflate(
				R.layout.dialog_for_addteacher, null);
		builder.setTitle("��ӽ�ʦ");
		builder.setView(textEntryView);
		final EditText username = (EditText) textEntryView
				.findViewById(R.id.edit_name);
		final EditText beizhu = (EditText) textEntryView
				.findViewById(R.id.edit_mark);
		final NumberPicker begintime = (NumberPicker) textEntryView
				.findViewById(R.id.beginpicker);
		final NumberPicker closetime = (NumberPicker) textEntryView
				.findViewById(R.id.endpicker);
		builder.setPositiveButton("ȷ��",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int whichButton) {
						// �¼�����
						if (begintime.getValue() < closetime.getValue()) {
							String zhouxu = String.valueOf(begintime
									.getValue())
									+ "��"
									+ String.valueOf(closetime
											.getValue());
							String bz = beizhu.getText()
									.toString();
							select1.setCourseid(Courseid);
							select1.setMessage(bz);
							select1.setTime(zhouxu);
							selectCoursesInfo.add(select1);
							selectCourses selectCourses = new selectCourses();
							selectCourses.setPeriodid(Periodid);
							selectCourses.setSelectCoursesInfos(selectCoursesInfo);
							selectCourses.setUser_name(username.getText().toString());
							selectCourses.doComfirm();
						} else {
							Toast.makeText(getApplicationContext(),
									"�������������������������ã�", 200).show();

						}
					}

				});
		builder.setNegativeButton("ȡ��",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int whichButton) {

					}
				});
		builder.create().show();

	}
	
});
}

private void initView() {
mListView = (ListViewCompat5) this.findViewById(R.id.list);
queryTeacherByCourse teacherByCourse = new queryTeacherByCourse();
teacherByCourse.setCourseid(Courseid);
teacherByCourse.setPeriodid(Periodid);
teacherByCourse.docomfirm();
List<teacherAndSelectInfo> teacherAndSelectInfo1 = teacherByCourse
		.getTeachers();

for (teacherAndSelectInfo Item : teacherAndSelectInfo1) {

	MessageItem item = new MessageItem();
	item.iconRes = R.drawable.t_64;
	item.title = Item.getName();
	item.msg = Item.getMessage();
	item.time = Item.getTime();
	item.username = Item.getUser_name();
	item.courseid = Courseid;
	item.periodid = Periodid;
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

		slideView = new SlideView(Showcourse.this);
		slideView.setContentView(itemView);

		holder = new ViewHolder(slideView);
		slideView
				.setOnSlideListener(Showcourse.this);
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
	holder.leftHolder
			.setOnClickListener(Showcourse.this);
	holder.rightHolder
			.setOnClickListener(Showcourse.this);
	return slideView;
}

}

public class MessageItem {
public int iconRes;
public String title;
public String msg;
public String time;
public String username;
public String courseid;
public String periodid;
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
					deleteTeacherByCourse delete = new deleteTeacherByCourse();
					delete.setCourseid(mMessageItems.get(mListView
							.getPosition()).courseid);
					delete.setPeriodid(mMessageItems.get(mListView
							.getPosition()).periodid);
					delete.setUser_name(mMessageItems.get(mListView
							.getPosition()).username);
					delete.docomfirm();
					Toast.makeText(getApplicationContext(), "ɾ���ɹ���",
							200).show();
					mMessageItems.remove(mListView.getPosition());
					slideAdapter.notifyDataSetChanged();

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
					deleteTeacherByCourse delete = new deleteTeacherByCourse();
					delete.setCourseid(mMessageItems.get(mListView
							.getPosition()).courseid);
					delete.setPeriodid(mMessageItems.get(mListView
							.getPosition()).periodid);
					delete.setUser_name(mMessageItems.get(mListView
							.getPosition()).username);
					delete.docomfirm();
					Toast.makeText(getApplicationContext(), "ɾ���ɹ���",
							200).show();
					mMessageItems.remove(mListView.getPosition());
					slideAdapter.notifyDataSetChanged();
				}
			});
	builder.show();
}
}

}

