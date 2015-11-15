package com.DataLayer.Model;

/**
 * @parameter *
 *
 *            coursename, courseid, coursegrade, coursemajor, coursepeople,
 *            coursescore, coursehour, testhour, practicehour time message
 *            selectid type
 *            查询个人选课情况，并返回课程信息
 *            
 */
public class selectCoursesDetailInfo {

	private String coursename;
	private String courseid;
	private String coursegrade;
	private String coursemajor;
	private String coursepeople;
	private String coursescore;
	private String coursehour;
	private String testhour;
	private String practicehour;
	private String time;
	private String message;
	private String selectid;
	private String type;
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursegrade() {
		return coursegrade;
	}
	public void setCoursegrade(String coursegrade) {
		this.coursegrade = coursegrade;
	}
	public String getCoursemajor() {
		return coursemajor;
	}
	public void setCoursemajor(String coursemajor) {
		this.coursemajor = coursemajor;
	}
	public String getCoursepeople() {
		return coursepeople;
	}
	public void setCoursepeople(String coursepeople) {
		this.coursepeople = coursepeople;
	}
	public String getCoursescore() {
		return coursescore;
	}
	public void setCoursescore(String coursescore) {
		this.coursescore = coursescore;
	}
	public String getCoursehour() {
		return coursehour;
	}
	public void setCoursehour(String coursehour) {
		this.coursehour = coursehour;
	}
	public String getTesthour() {
		return testhour;
	}
	public void setTesthour(String testhour) {
		this.testhour = testhour;
	}
	public String getPracticehour() {
		return practicehour;
	}
	public void setPracticehour(String practicehour) {
		this.practicehour = practicehour;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSelectid() {
		return selectid;
	}
	public void setSelectid(String selectid) {
		this.selectid = selectid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "selectCoursesDetailInfo [coursename=" + coursename
				+ ", courseid=" + courseid + ", coursegrade=" + coursegrade
				+ ", coursemajor=" + coursemajor + ", coursepeople="
				+ coursepeople + ", coursescore=" + coursescore
				+ ", coursehour=" + coursehour + ", testhour=" + testhour
				+ ", practicehour=" + practicehour + ", time=" + time
				+ ", message=" + message + ", selectid=" + selectid + ", type="
				+ type + "]";
	}
	
	
	

}
