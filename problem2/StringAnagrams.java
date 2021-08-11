// Time Complexity : O(m + n), m -> Length of p, n -> Length of s
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
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
