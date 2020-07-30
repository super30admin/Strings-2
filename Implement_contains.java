//TC - O(M * N)
//SC - O(1)
class Solution1 {
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		int m = haystack.length();
		int n = needle.length();
		int i = 0;
		int j = 0;
		while (i < m - n + 1) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				int temp = i;
				while (temp < m && j < n && haystack.charAt(temp) == needle.charAt(j)) {
					if (haystack.charAt(temp) == needle.charAt(j)) {
						temp++;
						j++;
					}
				}
				if (j == n)
					return i;
			}
			i++;
			j = 0;
		}
		return -1;
	}
}