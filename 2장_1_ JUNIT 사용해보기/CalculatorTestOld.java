package com.calculator;

public class CalculatorTestOld {
	public static void main(String[] args) {
		// 복잡도가 증가하고 main() 메소드를 유지하는 데 부담이 된다.
//		Calculator cal = new Calculator();
//		System.out.println(cal.add(9, 3));
//		System.out.println(cal.subtract(9, 3));
//		System.out.println(cal.multiply(9, 3));
//		System.out.println(cal.divide(9, 3));
		
		// 메소드별 분리
		// 단점
		// 1. 새로 메소드 만들고 테스트 할 때 나머지를 주석처리 해야한다.
		// 2. 매번 콘솔 출력 값을 테스트 해야만 한다
		Calculator cal = new Calculator();
		add(cal);
		subtract(cal);
		multiply(cal);
		divide(cal);
	}
	
	private static void divide(Calculator cal) {
		System.out.println(cal.divide(9, 3));
	}
	
	private static void multiply(Calculator cal) {
		System.out.println(cal.multiply(9, 3));
	}
	
	private static void subtract(Calculator cal) {
		System.out.println(cal.subtract(9, 3));
	}
	
	private static void add(Calculator cal) {
		System.out.println(cal.add(9, 3));
	}
 }
