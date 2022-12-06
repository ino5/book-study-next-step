package com.stringcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringTest {
	
	/**
	 * String의 split 메소드 테스트
	 * |로 여러 구분자
	 */
	@Test
	public void testStringSplit() {
		String[] arrEx, arr;
		arrEx = new String[] {"a", "b", "c"}; 
		arr = "a,b:c".split(",|:");
		for (int i = 0; i < arr.length; i++) {
			assertEquals(arrEx[i], arr[i]);
		}
	}
	
	/**
	 * String의 split 메소드 테스트
	 * String으로 나누는 것
	 */
	@Test
	public void testStringSplit2() {
		String[] arrEx, arr;
		arrEx = new String[] {"a", "b", "c"}; 
		arr = "axzxbxzxcxzx".split("xzx");
		for (int i = 0; i < arr.length; i++) {
			assertEquals(arrEx[i], arr[i]);
		}
	}
}
