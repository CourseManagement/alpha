package com.DataLayer.Model;

/**
 * @parameter *
 * 
 * 学期实体类
 * periodid学期编号
 * flag学期状态标识
 * 学期状态：
 * 1：新建学期，未导入课表或者选课开始/截至时间
 * 2：选课公布，但未开始选课
 * 3：选课进行中
 * 4：选课结束，系负责人审核
 * 5：院负责人审核完毕（历史选课）
 * 
 * 
 */
public class Perior {
	private String periodid;
	private String flag;

	public String getPeriodid() {
		return periodid;
	}

	public void setPeriorid(String periodid) {
		this.periodid = periodid;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
