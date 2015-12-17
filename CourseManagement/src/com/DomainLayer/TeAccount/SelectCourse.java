package com.DomainLayer.TeAccount;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.DUtils.CollapsableLinearLayout;
import com.DUtils.PromProductBean;
import com.DUtils.PromotionInfoBean;
import com.DUtils.userID;
import com.DataLayer.CourseMangementModule.queryCourseInfoForMajor;
import com.DataLayer.CourseMangementModule.selectCourses;
import com.DataLayer.Model.courseInfo;
import com.DataLayer.Model.selectCoursesInfo;
import com.control.R;

public class SelectCourse extends Activity implements OnCheckedChangeListener,
		OnClickListener {
	private ArrayList<PromotionInfoBean> promList = new ArrayList<PromotionInfoBean>();
	private List<CollapsableLinearLayout> collapsablelist = new ArrayList<CollapsableLinearLayout>();
	private LayoutInflater inflater;
	private int index = 0;
	private ImageButton button;
	private ImageButton back;
	private List<selectCoursesInfo> pros;
	private String perid;
	String user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.product_combo_info);
		pros = new ArrayList<selectCoursesInfo>();

		inflater = LayoutInflater.from(this);
		Intent intent = getIntent();
		perid = intent.getStringExtra("per");

		userID ID = (userID) getApplication();
		user = ID.getID();
		initData();
		showPromList();

		button = (ImageButton) this.findViewById(R.id.confirm);
		back = (ImageButton) this.findViewById(R.id.back);
		back.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				onBackPressed();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right); // 切换动画

			}
		});
		button.setOnClickListener(this);
	}

	private void initData() {
		PromotionInfoBean mPromotionInfoBean1 = new PromotionInfoBean();
		mPromotionInfoBean1.PromName = "计算机实验班";
		queryCourseInfoForMajor queyrCou = new queryCourseInfoForMajor();
		queyrCou.setMajor("0");
		queyrCou.setPeriodid(perid);
		queyrCou.docomfirm();
		List<courseInfo> lvcourseInfo = queyrCou.getCourseInfos();
		for (courseInfo courseInfo1 : lvcourseInfo) {
			PromProductBean mPromProductBean1 = new PromProductBean();
			mPromProductBean1.ProductName = courseInfo1.getCoursename();
			mPromProductBean1.courseid = courseInfo1.getCourseid();
			mPromProductBean1.coursegrade = courseInfo1.getCoursegrade();
			mPromProductBean1.coursemajor = courseInfo1.getCoursemajor();
			mPromProductBean1.coursepeople = courseInfo1.getCoursepeople();
			mPromProductBean1.coursescore = courseInfo1.getCoursescore();
			mPromProductBean1.coursehour = courseInfo1.getCoursehour();
			mPromProductBean1.practicehour = courseInfo1.getPracticehour();
			mPromProductBean1.type = courseInfo1.getType();
			mPromProductBean1.testhour = courseInfo1.getTesthour();
			mPromProductBean1.practicehour = courseInfo1.getPracticehour();
			mPromotionInfoBean1.PromProducts.add(mPromProductBean1);

		}
		PromotionInfoBean mPromotionInfoBean2 = new PromotionInfoBean();
		mPromotionInfoBean2.PromName = "计算机卓越班";
		queyrCou.setMajor("1");
		queyrCou.setPeriodid(perid);
		queyrCou.docomfirm();
		lvcourseInfo.clear();
		lvcourseInfo = queyrCou.getCourseInfos();
		for (courseInfo courseInfo1 : lvcourseInfo) {
			PromProductBean mPromProductBean2 = new PromProductBean();
			mPromProductBean2.ProductName = courseInfo1.getCoursename();
			mPromProductBean2.courseid = courseInfo1.getCourseid();
			mPromProductBean2.coursegrade = courseInfo1.getCoursegrade();
			mPromProductBean2.coursemajor = courseInfo1.getCoursemajor();
			mPromProductBean2.coursepeople = courseInfo1.getCoursepeople();
			mPromProductBean2.coursescore = courseInfo1.getCoursescore();
			mPromProductBean2.coursehour = courseInfo1.getCoursehour();
			mPromProductBean2.practicehour = courseInfo1.getPracticehour();
			mPromProductBean2.type = courseInfo1.getType();
			mPromProductBean2.testhour = courseInfo1.getTesthour();
			mPromProductBean2.practicehour = courseInfo1.getPracticehour();
			mPromotionInfoBean2.PromProducts.add(mPromProductBean2);

		}
		PromotionInfoBean mPromotionInfoBean3 = new PromotionInfoBean();
		mPromotionInfoBean3.PromName = "计算机";
		queyrCou.setMajor("2");
		queyrCou.setPeriodid(perid);
		queyrCou.docomfirm();
		lvcourseInfo.clear();
		lvcourseInfo = queyrCou.getCourseInfos();
		for (courseInfo courseInfo1 : lvcourseInfo) {
			PromProductBean mPromProductBean3 = new PromProductBean();
			mPromProductBean3.ProductName = courseInfo1.getCoursename();
			mPromProductBean3.courseid = courseInfo1.getCourseid();
			mPromProductBean3.coursegrade = courseInfo1.getCoursegrade();
			mPromProductBean3.coursemajor = courseInfo1.getCoursemajor();
			mPromProductBean3.coursepeople = courseInfo1.getCoursepeople();
			mPromProductBean3.coursescore = courseInfo1.getCoursescore();
			mPromProductBean3.coursehour = courseInfo1.getCoursehour();
			mPromProductBean3.practicehour = courseInfo1.getPracticehour();
			mPromProductBean3.type = courseInfo1.getType();
			mPromProductBean3.testhour = courseInfo1.getTesthour();
			mPromProductBean3.practicehour = courseInfo1.getPracticehour();
			mPromotionInfoBean3.PromProducts.add(mPromProductBean3);

		}
		PromotionInfoBean mPromotionInfoBean4 = new PromotionInfoBean();
		mPromotionInfoBean4.PromName = "软件工程";
		queyrCou.setMajor("3");
		queyrCou.setPeriodid(perid);
		queyrCou.docomfirm();
		lvcourseInfo.clear();
		lvcourseInfo = queyrCou.getCourseInfos();
		for (courseInfo courseInfo1 : lvcourseInfo) {
			PromProductBean mPromProductBean4 = new PromProductBean();
			mPromProductBean4.ProductName = courseInfo1.getCoursename();
			mPromProductBean4.courseid = courseInfo1.getCourseid();
			mPromProductBean4.coursegrade = courseInfo1.getCoursegrade();
			mPromProductBean4.coursemajor = courseInfo1.getCoursemajor();
			mPromProductBean4.coursepeople = courseInfo1.getCoursepeople();
			mPromProductBean4.coursescore = courseInfo1.getCoursescore();
			mPromProductBean4.coursehour = courseInfo1.getCoursehour();
			mPromProductBean4.practicehour = courseInfo1.getPracticehour();
			mPromProductBean4.type = courseInfo1.getType();
			mPromProductBean4.testhour = courseInfo1.getTesthour();
			mPromProductBean4.practicehour = courseInfo1.getPracticehour();
			mPromotionInfoBean4.PromProducts.add(mPromProductBean4);

		}
		PromotionInfoBean mPromotionInfoBean5 = new PromotionInfoBean();
		mPromotionInfoBean5.PromName = "数学实验班";
		queyrCou.setMajor("4");
		queyrCou.setPeriodid(perid);
		queyrCou.docomfirm();
		lvcourseInfo.clear();
		lvcourseInfo = queyrCou.getCourseInfos();
		for (courseInfo courseInfo1 : lvcourseInfo) {
			PromProductBean mPromProductBean5 = new PromProductBean();
			mPromProductBean5.ProductName = courseInfo1.getCoursename();
			mPromProductBean5.courseid = courseInfo1.getCourseid();
			mPromProductBean5.coursegrade = courseInfo1.getCoursegrade();
			mPromProductBean5.coursemajor = courseInfo1.getCoursemajor();
			mPromProductBean5.coursepeople = courseInfo1.getCoursepeople();
			mPromProductBean5.coursescore = courseInfo1.getCoursescore();
			mPromProductBean5.coursehour = courseInfo1.getCoursehour();
			mPromProductBean5.practicehour = courseInfo1.getPracticehour();
			mPromProductBean5.type = courseInfo1.getType();
			mPromProductBean5.testhour = courseInfo1.getTesthour();
			mPromProductBean5.practicehour = courseInfo1.getPracticehour();
			mPromotionInfoBean5.PromProducts.add(mPromProductBean5);

		}
		PromotionInfoBean mPromotionInfoBean6 = new PromotionInfoBean();
		mPromotionInfoBean6.PromName = "数学类";
		queyrCou.setMajor("5");
		queyrCou.setPeriodid(perid);
		queyrCou.docomfirm();
		lvcourseInfo.clear();
		lvcourseInfo = queyrCou.getCourseInfos();
		for (courseInfo courseInfo1 : lvcourseInfo) {
			PromProductBean mPromProductBean6 = new PromProductBean();
			mPromProductBean6.ProductName = courseInfo1.getCoursename();
			mPromProductBean6.courseid = courseInfo1.getCourseid();
			mPromProductBean6.coursegrade = courseInfo1.getCoursegrade();
			mPromProductBean6.coursemajor = courseInfo1.getCoursemajor();
			mPromProductBean6.coursepeople = courseInfo1.getCoursepeople();
			mPromProductBean6.coursescore = courseInfo1.getCoursescore();
			mPromProductBean6.coursehour = courseInfo1.getCoursehour();
			mPromProductBean6.practicehour = courseInfo1.getPracticehour();
			mPromProductBean6.type = courseInfo1.getType();
			mPromProductBean6.testhour = courseInfo1.getTesthour();
			mPromProductBean6.practicehour = courseInfo1.getPracticehour();
			mPromotionInfoBean6.PromProducts.add(mPromProductBean6);

		}
		PromotionInfoBean mPromotionInfoBean7 = new PromotionInfoBean();
		mPromotionInfoBean7.PromName = "网络工程";
		queyrCou.setMajor("6");
		queyrCou.setPeriodid(perid);
		queyrCou.docomfirm();
		lvcourseInfo.clear();
		lvcourseInfo = queyrCou.getCourseInfos();
		for (courseInfo courseInfo1 : lvcourseInfo) {
			PromProductBean mPromProductBean7 = new PromProductBean();
			mPromProductBean7.ProductName = courseInfo1.getCoursename();
			mPromProductBean7.courseid = courseInfo1.getCourseid();
			mPromProductBean7.coursegrade = courseInfo1.getCoursegrade();
			mPromProductBean7.coursemajor = courseInfo1.getCoursemajor();
			mPromProductBean7.coursepeople = courseInfo1.getCoursepeople();
			mPromProductBean7.coursescore = courseInfo1.getCoursescore();
			mPromProductBean7.coursehour = courseInfo1.getCoursehour();
			mPromProductBean7.practicehour = courseInfo1.getPracticehour();
			mPromProductBean7.type = courseInfo1.getType();
			mPromProductBean7.testhour = courseInfo1.getTesthour();
			mPromProductBean7.practicehour = courseInfo1.getPracticehour();
			mPromotionInfoBean7.PromProducts.add(mPromProductBean7);

		}
		PromotionInfoBean mPromotionInfoBean8 = new PromotionInfoBean();
		mPromotionInfoBean8.PromName = "信息安全";
		queyrCou.setMajor("7");
		queyrCou.setPeriodid(perid);
		queyrCou.docomfirm();
		lvcourseInfo.clear();
		lvcourseInfo = queyrCou.getCourseInfos();
		for (courseInfo courseInfo1 : lvcourseInfo) {
			PromProductBean mPromProductBean8 = new PromProductBean();
			mPromProductBean8.ProductName = courseInfo1.getCoursename();
			mPromProductBean8.courseid = courseInfo1.getCourseid();
			mPromProductBean8.coursegrade = courseInfo1.getCoursegrade();
			mPromProductBean8.coursemajor = courseInfo1.getCoursemajor();
			mPromProductBean8.coursepeople = courseInfo1.getCoursepeople();
			mPromProductBean8.coursescore = courseInfo1.getCoursescore();
			mPromProductBean8.coursehour = courseInfo1.getCoursehour();
			mPromProductBean8.practicehour = courseInfo1.getPracticehour();
			mPromProductBean8.type = courseInfo1.getType();
			mPromProductBean8.testhour = courseInfo1.getTesthour();
			mPromProductBean8.practicehour = courseInfo1.getPracticehour();
			mPromotionInfoBean8.PromProducts.add(mPromProductBean8);

		}

		promList.add(mPromotionInfoBean1);
		promList.add(mPromotionInfoBean2);
		promList.add(mPromotionInfoBean3);
		promList.add(mPromotionInfoBean4);
		promList.add(mPromotionInfoBean5);
		promList.add(mPromotionInfoBean6);
		promList.add(mPromotionInfoBean7);
		promList.add(mPromotionInfoBean8);
	}

	private void showPromList() {
		List<View> comboViews = createContentViews(promList);
		LinearLayout comboInfoContainer = (LinearLayout) findViewById(R.id.combo_info_container_linear);
		for (View comboView : comboViews) {
			comboInfoContainer.addView(comboView);
			View dividerView = new View(this);
			dividerView.setBackgroundColor(Color.parseColor("#f8f8f8"));
			comboInfoContainer.addView(dividerView, new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));// Util.dp2px(this,
																			// 30)
		}
	}

	private List<View> createContentViews(List<PromotionInfoBean> promInfo) {
		List<View> contentViews = new ArrayList<View>();
		int realIndex = 0;
		if (promInfo != null && promInfo.size() != 0) {
			for (int i = 0; i < promInfo.size(); i++) {
				PromotionInfoBean prom = promInfo.get(i);
				if (prom.PromProducts != null) {
					if (prom.PromProducts.size() != 0) { // 不展示status为4
						View promInfoItem = createPromInfoItem(prom, realIndex);
						contentViews.add(promInfoItem);
						realIndex++;
					}
				}
			}
		}
		return contentViews;
	}

	private View createPromInfoItem(PromotionInfoBean promInfo, int indexs) {
		// @formatter:off
		final View comboItem = inflater.inflate(R.layout.product_combo, null);
		RelativeLayout combo_title_container = (RelativeLayout) comboItem
				.findViewById(R.id.combo_title_container);
		TextView nickNameView = (TextView) comboItem
				.findViewById(R.id.combo_nick_name_text);
		TextView comboNumText = (TextView) comboItem
				.findViewById(R.id.combo_num_text_01);
		final ImageView arrowImage = (ImageView) comboItem
				.findViewById(R.id.combo_arrow_image);
		final CollapsableLinearLayout childContainer = (CollapsableLinearLayout) comboItem
				.findViewById(R.id.combo_products_container);
		childContainer.setToggleView(arrowImage);
		// create child product views
		if (promInfo.PromProducts != null && promInfo.PromProducts.size() > 0) {
			for (PromProductBean childBean : promInfo.PromProducts) {
				View childView = createComboChildItem(childBean);
				childContainer.addView(childView);
			}
		}

		collapsablelist.add(childContainer);

		if (index == indexs)
			childContainer.expand();
		else
			childContainer.collapse();
		nickNameView.setText(promInfo.PromName);
		comboNumText.setText((indexs + 1) + "");
		combo_title_container.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				childContainer.toggle();
				// 收起其他的view
				for (int i = 0; i < collapsablelist.size(); i++) {
					if (!childContainer.equals(collapsablelist.get(i))) {
						if (collapsablelist.get(i).isExpanded()) {
							collapsablelist.get(i).collapseOther();
						}
					}
				}
			}
		});
		// @formatter:on
		return comboItem;
	}

	private View createComboChildItem(final PromProductBean childBean) {
		// @formatter:off
		View comboChildItem = inflater.inflate(R.layout.product_combo_child,
				null);
		LinearLayout product_linear = (LinearLayout) comboChildItem
				.findViewById(R.id.product_linear);
		TextView childNameView = (TextView) comboChildItem
				.findViewById(R.id.combo_product_name);

		childNameView.setText(childBean.ProductName);
		final CheckBox cb;
		cb = (CheckBox) comboChildItem.findViewById(R.id.selectCourse);
		final TextView shzx = (TextView) comboChildItem
				.findViewById(R.id.shzhouxu);
		final TextView shbz = (TextView) comboChildItem
				.findViewById(R.id.shbeizhu);
		selectCoursesInfo setcourse = new selectCoursesInfo();
		setcourse.setCourseid(childBean.courseid);
		cb.setTag(setcourse);
		cb.setOnCheckedChangeListener(this);
		product_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						SelectCourse.this);
				LayoutInflater factory = LayoutInflater.from(SelectCourse.this);
				final View textEntryView = factory.inflate(
						R.layout.selectcourse_addmsg, null);
				builder.setTitle("课程详情");
				builder.setView(textEntryView);
				TextView nianji = (TextView) textEntryView
						.findViewById(R.id.nianji);
				TextView zhuanye = (TextView) textEntryView
						.findViewById(R.id.zhuanye);
				TextView renshu = (TextView) textEntryView
						.findViewById(R.id.renshu);
				TextView mingchen = (TextView) textEntryView
						.findViewById(R.id.mingchen);
				TextView leixing = (TextView) textEntryView
						.findViewById(R.id.leixing);
				TextView xuefen = (TextView) textEntryView
						.findViewById(R.id.xuefen);
				TextView xueshi = (TextView) textEntryView
						.findViewById(R.id.xueshi);
				TextView shiyan = (TextView) textEntryView
						.findViewById(R.id.shiyan);
				TextView shangji = (TextView) textEntryView
						.findViewById(R.id.shangji);
				final EditText beizhu = (EditText) textEntryView
						.findViewById(R.id.beizhu);
				final NumberPicker begintime = (NumberPicker) textEntryView
						.findViewById(R.id.beginpicker);
				final NumberPicker closetime = (NumberPicker) textEntryView
						.findViewById(R.id.closepicker);
				begintime.setMaxValue(20);
				closetime.setMaxValue(20);
				begintime.setMinValue(1);
				closetime.setMinValue(1);
				nianji.setText("年级：" + childBean.coursegrade);
				zhuanye.setText("专业：" + childBean.coursemajor);
				renshu.setText("专业人数：" + childBean.coursepeople);
				mingchen.setText("课程名称：" + childBean.ProductName);
				leixing.setText("选修类型：" + childBean.type);
				xuefen.setText("学分：" + childBean.coursescore);
				xueshi.setText("学时：" + childBean.coursehour);
				shiyan.setText("实验学时：" + childBean.practicehour);
				shangji.setText("上机学时：" + childBean.testhour);
				beizhu.setText(childBean.Beizhu);
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// 事件处理
								if (begintime.getValue() < closetime.getValue()) {
									childBean.Zhouxu = String.valueOf(begintime
											.getValue())
											+ "—"
											+ String.valueOf(closetime
													.getValue());
									childBean.Beizhu = beizhu.getText()
											.toString();
									cb.setChecked(false);
									selectCoursesInfo setcourse1 = new selectCoursesInfo();
									setcourse1.setCourseid(childBean.courseid);
									setcourse1.setMessage(childBean.Beizhu);
									setcourse1.setTime(childBean.Zhouxu);
									cb.setTag(setcourse1);
									shzx.setText(childBean.Zhouxu + "周");
									shbz.setText(childBean.Beizhu);
								} else {
									Toast.makeText(getApplicationContext(),
											"起讫周序设置有误，请重新设置！", 200).show();

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
		return comboChildItem;
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		selectCoursesInfo tem = (selectCoursesInfo) arg0.getTag();
		if (arg1 == true) {

			pros.add(tem);
		} else {
			pros.remove((selectCoursesInfo) arg0.getTag());
		}

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		AlertDialog.Builder shBuilder = new AlertDialog.Builder(this);
		shBuilder.setTitle("提示")
				.setItems(new String[] { "确认提交选课吗？（提交后不能修改！）" }, null)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// 事件处理
						String str = new String();
						selectCourses selectcourse = new selectCourses();
						selectcourse.setPeriodid(perid);
						selectcourse.setUser_name(user);
						selectcourse.setSelectCoursesInfos(pros);
						str = selectcourse.doComfirm();
						if (str.equals("y1")) {
							Toast.makeText(getApplicationContext(), "预选成功！",
									200).show();
						} else {
							Toast.makeText(getApplicationContext(), "提交失败！",
									200).show();
						}

					}

				});
		shBuilder.setNegativeButton("取消",null);
		shBuilder.create().show();
	}

}
