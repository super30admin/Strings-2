//Time Complexity : O(N*M)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Iterate over the haystack and at each index check if from that character is
 * matching with the needle. if matched, then return the start index. Also,
 * iterate only till the haystack length - needle length to avoid Index out of
 * bound exceptions.
 *
 */
class Solution {
	public int strStr(String haystack, String needle) {
		int m = haystack.length();
		int n = needle.length();
		for (int start = 0; start <= m - n; start++) {
			for (int i = 0; i < n; i++) {
				if (haystack.charAt(start + i) != needle.charAt(i)) {
					break;
				} else {
					if (i == n - 1)
						return start;
				}
			}
		}
		return -1;
	}
}