// Time Complexity : O(m + n), m -> Length of haystack, n -> Length of needle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class StrStr {
	/********************* Compare *********************/
	// Time Complexity : O(mn), m -> Length of haystack, n -> Length of needle
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int strStrBruteForce(String haystack, String needle) {
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

	/********************* Knuth-Morris-Pratt Algorithm *********************/
	// Time Complexity : O(m + n), m -> Length of haystack, n -> Length of needle
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}

		if (haystack == null || haystack.length() < needle.length()) {
			return -1;
		}

		int[] lps = lps(needle);

		int i = 0;
		int j = 0;
		int m = haystack.length();
		int n = needle.length();

		while (i < m) {
			char ch_h = haystack.charAt(i);
			char ch_n = needle.charAt(j);

			if (ch_h == ch_n) {
				i++;
				j++;
			}

			if (j == n) {
				return i - n;
			} else {
				if (j > 0) {
					j = lps[j];
				} else {
					i++;
				}
			}
		}
		return -1;
	}

	private int[] lps(String needle) {
		int[] lps = new int[needle.length()];
		int i = 1;
		int j = 0;

		while (i < needle.length()) {
			char chi = needle.charAt(i);
			char chj = needle.charAt(j);
			// Equal
			if (chi == chj) {
				j++;
				lps[i] = j;
				i++;
			} else {
				// Not equal, j > 0
				if (j > 0) {
					j = lps[j - 1];
				} else {
					// Not equal, j = 0
					lps[i] = 0;
					i++;
				}
			}
		}

		return lps;
	}

	public static void main(String[] args) {
		StrStr obj = new StrStr();
		String haystack = "hello";
		String needle = "ll";
		System.out.println("Index of \'" + needle + "\' in \'" + haystack + "\' = " + obj.strStr(haystack, needle));
	}

}
