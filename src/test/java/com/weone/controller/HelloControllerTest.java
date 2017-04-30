package com.weone.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelloControllerTest {
	
	@Test
	public void test() {
//		solution(new int[] {2,1,4,5,322}, 3);
//		solution(new int[] {4, 35, 80, 123, 12345, 44, 8, 5}, 10);
//		String input = "a0Ba";
//		System.out.println(solution(input));
		System.out.println(solution0(new int[] {1, 4, -1, 3, 2}));
	}
    public int solution0(int[] array) {
        int len = 1;
        int pos = 0;
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            tmp = array[pos];
            if (tmp < 0) { // -1
                return len;    
            } else {
                len++;
            }
            pos = tmp;
        }        
        return len;
    }
	
	private static String MATCH_EXP = "^[a-zA-Z0-9]*$";
	private final static int FAIL = -1;
	private final static int SUCCESS = 2;
	public int solution(String input) {
		if (!input.matches(MATCH_EXP) || input == null || input.isEmpty()) {
			return FAIL;
		}
		boolean hasUpper = false;
		for (int i = 0; i < input.length(); i++) {
			char a = input.charAt(i);
			if (Character.isUpperCase(a)) {
				hasUpper = true;
			}
		}
		return hasUpper ? SUCCESS : FAIL;
	}
	
	
	public void solution1(int[] A, int K) {
		List<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toList());
		int limit = K > numbers.size() ? numbers.size() : K;
		List<List<Integer>> slicedList = getSlicedList(numbers, limit);
		Integer maxWallNumberLength = numbers.stream().max(Integer::compareTo).get().toString().length();
		for (int i = 0; i < slicedList.size(); i ++) {
			List<Integer> sliced = slicedList.get(i);
			System.out.println(printFloorWall(Math.max(limit, sliced.size()), maxWallNumberLength));
			System.out.println(printSideWall(sliced, maxWallNumberLength));			
			if (i == slicedList.size() - 1) {
				System.out.println(printFloorWall(sliced.size(), maxWallNumberLength));
			}
		}
	}
	private List<List<Integer>> getSlicedList(List<Integer> numbers, int limit) {
		List<List<Integer>> slicedList = new ArrayList<>();
		int size = numbers.size();
		for (int i = 0; i < size; i+= limit) {
			slicedList.add(numbers.subList(i, Math.min(size, i + limit)));
		}
		return slicedList;
	}
	private String printSideWall(List<Integer> numbers, Integer maxNumLen) {
		StringBuilder results = new StringBuilder("|");
		for (int i = 0; i < numbers.size(); i++) {
			int inputNumSize = numbers.get(i).toString().length();
			results.append(getPaddingNumber(numbers.get(i), maxNumLen - inputNumSize)).append("|");
		}			
		return results.toString();
	}
	private String getPaddingNumber(int number, int padding) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < padding; i++) {
			result.append(" ");
		}
		result.append(number);
		return result.toString();
	}
	private String printFloorWall(int slicedSize, int maxNumber) {
		StringBuilder results = new StringBuilder("+");
		for(int idx = 0; idx < slicedSize; idx++ ) {
			String wall = "";
			for (int i = 0; i < maxNumber; i++) {
				wall += "-";
			};			
			results.append(wall).append("+");			
		}
		return results.toString();
	}
}
