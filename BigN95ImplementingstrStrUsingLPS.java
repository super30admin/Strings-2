//Time complexity is O(n)
//Space complexity is O(1)
//This solution is submitted on Leetcode

public class BigN95ImplementingstrStrUsingLPS {
	class Solution {
		public int strStr(String haystack, String needle) {
			// edge case
			if (needle.length() == 0)
				return 0;
			int hayLen = haystack.length();
			int needLen = needle.length();
			int i = 0;
			int j = 0;
			int[] lps = helper(needle, needLen);
			while (i < hayLen) {
				if (haystack.charAt(i) == needle.charAt(j)) {
					i++;
					j++;
				}
				// This condition should be put first before if else else you will get out of
				// bound exception
				if (j == needLen) {
					return i - needLen;
				}
				if (i < hayLen && j > 0 && haystack.charAt(i) != needle.charAt(j)) {
					j = lps[j - 1];
				} else if (i < hayLen && j == 0 && haystack.charAt(i) != needle.charAt(j)) {
					i++;
				}

			}
			return -1;
		}

		private int[] helper(String pattern, int len) {
			int[] lps = new int[len];
			int j = 0;
			int i = 1;
			while (i < len) {
				// case 1;
				if (pattern.charAt(j) == pattern.charAt(i)) {
					j++;
					lps[i] = j;
					i++;
				} else if (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
					j = lps[j - 1];
				} else if (j == 0 && pattern.charAt(j) != pattern.charAt(i)) {
					lps[i] = 0;
					i++;
				}
			}
			return lps;
		}
	}
}