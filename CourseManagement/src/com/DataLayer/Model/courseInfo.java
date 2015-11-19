package com.DataLayer.Model;

/**
 * @parameter *
 *
 *            ¿Î³ÌÐÅÏ¢
 *
 */
public class courseInfo {

	private String coursename;
	private String courseid;
	private String coursegrade;
	private String coursemajor;
	private String coursepeople;
	private String coursescore;
	private String coursehour;
	private String testhour;
	private String practicehour;
	private String type;
	private String col;
	private String nums;

	@Override
	public String toString() {
		return "courseInfo [coursename=" + coursename + ", courseid="
				+ courseid + ", coursegrade=" + coursegrade + ", coursemajor="
				+ coursemajor + ", coursepeople=" + coursepeople
				+ ", coursescore=" + coursescore + ", coursehour=" + coursehour
				+ ", testhour=" + testhour + ", practicehour=" + practicehour
				+ ", type=" + type + ", col=" + col + ", nums=" + nums + "]";
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public String getNums() {
		return nums;
	}

	public void setNums(String nums) {
		this.nums = nums;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

}
