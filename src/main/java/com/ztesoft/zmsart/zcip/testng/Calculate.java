package com.ztesoft.zmsart.zcip.testng;

import java.math.BigDecimal;

public class Calculate {
	
	public int sum(int a, int b) {
		return a + b;
	}
	
	public BigDecimal divide(BigDecimal a, BigDecimal b) throws Exception {
		if (BigDecimal.ZERO == b) {
			throw new Exception("divide is zero");
		}
		else {
			return a.divide(b);
		}
	}
	
}
