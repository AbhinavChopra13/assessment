package com.assessment.dao;

import java.util.List;

import com.assessment.entity.MyEntity;

public interface MyDAOInterface {

	int createProfileDAO(MyEntity w);

	boolean loginProfileDAO(MyEntity m);

	boolean checkemailDAO(MyEntity m);

	MyEntity viewprofileDAO(MyEntity m);

	int deleteProfileDAO(MyEntity m);

	List<MyEntity> viewallprofileDAO(MyEntity m);

}
