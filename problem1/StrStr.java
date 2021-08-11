// Time Complexity : O(m + n), m -> Length of haystack, n -> Length of needle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class StrStr {
	public int strStr(String haystack, String needle) {
		if (haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0) {
			return -1;
		}
		int i = 0;
		int m = haystack.length();
		int n = needle.length();

		while (i < m) {
			int j = 0;

			// Store the value of i, so that it is not lost
			int ans = i;

			while (j < n && i < m && haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			}

			// Needle found in Haystack
			if (j == n) {
				return ans;
			}

			// Reached end of haystack. Needle not found
			else if (i == m) {
				return -1;
			}

			// Not the end of either.
			else {
				i = ans + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		StrStr obj = new StrStr();
		String haystack = "hello";
		String needle = "ll";
		System.out.println("Index of \'" + needle + "\' in \'" + haystack + "\' = " + obj.strStr(haystack, needle));
	}

}
