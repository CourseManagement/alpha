package com.DomainLayer.TeAccount;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.DataLayer.CourseMangementModule.queryCourseInfoForAll;
import com.DataLayer.Model.courseInfo;
import com.control.R;

public class SelectCourse extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.teacher);
	    queryCourseInfoForAll courseInfoForAll =new queryCourseInfoForAll();
	    courseInfoForAll.docomfirm();
	    List<courseInfo> list=new List<courseInfo>() {

			@Override
			public boolean add(courseInfo arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void add(int arg0, courseInfo arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean addAll(Collection<? extends courseInfo> arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(int arg0,
					Collection<? extends courseInfo> arg1) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean contains(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean containsAll(Collection<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public courseInfo get(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int indexOf(Object arg0) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator<courseInfo> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int lastIndexOf(Object arg0) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public ListIterator<courseInfo> listIterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ListIterator<courseInfo> listIterator(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public courseInfo remove(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean remove(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public courseInfo set(int arg0, courseInfo arg1) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<courseInfo> subList(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> T[] toArray(T[] arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	
	
    
}
}
