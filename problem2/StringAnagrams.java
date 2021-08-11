// Time Complexity : O(m + n), m -> Length of p, n -> Length of s
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
	/********************* 2 ARRAYS - One for each string *********************/
	// Time Complexity : O(m + n), m -> Length of p, n -> Length of s
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public List<Integer> findAnagramsArray(String s, String p) {
		List<Integer> ans = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
			return ans;
		}

		int m = p.length();
		int n = s.length();

		int[] pCnt = new int[26];
		int[] sCnt = new int[26];

		for (int i = 0; i < m; i++) {
			pCnt[p.charAt(i) - 'a']++;
		}

		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			sCnt[ch - 'a']++;

			if (i >= m) {
				sCnt[s.charAt(i - m) - 'a']--;
			}

			if (Arrays.equals(pCnt, sCnt)) {
				ans.add(i - m + 1);
			}
		}

		return ans;
	}

	/********************* Sliding Window - HashMap *********************/
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> ans = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
			return ans;
		}

		int m = p.length();
		int n = s.length();

		Map<Character, Integer> cntMap = new HashMap<Character, Integer>();

		for (int i = 0; i < m; i++) {
			cntMap.put(p.charAt(i), cntMap.getOrDefault(p.charAt(i), 0) + 1);
		}

		int match = 0;

		for (int i = 0; i < n; i++) {
			char chIn = s.charAt(i);
			// in
			if (cntMap.containsKey(chIn)) {
				cntMap.put(chIn, cntMap.get(chIn) - 1);
				if (cntMap.get(chIn) == 0) {
					match++;
				}
			}
			// out
			if (i >= m) {
				char chOut = s.charAt(i - m);
				if (cntMap.containsKey(chOut)) {
					cntMap.put(chOut, cntMap.get(chOut) + 1);
					if (cntMap.get(chOut) == 1) {
						match--;
					}
				}
			}

			if (match == cntMap.size()) {
				ans.add(i - m + 1);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		StringAnagrams obj = new StringAnagrams();
		String s = "cbaebabacd";
		String p = "abc";

		List<Integer> anagramPositions = obj.findAnagrams(s, p);

		System.out.println("Anagram positions: ");
		for (Integer index : anagramPositions) {
			System.out.print(index + " ");
		}
	}

}
