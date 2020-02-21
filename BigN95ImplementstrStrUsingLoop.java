//Time complexity is O(m*n)
//Space complexity is O(1)
//This solution is submitted on Leetcode

public class BigN95ImplementstrStrUsingLoop {
	class Solution {
		public int strStr(String haystack, String needle) {
			// edge case
			int hayLen = haystack.length();
			int needLen = needle.length();
			if (needLen == 0)
				return 0;
			for (int i = 0; i < hayLen; i++) {
				if (i + needle.length() > haystack.length())
					break;
				for (int j = 0; j < needLen; j++) {
					if (haystack.charAt(i + j) != needle.charAt(j))
						break;
					if (j == needLen - 1)
						return i;
				}
			}
			return -1;
		}
	}
}