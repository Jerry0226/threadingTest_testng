package com.ztesoft.zmsart.zcip.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonTest {

	@Test
	public void testSet() {
		Person person = new Person();
		person.setAge(22);
		person.setName("chm");
		Assert.assertEquals(person.getName(), "chm", "chm test");
		
	}
	
	@Test
	public void testSet2() {
		Person person = new Person();
		person.setAge(22);
		person.setName("chm");
		
		Assert.assertEquals(person.getName(), "chm", "test name");
		Assert.assertEquals(22, person.getAge(), "test age");
		
	}
	
	
	@Test
	public void testSet3() {
		Person person = new Person();
		person.setAge(24);
		person.setName("chm");
		Assert.assertEquals(person.getName(), "chm", "test name");
		Assert.assertEquals(22, person.getAge(), "test age");
		
	}
}
