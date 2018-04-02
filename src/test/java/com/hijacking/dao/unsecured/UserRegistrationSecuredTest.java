package com.hijacking.dao.unsecured;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.hijacking.dao.UserRegistration;
import com.hijacking.dao.secured.UserRegistrationSecured;

public class UserRegistrationSecuredTest {

	@BeforeClass
	public void beforeSuite() {
		UserRegistrationSecured userRegistration = new UserRegistrationSecured();
		userRegistration.deleteUsers();
	}

	@Test(groups = { "securedregistraion" })
	public void testRegistraion() {

		UserRegistrationSecured userRegistration = new UserRegistrationSecured();
		int inserted = userRegistration.addUser("test", "test", "test", "test@gmail.com");
		Assert.assertEquals(1, inserted);

	}

	@Test(dependsOnMethods = { "testRegistraion" }, groups = { "securedregistraion" })
	public void testRegistraionSecondTime() {

		UserRegistrationSecured userRegistration = new UserRegistrationSecured();
		int inserted = userRegistration.addUser("test", "test", "test", "test@gmail.com");
		Assert.assertEquals(-1, inserted);

	}
}
