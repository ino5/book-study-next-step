package com.stringcalculator;

public class Calculator {
	static final String CUSTOM_SEPARATOR_START = "//"; // 커스텀 구분자 시작 부분
	static final String CUSTOM_SEPARATOR_END = "\n"; // 커스텀 구분자 끝 부분
	static final String DEFAULT_SEPARATOR = ",|:"; // 기본 구분자
	
	int add(String str) throws Exception {		
		// 들어온 파라미터가 유효한 문자열인지 판단하기
		if(!validateParam(str)) {
			throw new Exception("유효하지 않은 파라미터");
		}
		
		// 들어온 파라미터의 값이 0인지 판단하기
		if(checkZero(str)) {
			return 0;
		}
		
		// 구분자 값 찾기
		String separator = findSeparator(str);
		
		// 문자열을 구분자로 나누어서 숫자 배열 만들기
		int[] numArr = findNumArr(str, separator);
		
		// 숫자 배열의 합 구하기
		int result = sum(numArr);
		
		return result;
	}
	
	/**
	 * 파라미터가 유효한 문자열인지 판단하기
	 * @param str
	 * @return
	 */
	boolean validateParam(String str) {
		boolean isValidated = true;
		if (str == null) {
			isValidated = false;
		}
		
		return isValidated;
	}
	
	/**
	 * 해당 문자열이 0인지 확인하기
	 * @param str
	 * @return
	 */
	boolean checkZero(String str) {
		boolean isZero = false;
		if (str.trim().equals("")) {
			isZero = true;
		}
		return isZero;
	}
	
	/**
	 * 커스텀 구분자를 가져오기
	 * @param str
	 * @return 커스텀 구분자가 없을 경우 null, 있을 경우 커스텀 구분자 문자열
	 */
	String findCustomSeparator(String str) {
		int minLength = CUSTOM_SEPARATOR_START.length() + CUSTOM_SEPARATOR_END.length();
		if (str == null || str.length() < minLength) {
			return null;
		} else if (!str.substring(0, CUSTOM_SEPARATOR_START.length()).equals(CUSTOM_SEPARATOR_START)) {
			return null;
		}
		int sIdx = CUSTOM_SEPARATOR_START.length();
		int eIdx = str.indexOf(CUSTOM_SEPARATOR_END);
		String separator = str.substring(sIdx, eIdx);
		
		return separator;
	}
	
	/**
	 * 구분자 결정하기
	 * @param str
	 * @return 구분자
	 */
	String findSeparator(String str) {
		String customSeparator = findCustomSeparator(str); // 커스텀 구분자 찾기
		if (customSeparator == null) {
			return DEFAULT_SEPARATOR;
		} else {
			return customSeparator;
		}		
	}
	
	/**
	 * 문자열을 구분자로 나누어서 숫자 배열 만들기
	 * @param str
	 * @param separator
	 * @return
	 */
	int[] findNumArr(String str, String separator) {
		int sIdx = 0;
		// 문자열에 커스텀 구분자가 있는 경우
		if (str.length() >= CUSTOM_SEPARATOR_START.length() &&
		    str.substring(0, CUSTOM_SEPARATOR_START.length()).equals(CUSTOM_SEPARATOR_START)) {
			// 커스텀구분자 시작 구분자 + 커스텀구분자 + 커스텀구분자 종료 구분자의 문자열 길이만큼 인덱스를 증가시킨다.
			sIdx = CUSTOM_SEPARATOR_START.length() + separator.length() + CUSTOM_SEPARATOR_END.length();
		}
		String[] strArr = str.substring(sIdx).split(separator);
		int[] intArr = new int[strArr.length];
		for (int i = 0; i < intArr.length; i++) {
			int num = Integer.parseInt(strArr[i]);
			if (num < 0) { // 음수일 경우 예외처리
				throw new RuntimeException("음수");
			}
			intArr[i] = num;
		}
		return intArr;
	}
	
	/**
	 * 숫자 배열 내 숫자 합 구하기
	 * @param nums
	 * @return
	 */
	int sum(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return sum;
	}
}
