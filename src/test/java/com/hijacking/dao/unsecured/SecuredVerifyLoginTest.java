package com.hijacking.dao.unsecured;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hijacking.dao.secured.SecuredVerifyLogin;
import com.hijacking.util.LogMessage;

public class SecuredVerifyLoginTest {

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithValidCredentials() throws Exception {

		LogMessage.logMessage("Verifying login with valid credentials, without any attack");
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test", "test");
		Assert.assertNotEquals(result, -1);

	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithInValidCredentials() throws Exception {
		LogMessage.logMessage("Verifying login with invalid credentials, without any attack");

		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", "test1");
		Assert.assertEquals(result, -1);

	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack1() throws Exception {
		String input = "' OR 1 = 1-- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack2() throws Exception {
		String input = "' OR 1 = 1 and 1-- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack3() throws Exception {
		String input = "' OR 1 || 1 = 1-- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack4() throws Exception {
		String input = "' OR 1 && 1 = 1-- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack5() throws Exception {
		String input = "' OR 2 > 1 -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack6() throws Exception {
		String input = "xx' OR 'x'='x";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack7() throws Exception {
		String input = "' OR 'ABCD' = 'ABC'+'D";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack8() throws Exception {
		String input = "' OR 'ABCD' > 'A' -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack9() throws Exception {
		String input = "' OR 'ABC' = N'ABC' -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack10() throws Exception {
		String input = "' OR 10 between 1 and 100 -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack11() throws Exception {
		String input = "' OR id between 1 and 100 -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack12() throws Exception {
		String input = "%00' OR id between 1 and 100 -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack13() throws Exception {
		String input = "' or ASCII(SUBSTRING('a',1,1))=97 -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		com.hijacking.dao.secured.SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}

	@Test(dependsOnGroups = { "securedregistraion" })
	public void verifySecuredLoginwithTautologyAttack14() throws Exception {
		String input = "' OR ''='";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		SecuredVerifyLogin verifyLogin = new SecuredVerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertEquals(result, -1);
	}
}
