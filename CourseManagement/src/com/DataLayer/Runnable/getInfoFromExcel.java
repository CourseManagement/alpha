package com.DataLayer.Runnable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.DataLayer.CountManagementModule.addCounts;
import com.DataLayer.Model.teacher;

import android.R.string;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @parameter *
 */
public class getInfoFromExcel extends Thread {

	private String path;
	private List<teacher> lists;
	private String result;

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
			is = new FileInputStream(path);
			Workbook book = Workbook.getWorkbook(is);
			Sheet sheet = book.getSheet(0);
			int Rows = sheet.getRows();
			int Cols = sheet.getColumns();
			System.out.println("rows£º" + String.valueOf(Rows) + " cols£º"
					+ String.valueOf(Cols));
			lists = new ArrayList<teacher>();
			for (int i = 1; i < Rows; i++) {
				teacher temTeacher = new teacher();
				temTeacher.setUser_name(sheet.getCell(0, i).getContents()
						.toString());
				temTeacher.setPassword(sheet.getCell(1, i).getContents()
						.toString());
				temTeacher
						.setName(sheet.getCell(2, i).getContents().toString());
				lists.add(temTeacher);
			}
			book.close();
			addCounts addCounts = new addCounts();
			addCounts.setFlag("2");
			addCounts.setTeachers(lists);
			result = addCounts.doComfirm();

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
