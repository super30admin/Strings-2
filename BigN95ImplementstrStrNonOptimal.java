//Time complexity is O(m*n)
//Space complexity is O(1)
//This solution is submitted on Leetcode

public class BigN95ImplementstrStrNonOptimal {
	class Solution {
		public int strStr(String haystack, String needle) {
			// Non - optimal solution
			// edge case
			int hayLen = haystack.length();
			int needLen = needle.length();
			if (needLen == 0)
				return 0;
			for (int i = 0; i < hayLen; i++) {
				int j = 0;
				if (haystack.charAt(i) == needle.charAt(j)) {
					int temp = i;
					while (temp < hayLen && j < needLen) {
						if (haystack.charAt(temp) != needle.charAt(j)) {
							break;
						}
						j++;
						temp++;
					}
					if (j == needLen)
						return i;
				}
			}
			return -1;
		}
	}
}