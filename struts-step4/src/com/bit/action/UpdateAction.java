package com.bit.action;

import com.bit.model.GuestDao;
import com.bit.model.entity.GuestVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/*
 * ��Ʈ����2 ����
 * 
 * 1. ����
 * 2. ������ - java Web
 * 3. ���꼺 ������
 * 4. ���� ����
 * 5. ���ȭ
 * 6. POJO���
 * 
*/
public class UpdateAction extends ActionSupport 
				implements ModelDriven<GuestVo>, Preparable {
	GuestVo bean;
	
	public void setBean(GuestVo bean) {
		this.bean = bean;
	}
	public GuestVo getBean() {
		return bean;
	}

	@Override
	public void validate() {
		if(bean.getName()==null || bean.getName().equals("")){
			addFieldError("errmsg", "�̸��� �ݵ�� �Է��ϼ���");
		}else if(bean.getPay()<0){
			addFieldError("errmsg", "�ݾ��� Ȯ���ϼ���");			
		}
	}
	@Override
	public String execute() throws Exception {
		GuestDao dao = new GuestDao();
		int result=dao.updateOne(bean);
		if(result<1)return this.ERROR;
		return this.SUCCESS;
	}

	@Override
	public GuestVo getModel() {
		// TODO Auto-generated method stub
		return this.bean;
	}

	@Override
	public void prepare() throws Exception {
		bean = new GuestVo();
	}
}
