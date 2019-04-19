package edu.autocar.mybatisex;

import org.junit.Test;

import edu.autocar.base.sec.SHA256Util;

public class test {
	
	@Test
	public void test() throws Exception {
		String s = SHA256Util.generateSalt()  ;
		System.out.println(s);
	}
	

}
