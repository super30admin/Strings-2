//Time Complexity : O(M * N) 
//Space Complexity : O(1) 					
//Did this code successfully run on Leet code :Yes
//Any problem you faced while coding this :

// Not KMP solution
public class StrStr {
	public int strStr(String haystack, String needle) {

		int m = haystack.length();
		int n = needle.length();
		if (n > m)
			return -1;

		int i = 0;
		for (i = 0; i < m; i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int k = i;
				int j = 0;
				while (j < n && k < m && haystack.charAt(k) == needle.charAt(j)) {
					j++;
					k++;
				}
				if (j == needle.length()) {
					return i;
				}
			}
		}
		return -1;
	}
}

