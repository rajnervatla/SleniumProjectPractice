package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotationOrder {

	@Test(priority = 2)
	public void testannotations()
	{
		System.out.println("Test 1-   1 ");
	}
	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("Before Suite--2");
		
	}
	@BeforeSuite
	public void beforesuite2()
	{
		System.out.println("Before Suite--4");
	}
	
	@BeforeTest
	public void beforetest()
	{
		System.out.println("I am in before test method ...");
	}
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Before method--3");
	}
	@BeforeClass
	public void bforeclass()
	{
		System.out.println("Before class--4");
	}
	
	@BeforeGroups
	public void befeore()
	{
		System.out.println("Inside before groups..");
	}
	@AfterGroups
	public void aftergroups()
	{
		System.out.println("Aftergroups");
	}

	
	
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Before class 2--5");
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("After class--6");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test--7");
	}
	@AfterMethod
	public void afteMethod()
	{
		System.out.println("After Method--8");	
	}
	@AfterSuite
	public void aftersuite()
	
	{
		System.out.println("After Suite--9");
	}
	@AfterSuite
	public void aftersuite1()
	
	{
		System.out.println("After Suite--12");
	}
	@Test(priority = 2)
	public void test2()
	{
		System.out.println(" Test 2--10");
	}
	
	
	@Test(priority = 1)
	public void test3()
	{
		System.out.println(" Test 3--11");
	}
	
	@Test(priority = 1)
	public void test4()
	{
		System.out.println(" Test 3--11");
	}
}
