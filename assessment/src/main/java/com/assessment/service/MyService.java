package com.assessment.service;

import java.util.List;

import com.assessment.dao.MyDAO;
import com.assessment.dao.MyDAOInterface;
import com.assessment.entity.MyEntity;

public class MyService implements MyServiceInterface {

	@Override
	public int createProfileService(MyEntity w) {
		MyDAOInterface md=new MyDAO();
		
		return md.createProfileDAO(w);
	}

	@Override
	public boolean loginProfile(MyEntity m) {
		MyDAOInterface md=new MyDAO();
		return md.loginProfileDAO(m);
	}

	@Override
	public boolean checkemail(MyEntity m) {
		MyDAOInterface md=new MyDAO();
		return md.checkemailDAO(m);
	}

	@Override
	public MyEntity viewprofile(MyEntity m) {
		MyDAOInterface md=new MyDAO();
		return md.viewprofileDAO(m);
	}

	@Override
	public int deleteprofile(MyEntity m) {
		MyDAOInterface md=new MyDAO();
		return md.deleteProfileDAO(m);
	}

	@Override
	public List<MyEntity> viewallprofile(MyEntity m) {
		MyDAOInterface md=new MyDAO();
		return md.viewallprofileDAO(m);
	}

}
