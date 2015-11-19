package com.DomainLayer.TeAccount;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.DUtils.CollapsableLinearLayout;
import com.DUtils.PromProductBean;
import com.DUtils.PromotionInfoBean;
import com.DataLayer.CourseMangementModule.queryCourseInfoForMajor;
import com.DataLayer.Model.courseInfo;
import com.control.R;

	public class SelectCourse extends Activity implements OnCheckedChangeListener,OnClickListener{
		private ArrayList<PromotionInfoBean> promList = new ArrayList<PromotionInfoBean>();
		private List<CollapsableLinearLayout> collapsablelist = new ArrayList<CollapsableLinearLayout>();
		private LayoutInflater inflater;
		private int index = 0;
		private Button button;
		private List<PromProductBean> pros;
		private String perid;
		

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.product_combo_info);
			pros = new ArrayList<PromProductBean>();

			inflater = LayoutInflater.from(this);
			Intent intent = getIntent();
			perid = intent.getStringExtra("per");

			initData();
			showPromList();
			
			button = (Button) this.findViewById(R.id.bt11);
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
			CheckBox cb;
			cb = (CheckBox) comboChildItem.findViewById(R.id.selectCourse);
			cb.setTag(childBean);
			cb.setOnCheckedChangeListener(this);
			product_linear.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Log.e(SelectCourse.class.getName(), "点击商品");
				}
			});
			return comboChildItem;
		}

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			// TODO Auto-generated method stub
			if (arg1 == true) {
				pros.add((PromProductBean) arg0.getTag());
			} else {
				pros.remove((PromProductBean) arg0.getTag());
			}

			
		}

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			for(PromProductBean productBean : pros){
				System.out.println(productBean.ProductName);
			}
			
		}

	}
	


