package com.stringcalculator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	Calculator calculator;
	
	@Before
	public void setUp() {
		calculator = new Calculator(); 
	}
	
	/**
	 * 커스텀 구분자 찾기 테스트
	 */
	@Test
	public void findCustomSeparator() {
		String separator = "abc";
		String dummy = "asfasfasf";
		String str = Calculator.CUSTOM_SEPARATOR_START + separator + Calculator.CUSTOM_SEPARATOR_END + dummy;
		assertEquals(separator, calculator.findCustomSeparator(str));
	}
		
	/**
	 * 구분자 찾기 메소드 테스트
	 */
	@Test
	public void findSeparator() {
		String separator = calculator.findSeparator("asdvcx");
		assertEquals(Calculator.DEFAULT_SEPARATOR, separator);
	}
	
	/**
	 * 구분자 찾기 메소드 테스트
	 */
	@Test
	public void findSeparator2() {
		String separator = "asdzzz";
		String str = Calculator.CUSTOM_SEPARATOR_START + separator + Calculator.CUSTOM_SEPARATOR_END + "tessa";
		assertEquals(separator, calculator.findSeparator(str));
	}	
	
	/**
	 * 숫자 배열 구하기
	 */
	@Test
	public void findNumArr() {
		int[] arr = calculator.findNumArr("1a2a3a4a5a", "a");
		assertArrayEquals(new int[]{1,2,3,4,5}, arr);
	}
	
	/**
	 * 예외처리 테스트
	 */
	@Test
	public void testException() {
		assertThrows(RuntimeException.class, ()-> {
			calculator.findNumArr("1a2a3a4a5a-1", "a");
		});
	}
	
	@Test
	public void sum() throws Exception {
		assertEquals(10, calculator.add("1,2,3,4"));
		assertEquals(6, calculator.add("1,2:3"));
		assertEquals(6, calculator.add("//;\n1;2;3"));
	}
}
