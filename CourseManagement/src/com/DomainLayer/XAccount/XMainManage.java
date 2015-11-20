package com.DomainLayer.XAccount;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
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
import com.DUtils.CheckNet;
import com.DataLayer.CourseMangementModule.queryPeriod;
import com.DataLayer.Model.Period;
import com.UIxml.ListViewCompat3;
import com.UIxml.SlideView;
import com.UIxml.SlideView.OnSlideListener;
import com.control.R;

public class XMainManage extends Activity implements OnItemClickListener,
		OnSlideListener {

	// userID userid = (userID) getApplication();
	// String aString =userid.getID();
	private static final String TAG = "XMainManage";

	int iflag = 0;// �ж���ѧ���б����Ƿ�������

	private ListViewCompat3 mListView;
	SlideAdapter slideAdapter;
	private List<MessageItem> mMessageItems = new ArrayList<XMainManage.MessageItem>();

	private SlideView mLastSlideViewWithStatusOn;
	List<String> ListV = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.x_main);
		queryPeriod period = new queryPeriod();
		period.docomfirm();// ���ӷ���������ȡ��Ϣ
		List<Period> periods = new ArrayList<Period>();
		periods = period.getPeriors();
		// �������ݣ�����״ֵ̬flag�ж϶�Ӧ�ؼ�
		for (Period period2 : periods) {

			if (period2.getFlag().equals("1")) {
				iflag = 1;
				mListView = (ListViewCompat3) this
						.findViewById(R.id.x_listnow);
				MessageItem item = new MessageItem();
				item.iconRes = R.drawable.default_qq_avatar;
				item.title = "��ѧ��";
				item.msg = period2.getPeriodid();
				item.time = "δ��ʼ";
				mMessageItems.add(item);
				slideAdapter = new SlideAdapter();
				mListView.setAdapter(slideAdapter);
				mListView.setOnItemClickListener(this);
			}
			if (period2.getFlag().equals("2")) {
				iflag = 1;
				mListView = (ListViewCompat3) this
						.findViewById(R.id.x_listnow);
				MessageItem item = new MessageItem();
				item.iconRes = R.drawable.default_qq_avatar;
				item.title = "��ѧ��";
				item.msg = period2.getPeriodid();
				item.time = "������ʼ";
				mMessageItems.add(item);
				slideAdapter = new SlideAdapter();
				mListView.setAdapter(slideAdapter);
				mListView.setOnItemClickListener(this);

			}

			if (period2.getFlag().equals("3") || period2.getFlag().equals("4")) {
				iflag = 1;
				mListView = (ListViewCompat3) this
						.findViewById(R.id.x_listnow);
				MessageItem item = new MessageItem();
				item.iconRes = R.drawable.default_qq_avatar;
				item.title = "��ѧ��";
				item.msg = period2.getPeriodid();
				item.time = "������";
				mMessageItems.add(item);
				slideAdapter = new SlideAdapter();
				mListView.setAdapter(slideAdapter);
				mListView.setOnItemClickListener(this);

			}
			if (period2.getFlag().equals("5")) {
				ListView lv = (ListView) this.findViewById(R.id.x_listhis);
				String str = period2.getPeriodid();
				ListV.add(str);
				lv.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1, ListV));
			}

		}

		ImageButton back = (ImageButton) this.findViewById(R.id.x_back);
		ImageButton inforButton = (ImageButton) findViewById(R.id.x_information);

		// ������һ��
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right); // �л�����

			}
		});
		// ��ת������Ϣ����
		inforButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// ����Ƿ�����
				CheckNet checkNet = new CheckNet(
						getApplicationContext(),
						(ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE));

				if (checkNet.checknet()) {
					Intent intent = new Intent();
					intent.setClass(XMainManage.this, XPersonMsg.class);
					startActivity(intent);
					overridePendingTransition(R.anim.in_from_right,
							R.anim.out_to_left); // �л�����
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
				slideView = new SlideView(XMainManage.this);
				slideView.setContentView(itemView);

				holder = new ViewHolder(slideView);
				slideView.setOnSlideListener(XMainManage.this);
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
		if (slideView.ismIsMoveClick()) {// ����ǻ����д����ĵ���¼�����������
			return;
		}
		if (slideView.close() && slideView.getScrollX() == 0) {
			if (mLastSlideViewWithStatusOn == null
					|| mLastSlideViewWithStatusOn.getScrollX() == 0) {
				MessageItem item = (MessageItem) parent
						.getItemAtPosition(position);
				// �˴����item�ĵ���¼�

				// if (mMessageItems.get(0).time.equals("δ��ʼ")) {
				// Intent intent = new Intent(TeMainManage.this,
				// AddcsTable.class);
				// intent.putExtra("per", mMessageItems.get(0).msg);
				// startActivity(intent);
				// overridePendingTransition(R.anim.in_from_right,
				// R.anim.out_to_left); // �л�����
				//
				// } else {
				//
				// }

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
