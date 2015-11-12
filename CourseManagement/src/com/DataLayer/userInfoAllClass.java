package com.DataLayer;
import java.util.ArrayList;
import java.util.List;

import com.DataLayer.Model.departmentmanager;
import com.DataLayer.Model.teacher;
import com.DataLayer.Runnable.userInfoAllThread;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONArray;

public class userInfoAllClass {
	private String flag;
	private String return_flag;
	private JSONArray return_arr;
	private List<teacher> tlist;//教师
    private List<departmentmanager> dlist;//系负责人
	


	public List<teacher> getTlist() {
		return tlist;
	}
	public void setTlist(List<teacher> tlist) {
		this.tlist = tlist;
	}

	public List<departmentmanager> getDlist() {
		return dlist;
	}
	public void setDlist(List<departmentmanager> dlist) {
		this.dlist = dlist;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getReturn_flag() {
		return return_flag;
	}
	public void setReturn_flag(String return_flag) {
		this.return_flag = return_flag;
	}
	public JSONArray getReturn_arr() {
		return return_arr;
	}
	public void setReturn_arr(JSONArray return_arr) {
		this.return_arr = return_arr;
	}
	public void doComfirm() {
		return_flag = null;
		return_arr = null;
		tlist=null;
		dlist=null;
		userInfoAllThread thread = new userInfoAllThread();
        thread.setFlag(flag);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return_flag = thread.getReturn_flag();
		return_arr = thread.getReturn_arr();
		Gson gson=new Gson();
		if(flag.equals("1")){
			 List<departmentmanager> retList=new ArrayList<departmentmanager>();   
			 retList = gson.fromJson(thread.getReturn_arr().toString(),
					   new TypeToken<List<departmentmanager>>() {}.getType()); 
			 dlist=retList;
		}
		else if(flag.equals("2")){
			 List<teacher> retList=new ArrayList<teacher>();   
			 retList = gson.fromJson(thread.getReturn_arr().toString(),
					   new TypeToken<List<teacher>>() {}.getType()); 
			tlist=retList;
		}
	
		
		 
		
	}
}
