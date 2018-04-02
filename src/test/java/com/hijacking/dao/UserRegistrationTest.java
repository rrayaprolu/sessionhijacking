package com.hijacking.dao;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UserRegistrationTest {

	@BeforeClass
	public void beforeSuite() {
		UserRegistration userRegistration = new UserRegistration();
		userRegistration.deleteUsers();
	}

	@Test(groups = { "registraion" })
	public void testRegistraion() {

		UserRegistration userRegistration = new UserRegistration();
		int inserted = userRegistration.addUser("test", "test", "test", "test@gmail.com");
		Assert.assertEquals(1, inserted);

	}

	@Test(dependsOnMethods = { "testRegistraion" }, groups = { "registraion" })
	public void testRegistraionSecondTime() {

		UserRegistration userRegistration = new UserRegistration();
		int inserted = userRegistration.addUser("test", "test", "test", "test@gmail.com");
		Assert.assertEquals(-1, inserted);

	}
}
