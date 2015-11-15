package com.DataLayer.Runnable;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @parameter *
 */
public class uploadExcel extends Thread {
	private String fileName; // �����е��ļ�������
	private String uploadFile; // ���ϴ����ļ�·��
	private String peroidid;
	private String major;
	private String postUrl = "http://test.micromi.net/service/CourseManagement/uploadExcel.php"; // ����POST�����ҳ��

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
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

	/* �ϴ��ļ���Server�ķ��� */
	@Override
	public void run() {
		String end = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";
		try {
			URL url = new URL(postUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			/*
			 * Output to the connection. Default is false, set to true because
			 * post method must write something to the connection
			 */
			con.setDoOutput(true);
			/* Read from the connection. Default is true. */
			con.setDoInput(true);
			/* Post cannot use caches */
			con.setUseCaches(false);
			/* Set the post method. Default is GET */
			con.setRequestMethod("POST");
			/* ������������ */
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Charset", "UTF-8");
			con.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);

			/* ����DataOutputStream��getOutputStream��Ĭ�ϵ���connect() */
			DataOutputStream ds = new DataOutputStream(con.getOutputStream());
			// dos.writeBytes(twoHyphens + boundary + lineEnd);
			// dos.writeBytes("Content-Disposition: form-data; name=\"param1\""
			// + lineEnd);
			//
			// dos.writeBytes(param1);
			// dos.writeBytes(lineEnd);
			// // ����acrion
			// dos.writeBytes(twoHyphens + boundary + lineEnd);
			// dos.writeBytes("Content-Disposition: form-data; name=\"param2\""
			// + lineEnd);
			// dos.writeBytes(lineEnd);
			// dos.writeBytes(param2);
			// dos.writeBytes(lineEnd);
			// // �����ļ�
			// dos.writeBytes(twoHyphens + boundary + lineEnd);
			// dos.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\"; filename=\""
			// + fileName + "\"" + lineEnd);
			// dos.writeBytes(lineEnd);
			// periodid
			ds.writeBytes(twoHyphens + boundary + end);
			ds.writeBytes("Content-Disposition: form-data; name=\"periodid\""
					+ end);
			ds.writeBytes(end);
			ds.writeBytes(peroidid);
			ds.writeBytes(end);
			// major
			ds.writeBytes(twoHyphens + boundary + end);
			ds.writeBytes("Content-Disposition: form-data; name=\"major\""
					+ end);
			ds.writeBytes(end);
			ds.writeBytes(major);
			ds.writeBytes(end);

			ds.writeBytes(twoHyphens + boundary + end);
			System.out.println("fileName:" + fileName);
			ds.writeBytes("Content-Disposition: form-data; "
					+ "name=\"file\";filename=\"" + fileName + "\"" + end);
			ds.writeBytes(end);
			/* ȡ���ļ���FileInputStream */
			FileInputStream fStream = new FileInputStream(uploadFile);
			/* ����ÿ��д��8192bytes */
			int bufferSize = 8192;
			byte[] buffer = new byte[bufferSize]; // 8k
			int length = -1;
			/* ���ļ���ȡ������������ */
			while ((length = fStream.read(buffer)) != -1) {
				/* ������д��DataOutputStream�� */
				ds.write(buffer, 0, length);
			}
			ds.writeBytes(end);
			ds.writeBytes(twoHyphens + boundary + twoHyphens + end);
			/* �ر�����д��Ķ����Զ�����Http���� */
			fStream.close();
			/* �ر�DataOutputStream */
			ds.close();
			/* �ӷ��ص���������ȡ��Ӧ��Ϣ */
			InputStream is = con.getInputStream(); // input from the connection
													// ��ʽ����HTTP����
			int ch;
			StringBuffer b = new StringBuffer();
			while ((ch = is.read()) != -1) {
				b.append((char) ch);
			}
			System.out.println(b.toString());
		} catch (Exception e) {
			e.printStackTrace();
			/* ��ʾ�쳣��Ϣ */
		}
	}
}
