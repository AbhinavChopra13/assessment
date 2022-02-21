package com.assessment.service;

import java.util.List;

import com.assessment.entity.MyEntity;

public interface MyServiceInterface {

	int createProfileService(MyEntity w);

	boolean loginProfile(MyEntity m);

	boolean checkemail(MyEntity m);

	MyEntity viewprofile(MyEntity m);

	int deleteprofile(MyEntity m);

	List<MyEntity> viewallprofile(MyEntity m);

}
