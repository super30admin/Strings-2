//Time Complexity : O(N^2) for Brute Force,O(M + N) for KMP Algorthim

//Space Complexity : O(1) for Brute Force,O(N) for KMP Algo
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
 * We have used KMP Algorthim for finding first index of String.
 * None of library implemenation of stsstr utilize any of pattern matching algos
 * Other Algos can be used for implementing strStr function
*/
public class StrStr {
	static boolean isBruteForce = false;

	public int strStr(String needle, String haystack) {
		if (isBruteForce)
			return bruteForce(needle, haystack);
		return kmp(needle, haystack);
	}

	public int bruteForce(String needle, String haystack) {
		int size1 = haystack.length();
		int size2 = needle.length();

		if (size2 == 0)
			return 0;
		int i = 0;
		while (i < size1) {
			int j = 0;
			if (needle.charAt(j) == haystack.charAt(i)) {
				int temp = i;
				while (temp < size1 && j < size2) {
					if (haystack.charAt(temp) != needle.charAt(j))
						break;
					temp++;
					j++;
				}
				if (j == size2)
					return i;
			}
			i++;
		}
		return -1;
	}

	public int kmp(String needle, String haystack) {
		int m = haystack.length(), n = needle.length();
		if (n == 0)
			return 0;
		int[] lps = preCompute(needle);
		int i = 0, j = 0;
		while (i < m) {
			char ch1 = haystack.charAt(i);
			char ch2 = needle.charAt(j);
			if (ch1 == ch2) {
				i++;
				j++;
			}
			if (j == n) {
				return i - n;
			} else if (i < m && ch1 != ch2) {
				if (j > 0) {
					j = lps[j - 1];
				} else if (j == 0) {
					i++;
				}
			}

		}
		return -1;
	}

	public int[] preCompute(String needle) {
		int n = needle.length();
		int lps[] = new int[n];
		lps[0] = 0;
		int i = 1, j = 0;
		while (i < n) {
			char ch1 = needle.charAt(i);
			char ch2 = needle.charAt(j);
			if (ch1 == ch2) {
				j++;
				lps[i] = j;
				i++;
			} else if (ch1 != ch2) {
				if (j > 0) {
					j = lps[j - 1];
				} else if (j == 0) {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	public static void main(String args[]) {
		StrStr str = new StrStr();

		String needle = "Sharma";
		String haystack = "My name is Sachin Sharma";

		int index = str.strStr(needle, haystack);

		System.out.println("Position of " + needle + " in " + haystack + " is:" + index);
	}
