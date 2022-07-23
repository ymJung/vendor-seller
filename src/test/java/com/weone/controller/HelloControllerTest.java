package com.weone.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelloControllerTest {

	private int lastStoneWeight;

	@Test
	public void test() {
		// solution(new int[] {2,1,4,5,322}, 3);
		// solution(new int[] {4, 35, 80, 123, 12345, 44, 8, 5}, 10);
		// String input = "a0Ba";
		// System.out.println(solution(input));
		// System.out.println(solution0(new int[] {1, 4, -1, 3, 2}));
	}

	// public int solution0(int[] array) {
	// int len = 1;
	// int pos = 0;
	// int tmp = 0;
	// for (int i = 0; i < array.length; i++) {
	// tmp = array[pos];
	// if (tmp < 0) { // -1
	// return len;
	// } else {
	// len++;
	// }
	// pos = tmp;
	// }
	// return len;
	// }
	//
	// private static String MATCH_EXP = "^[a-zA-Z0-9]*$";
	// private final static int FAIL = -1;
	// private final static int SUCCESS = 2;
	// public int solution(String input) {
	// if (!input.matches(MATCH_EXP) || input == null || input.isEmpty()) {
	// return FAIL;
	// }
	// boolean hasUpper = false;
	// for (int i = 0; i < input.length(); i++) {
	// char a = input.charAt(i);
	// if (Character.isUpperCase(a)) {
	// hasUpper = true;
	// }
	// }
	// return hasUpper ? SUCCESS : FAIL;
	// }
	//
	//
	// public void solution1(int[] A, int K) {
	// List<Integer> numbers =
	// Arrays.stream(A).boxed().collect(Collectors.toList());
	// int limit = K > numbers.size() ? numbers.size() : K;
	// List<List<Integer>> slicedList = getSlicedList(numbers, limit);
	// Integer maxWallNumberLength =
	// numbers.stream().max(Integer::compareTo).get().toString().length();
	// for (int i = 0; i < slicedList.size(); i ++) {
	// List<Integer> sliced = slicedList.get(i);
	// System.out.println(printFloorWall(Math.max(limit, sliced.size()),
	// maxWallNumberLength));
	// System.out.println(printSideWall(sliced, maxWallNumberLength));
	// if (i == slicedList.size() - 1) {
	// System.out.println(printFloorWall(sliced.size(), maxWallNumberLength));
	// }
	// }
	// }
	// private List<List<Integer>> getSlicedList(List<Integer> numbers, int limit) {
	// List<List<Integer>> slicedList = new ArrayList<>();
	// int size = numbers.size();
	// for (int i = 0; i < size; i+= limit) {
	// slicedList.add(numbers.subList(i, Math.min(size, i + limit)));
	// }
	// return slicedList;
	// }
	// private String printSideWall(List<Integer> numbers, Integer maxNumLen) {
	// StringBuilder results = new StringBuilder("|");
	// for (int i = 0; i < numbers.size(); i++) {
	// int inputNumSize = numbers.get(i).toString().length();
	// results.append(getPaddingNumber(numbers.get(i), maxNumLen -
	// inputNumSize)).append("|");
	// }
	// return results.toString();
	// }
	// private String getPaddingNumber(int number, int padding) {
	// StringBuilder result = new StringBuilder();
	// for (int i = 0; i < padding; i++) {
	// result.append(" ");
	// }
	// result.append(number);
	// return result.toString();
	// }
	// private String printFloorWall(int slicedSize, int maxNumber) {
	// StringBuilder results = new StringBuilder("+");
	// for(int idx = 0; idx < slicedSize; idx++ ) {
	// String wall = "";
	// for (int i = 0; i < maxNumber; i++) {
	// wall += "-";
	// };
	// results.append(wall).append("+");
	// }
	// return results.toString();
	// }
	// @Test
	// public void test1() {
	// 	// System.out.println("test");
	// 	// int N = 10;
	// 	// int temp = 0;
	// 	// for (int i = 0; i < N; i++) {
	// 	// 	for (int j = 0; j < i * i; j++) {
	// 	// 		for (int k = i; ~k; k -= i) {
	// 	// 			temp++;
	// 	// 		}
	// 	// 	}
	// 	// }
	// 	// System.out.println(temp);
	// 	int lastStoneWeight = lastStoneWeight(new int[] {1,2,3,6,7,7});
	// 	System.out.println(lastStoneWeight);
	// }

	public int lastStoneWeight(int[] stones) {
        for (int i = stones.length - 1; i > 0; i--) {
            Arrays.sort(stones);
			System.out.println(stones[i] + " " + stones[i-1]);
            stones[i - 1] = stones[i] - stones[i - 1]; // last two big stone.
            stones = Arrays.copyOf(stones, i);
        }

        return stones[0];
    }

	@Test
	public void test2() {
		List<String> maps = Arrays.asList(
		);

		Set<String> countries = new TreeSet<>();
		Set<String> borders = new TreeSet<>();
		for (int idx = 0; idx < maps.size(); idx++) {
			List<String> xList = getList(maps.get(idx));
			for (int jdx = 0; jdx < xList.size(); jdx++) {
				if ((jdx + 1) == xList.size()) {
					break;
				}
				if (isSkipTarget(xList, jdx)) {
					continue;
				}
				String country = xList.get(jdx);				
				String countryR = xList.get(jdx + 1);
				String countryD = getDownCountry(maps, idx, jdx);

				String diff = getDiffrentCountry(country, countryR, countryD);
				if (EMPTY_STR.equals(diff)) {
					continue;
				}
				countries.add(country);
				String sortStr = getSort(country, diff);
				borders.add(sortStr);		
			}			
		}
		List<Integer> res = getResult(countries, borders);
		System.out.println(res);

	}

	private List<Integer> getResult(Set<String> countries, Set<String> borders) {
		int max = 0;
		int tmp = 0;
		for (String country : countries) {
			tmp = 0;
			for (String border : borders) {
				if (border.contains(country)) {
					tmp += 1;
				}
			}
			if (tmp > max) {
				max = tmp;
			}
		}
		return Arrays.asList(borders.size(), max);
	}

	private static final String SKIP_STR = ".";
	private static final String EMPTY_STR = "";

	private String getSort(String... arg) {
		return Stream.of(arg).sorted().collect(Collectors.joining());
	}
	private String getDiffrentCountry(String... countries) {
		String origin = countries[0];
		for (int i = 1; i <countries.length; i++) {
			if (SKIP_STR.equals(countries[i]) || EMPTY_STR.equals(countries[i])) {
				continue;
			}
			if (!origin.equals(countries[i])) {
				return countries[i];
			}
		} 
		
		return EMPTY_STR;
	}

	private String getDownCountry(List<String> maps, int idx, int jdx) {
		if (maps.size() < (idx + 1)) {
			return EMPTY_STR;
		}
		List<String> list = getList(maps.get(idx + 1));
		return SKIP_STR.equals(list.get(jdx)) ? EMPTY_STR : list.get(jdx);
	}
	private boolean isSkipTarget(List<String> list, int idx) {
		if (SKIP_STR.equals(list.get(idx)) || SKIP_STR.equals(list.get(idx + 1))) {
			return true;
		}

		return false;
	}

	private List<String> getList(String each) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < each.length(); i++) {
			res.add(String.valueOf(each.charAt(i)));
		}
		return res;
	}



	@Test
	public void test4() {
		// mkdir / rm / cp  1-20

		List<String> dirs = new ArrayList<>(Arrays.asList("/", "/hello", "/hello/tmp", "/root", "/root/abcd", "/root/abcd/etc", "/root/abcd/hello"));
		List<String> commands = Arrays.asList("mkdir /root/tmp", "cp /hello /root/tmp", "rm /hello");
		// List<String> dirs = new ArrayList<>(Arrays.asList("/"));
		// List<String> commands = Arrays.asList("mkdir /a", "mkdir /a/b", "mkdir /a/b/c", "cp /a/b /", "rm /a/b/c");
		
		List<String> res = solution(dirs, commands);
		System.out.println(res);

	}

	private List<String> solution(List<String> dirs, List<String> commands) {
		for (String command : commands) {
			String[] commandSplits = command.split(" ");
			String commOper = commandSplits[0];
			String commDir = commandSplits[1];
			String destDir = "";
			if (commandSplits.length > 2) {
				destDir  = commandSplits[2];
			}

			COMMAND commEnum = COMMAND.find(commOper);
			if (dirOrFileLengthIsOver(commDir, destDir)) {
				throw new IllegalArgumentException("wrong dir size . ");
			}
		
			switch(commEnum) {
				case CP:
					if (!dirs.contains(commDir)) {
						return null;
					}
					if (destDir.startsWith(commDir)) {
						System.out.println("cannot copy to source path.");
						continue;
					}
					if (destDir.length() == 0) {
						System.out.println("copy dest path is wrong.");
						continue;
					}
					for (String childPath : getChildPaths(dirs, commDir)) {
						String copyPath = childPath.substring(childPath.indexOf(commDir) + commDir.lastIndexOf("/"));
						if ("".equals(copyPath)) {
							continue;
						}
						if ("/".equals(destDir)) {
							dirs.add(copyPath);	
						} else {
							dirs.add(destDir + copyPath);
						}
						
					}					
					break;
				case MKDIR:
					if (dirs.contains(commDir)) {
						System.out.println("exist path " + commDir);
						continue;
					}
					dirs.add(commDir);
					break;
				case RM:
					if (!dirs.contains(commDir)) {
						System.out.println("not exist path " + commDir);
						continue;
					}
					if ("/".equals(commDir)) {
						System.out.println("do not allowed rm / ");
						continue;
					}
					for (String childPath : getChildPaths(dirs, commDir)) {
						dirs.remove(childPath);					}	
					dirs.remove(commDir);
					break;

			}
		}
		dirs.sort(Comparator.naturalOrder());
		return dirs;
	}

	private List<String> getChildPaths(List<String> dirs, String parentPath) {
		List<String> childPaths = new ArrayList<>();
		for (String dir : dirs) {
			if (dir.startsWith(parentPath)) {
				childPaths.add(dir);
			}
		}
		return childPaths;
	}

	private boolean dirOrFileLengthIsOver(String srcPath, String dest) {		
		String lastPath = srcPath.substring(srcPath.lastIndexOf("/") + 1);
		if (lastPath.length() > 10 || lastPath.length() < 1) {
			return true;
		}	
		if (dest.length() > 0) {
			String destPath = dest.substring(dest.lastIndexOf("/") + 1);
			if (!"/".equals(dest) && (destPath.length() > 10 || destPath.length() < 1)) {
				return true;
			}		
		}
		
		return false;
	}

	enum COMMAND {
		MKDIR("mkdir"), RM("rm"), CP("cp");
		private String command;
		private COMMAND(String command) {
			this.command = command;
		}
		public static COMMAND find(String operation) {
			for (COMMAND each : values()) {
				if (each.command.equals(operation)) {
					return each;
				}
			}
			throw new UnsupportedOperationException("invalid command");
		}		
	}


	@Test
	public void test3() {
		List<List<String>> list = Arrays.asList(
			Arrays.asList(
			".....",
			 ".XXX.", 
			 ".X.X.", 
			 ".XXX.",
			  ".....")
			// ,Arrays.asList("XXXXX", "XXXXX", "XXX.X", "XXX.X", "XXXXX"),
			// Arrays.asList("....X", ".....", "XXX..", "X.X..", "XXX.."),
			// Arrays.asList("......", "XXX.XXX", "X.X.X.X", "XXX.XXX", "......."),
			// Arrays.asList("XXXXX", "XX.XX", "X...X", "XX.XX", "XXXXX")
		);
		List<Boolean> res = solution1(list);
		System.out.println(res);
	}

	private static final String DOT = "X";
	private List<Boolean> solution1(List<List<String>> list) {
		List<Boolean> res = new ArrayList<>();
		for (int idx = 0; idx < list.size(); idx++) {
			List<String> lines = list.get(idx);
			res.add(isSquare(lines));
			// for (int i = 0; i < lines.size(); i++) {
			// 	String line = lines.get(i);
			// 	res.add(isSquare(lines, line, i));
				// if (isSquare(lines, line, i)) {										
				// 	res.add(isInnerSquare());
				// } else {
				// 	res.add(false);
				// }

				// if (isSquare(lines, line, i)) {
				// 	List<String> innnerLines = new ArrayList<>();
				// 	String l = "";
				// }
				// for (int j = 0; j < line.length(); j++) {
				// 	// String now = String.valueOf(line.charAt(j));
				// 	if (isSquare(lines, line, i, j)) {
				// 		List<String> innnerLines = new ArrayList<>();
				// 		String l = "";
				// 	}
					
					
				// }		

			// }
			
		}

		return res;
	}

	private boolean isSquare(List<String> lines) {		
		for (int lineIdx = 0; lineIdx < lines.size(); lineIdx++) {
			String line = lines.get(lineIdx);
			int firstXPos = getFirstDot(line);
			if (firstXPos == -1) {
				continue;
			}
			int lastXPos = getLastDot(line, firstXPos);
			if (lastXPos <= firstXPos) {			
				continue;
			}
			int rectRightCorner = getRightCorner(lastXPos, lines, lineIdx);
			if (rectRightCorner == -1) {
				continue;
			}
			int rectLeftCorner = getLeftCorner(rectRightCorner, lines, rectRightCorner);

			System.out.println(firstXPos + " " + lastXPos + " // " + rectRightCorner + " " + rectLeftCorner);;

		}
		


		return false;
	}

	private int getLeftCorner(int rectRightCorner, List<String> lines, int lineIdx) {
		for (int i = rectRightCorner; i >= 0; i--) {
			String leftSide = String.valueOf(lines.get(rectRightCorner).charAt(i));
			
			if (DOT.equals(leftSide)) {
				continue;
			}
			return i + 1;

		}		
		
		return -1;
	}

	private int getRightCorner(int lastXPos, List<String> lines, int lineIdx) {
		for (int i = lineIdx + 1; i < lines.size(); i++) {
			String downSide = String.valueOf(lines.get(i).charAt(lastXPos));
			
			if (DOT.equals(downSide)) {
				continue;
			}
			return i - 1;

		}		
		
		return -1;
	}

	private int getFirstDot(String line) {
		return line.indexOf(DOT);		
	}

	private int getLastDot(String line, int xpos) {
		for (int i = xpos; i < line.length(); i++) {			
			String now = String.valueOf(line.charAt(i));
			if (DOT.equals(now)) {
				continue;
			}
			return i - 1;
		}		
		return xpos;
	}

	
	@Test
	public void castTest() {
		convert("1232", 0);
		convert(3.2, 0);
		convert((byte)112, 0);
	}

	private long convert(Object obj, int def) {
		boolean hasLongValueMethod = false;
		long result = def;
		if (obj == null) {
			return result;
		}
		
		for (Method method : obj.getClass().getDeclaredMethods()) {
			try {
				if ("longValue".equals(method.getName())) {
					result = (long) method.invoke(obj);
					hasLongValueMethod = true;
					break;
				}
			} catch (IllegalAccessException|IllegalArgumentException|InvocationTargetException e) {
				e.printStackTrace(); // except
			}
		}
		if (!hasLongValueMethod) {
			result = Long.parseLong(obj.toString());
		}
		return result;
	}
}
