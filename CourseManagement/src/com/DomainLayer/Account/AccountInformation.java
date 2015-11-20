package com.DomainLayer.Account;

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
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.DataLayer.CountManagementModule.deleteCount;
import com.DataLayer.CountManagementModule.userInfoAllClass;
import com.DataLayer.Model.departmentmanager;
import com.DataLayer.Model.teacher;
import com.UIxml.ListViewCompat;
import com.UIxml.SlideView;
import com.UIxml.SlideView.OnSlideListener;
import com.control.R;

public class AccountInformation extends Activity implements
		OnItemClickListener, OnClickListener, OnSlideListener {

	private static final String TAG = "MainActivity";

	private ListViewCompat mListView;
	SlideAdapter slideAdapter;
	private List<MessageItem> mMessageItems = new ArrayList<AccountInformation.MessageItem>();

	private SlideView mLastSlideViewWithStatusOn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.account_information);
		initView();
		ImageButton Add;
		ImageButton fanh;
		Add = (ImageButton) this.findViewById(R.id.add_person);
		fanh = (ImageButton) this.findViewById(R.id.back);
		Add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(AccountInformation.this, Addaccount.class);
				startActivity(intent);
				finish();
				overridePendingTransition(R.anim.in_from_right,
						R.anim.out_to_left); // �л�����

			}
		});
		fanh.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				onBackPressed();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right); // �л�����
				

			}
		});

	}

	private void initView() {
		mListView = (ListViewCompat) this.findViewById(R.id.list);
		userInfoAllClass userIf = new userInfoAllClass();
		userIf.setFlag("1");
		userIf.doComfirm();
		List<departmentmanager> departmentmanagers = userIf.getDlist();

		for (departmentmanager Item : departmentmanagers) {

			MessageItem item = new MessageItem();
			item.iconRes = R.drawable.default_qq_avatar;
			item.title = "ϵ������";
			item.msg = Item.getUser_name();
			item.password = Item.getPassword();
			item.department = Item.getDepartment();
			mMessageItems.add(item);

		}

		userIf.setFlag("2");
		userIf.doComfirm();

		List<teacher> teachers = userIf.getTlist();

		for (teacher Item : teachers) {

			MessageItem item = new MessageItem();
			item.iconRes = R.drawable.default_qq_avatar;
			item.title = "��ʦ";
			item.msg = Item.getUser_name();
			item.name = Item.getName();
			item.password = Item.getPassword();
			item.email = Item.getEmail();
			item.telephone = Item.getTelephone();
			item.sex = Item.getSex();
			item.birthday = Item.getBirthday();
			item.department = Item.getDepartment();
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
		public String user_name;
		public String password;
		public String name;
		public String email;
		public String telephone;
		public String sex;
		public String birthday;
		public String department;
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
		Log.e(TAG, "onItemClick position=" + position);
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
				if (item.title.equals("��ʦ")) {
					
					Intent intent = new Intent();
					intent.setClass(AccountInformation.this, Teacher.class);
					intent.putExtra("username", item.msg);
					intent.putExtra("password", item.password);
					intent.putExtra("name", item.name);
					intent.putExtra("department", item.department);
					intent.putExtra("email", item.email);
					intent.putExtra("telephone", item.telephone);
					intent.putExtra("sex", item.sex);
					intent.putExtra("birth", item.birthday);
					startActivity(intent);
					overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left); //�л�����

//					new AlertDialog.Builder(this)
//							.setTitle("��ϸ��Ϣ")
//							.setItems(
//									new String[] { "���ţ�" + item.msg,
//											"���룺" + item.password,
//											"������" + item.name, "�Ա�" + item.sex,
//											"���գ�" + item.birthday,
//											"���䣺" + item.email,
//											"�ֻ��ţ�" + item.telephone, 
//											"ϵ:"+item.department}, null)
//							.setNegativeButton("ȷ��", null).show();

				} else {
					Intent intent = new Intent();
					intent.setClass(AccountInformation.this, Xmanage.class);
					intent.putExtra("username", item.msg);
					intent.putExtra("password", item.password);
					intent.putExtra("department", item.department);
					startActivity(intent);
					overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left); //�л�����

//					new AlertDialog.Builder(this)
//							.setTitle("��ϸ��Ϣ")
//							.setItems(
//									new String[] { "�û�����" + item.msg,
//											"���룺" + item.password,
//											"����ϵ��" + item.department }, null)
//							.setNegativeButton("ȷ��", null).show();

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
			builder.setTitle("��ʾ").setMessage("ȷ��ɾ��������Ϣ��")
					.setNegativeButton("ȡ��", null);
			builder.setPositiveButton("ɾ��",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							deleteCount delete = new deleteCount();
							String tstr;
							if (mMessageItems.get(mListView.getPosition()).title
									.equals("��ʦ")) {

								delete.setFlag("2");
								delete.setUser_name(mMessageItems.get(mListView
										.getPosition()).msg);
								tstr = delete.doComfirm();
							} else {
								delete.setFlag("1");
								delete.setUser_name(mMessageItems.get(mListView
										.getPosition()).msg);
								tstr = delete.doComfirm();
							}
							if (tstr.equals("y2") || tstr.equals("y3")) {

								Toast.makeText(getApplicationContext(),
										"ɾ���ɹ���", 200).show();

							} else if (tstr.equals("n4")) {
								Toast.makeText(getApplicationContext(),
										"�û������ڣ�", 200).show();
							}
							mMessageItems.remove(mListView.getPosition());
							slideAdapter.notifyDataSetChanged();
						}
					});
			builder.show();
		} else if (v.getId() == R.id.right_holder) {
			Log.e(TAG, "onClick v=" + v);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("��ʾ").setMessage("ȷ��ɾ��������Ϣ��")
					.setNegativeButton("ȡ��", null);
			builder.setPositiveButton("ɾ��",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							deleteCount delete = new deleteCount();
							String tstr;
							if (mMessageItems.get(mListView.getPosition()).title
									.equals("��ʦ")) {

								delete.setFlag("2");
								delete.setUser_name(mMessageItems.get(mListView
										.getPosition()).msg);
								tstr = delete.doComfirm();
							} else {
								delete.setFlag("1");
								delete.setUser_name(mMessageItems.get(mListView
										.getPosition()).msg);
								tstr = delete.doComfirm();
							}
							if (tstr.equals("y2") || tstr.equals("y3")) {

								Toast.makeText(getApplicationContext(),
										"ɾ���ɹ���", 200).show();

							} else if (tstr.equals("n4")) {
								Toast.makeText(getApplicationContext(),
										"�û������ڣ�", 200).show();
							}
							mMessageItems.remove(mListView.getPosition());
							slideAdapter.notifyDataSetChanged();
						}
					});
			builder.show();
		}
	}
}
