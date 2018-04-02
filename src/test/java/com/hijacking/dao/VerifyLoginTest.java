package com.hijacking.dao;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hijacking.util.LogMessage;

public class VerifyLoginTest {

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithValidCredentials() throws Exception {

		LogMessage.logMessage("Verifying login with valid credentials, without any attack");
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test", "test");
		Assert.assertNotEquals(result, -1);

	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithInValidCredentials() throws Exception {
		LogMessage.logMessage("Verifying login with invalid credentials, without any attack");

		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", "test1");
		Assert.assertEquals(result, -1);

	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack1() throws Exception {
		String input = "' OR 1 = 1-- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack2() throws Exception {
		String input = "' OR 1 = 1 and 1-- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack3() throws Exception {
		String input = "' OR 1 || 1 = 1-- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack4() throws Exception {
		String input = "' OR 1 && 1 = 1-- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack5() throws Exception {
		String input = "' OR 2 > 1 -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack6() throws Exception {
		String input = "xx' OR 'x'='x";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack7() throws Exception {
		String input = "' OR 'ABCD' = 'ABC'+'D";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack8() throws Exception {
		String input = "' OR 'ABCD' > 'A' -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack9() throws Exception {
		String input = "' OR 'ABC' = N'ABC' -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack10() throws Exception {
		String input = "' OR 10 between 1 and 100 -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack11() throws Exception {
		String input = "' OR id between 1 and 100 -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack12() throws Exception {
		String input = "%00' OR id between 1 and 100 -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack13() throws Exception {
		String input = "' or ASCII(SUBSTRING('a',1,1))=97 -- ";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

	@Test(dependsOnGroups = { "registraion" })
	public void verifyLoginwithTautologyAttack14() throws Exception {
		String input = "' OR ''='";
		LogMessage.logMessage("Verifying login with tautology attack with input " + input);
		VerifyLogin verifyLogin = new VerifyLogin();
		int result = verifyLogin.verifyLogin("test1", input);
		Assert.assertNotEquals(result, -1);
	}

}
