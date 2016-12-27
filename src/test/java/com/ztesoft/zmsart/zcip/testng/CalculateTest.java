package com.ztesoft.zmsart.zcip.testng;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculateTest {

	@Test
	public void testSum() {
		Calculate cal = new Calculate();
		int a = 2;
		int b = 4;
		Assert.assertEquals(6, cal.sum(a, b), "Test Calculate sum");
	}
	
	
	@Test
	public void testDivide() {
		
		Calculate cal = new Calculate();
		BigDecimal a = new BigDecimal(4);
		BigDecimal b = new BigDecimal(2);
		
		try {
			Assert.assertEquals(b, cal.divide(a, b), "Test Calculate divide");
		} catch (Exception e) {
			Assert.fail("Test Calculate divide fail");
		}
		
		try {
			Assert.assertEquals(b, cal.divide(a, BigDecimal.ZERO), "Test Calculate divide");
		} catch (Exception e) {
			Assert.assertEquals("divide is zero", e.getMessage());
		}
	}
	
	
	@Test
	public void testName3() {
		Person person = new Person();
		person.setAge(24);
		person.setName("chm");
		
		Assert.assertEquals("ctest name", "343434", person.getName());
		Assert.assertEquals(100, person.getAge(), "test");
		
	}
}
