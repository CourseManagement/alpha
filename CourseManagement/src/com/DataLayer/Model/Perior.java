package com.DataLayer.Model;

/**
 * @parameter *
 * 
 * ѧ��ʵ����
 * periodidѧ�ڱ��
 * flagѧ��״̬��ʶ
 * ѧ��״̬��
 * 1���½�ѧ�ڣ�δ����α����ѡ�ο�ʼ/����ʱ��
 * 2��ѡ�ι�������δ��ʼѡ��
 * 3��ѡ�ν�����
 * 4��ѡ�ν�����ϵ���������
 * 5��Ժ�����������ϣ���ʷѡ�Σ�
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
