package com.DataLayer.CourseMangementModule;

import java.io.FilenameFilter;

import com.DataLayer.Runnable.uploadExcel;

/**
 * @parameter *
 */
public class doUpload {
	private String filename;
	private String uploadfile;
	private String peroidid;
	private String major;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(String uploadfile) {
		this.uploadfile = uploadfile;
	}

	public String getPeroidid() {
		return peroidid;
	}

	public void setPeroidid(String peroidid) {
		this.peroidid = peroidid;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void docomfirm() {
		uploadExcel uploadExcel = new uploadExcel();
		uploadExcel.setFileName(filename);
		uploadExcel.setUploadFile(uploadfile);
		uploadExcel.setMajor(major);
		uploadExcel.setPeroidid(peroidid);
		uploadExcel.start();
		try {
			uploadExcel.join();
			System.out.println("ok");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
