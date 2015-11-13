package com.DataLayer.CourseMangementModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.DataLayer.Model.courseInfo;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @parameter *
 *
 *            从excel中读取信息，并插入服务器数据库中
 *
 */
public class getInfoFromExcelAboutCourses extends Thread {

	private String path;
	private String major;
	private List<courseInfo> lists;
	private String periodid;
	private String result;

	public String getPeriodid() {
		return periodid;
	}

	public void setPeriodid(String periodid) {
		this.periodid = periodid;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		InputStream is;
		try {
			// readexcel
			is = new FileInputStream(path);
			Workbook book = Workbook.getWorkbook(is);
			Sheet sheet = book.getSheet(0);
			int Rows = sheet.getRows();
			int Cols = sheet.getColumns();
			System.out.println("rows：" + String.valueOf(Rows) + " cols："
					+ String.valueOf(Cols));
			lists = new ArrayList<courseInfo>();
			for (int i = 3; i < Rows; i++) {
				// teacher temTeacher = new teacher();
				courseInfo temcourseInfo = new courseInfo();
				temcourseInfo.setCoursegrade(sheet.getCell(0, i).getContents()
						.toString());
				temcourseInfo.setCoursemajor(sheet.getCell(1, i).getContents()
						.toString());
				temcourseInfo.setCoursepeople(sheet.getCell(2, i).getContents()
						.toString());
				temcourseInfo.setCoursename(sheet.getCell(3, i).getContents()
						.toString());
				String type = sheet.getCell(4, i).getContents().toString();
				temcourseInfo.setType(type.replaceAll(
						String.valueOf((char) 160), ""));
				temcourseInfo.setCoursescore(sheet.getCell(5, i).getContents()
						.toString());
				temcourseInfo.setCoursehour(sheet.getCell(6, i).getContents()
						.toString());
				temcourseInfo.setPracticehour(sheet.getCell(7, i).getContents()
						.toString());
				temcourseInfo.setTesthour(sheet.getCell(8, i).getContents()
						.toString());
				lists.add(temcourseInfo);
				// System.out.println(temcourseInfo.toString());
			}
			book.close();

			// post
			addCourses addCourses = new addCourses();
			addCourses.setCourseInfos(lists);
			addCourses.setMajor(major);
			addCourses.setPeriodid(periodid);
			result = addCourses.doComfirm();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
