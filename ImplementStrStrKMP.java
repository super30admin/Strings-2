//Time Complexity : O(n+m) //n is haystack len and m is needle len
//Space Complexity :O(m) //map size
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

/*
*1. Refer KMP algorithm
*/
public class ImplementStrStr {
	public int strStr(String haystack, String needle) {

		if (needle == null || needle.length() == 0)
			return 0;

		int nlen = needle.length();
		int hlen = haystack.length();

		int needlep = 0;
		int hayp = 0;

		int[] lps = getLps(needle);

		while (hayp < hlen) {
			if (needle.charAt(needlep) == haystack.charAt(hayp)) {
				hayp++;
				needlep++;
				if (needlep == nlen) {
					return hayp - nlen;
				}
			} else if (needle.charAt(needlep) != haystack.charAt(hayp) && needlep > 0) {
				needlep = lps[needlep - 1];
			} else {
				hayp++;
			}
		}

		return -1;
	}

	private int[] getLps(String needle) {
		int[] lps = new int[needle.length()];

		int firstp = 0;
		int currp = 1;

		lps[0] = 0;
		while (currp < needle.length()) {
			if (needle.charAt(currp) == needle.charAt(firstp)) {
				firstp++;
				lps[currp] = firstp;
				currp++;
			} else if (needle.charAt(currp) != needle.charAt(firstp) && firstp > 0) {
				firstp = lps[firstp - 1];
			} else {
				lps[currp] = firstp;
				currp++;
			}
		}
		return lps;
	}

	public static void main(String[] args) {
		System.out.println(new ImplementStrStr().strStr("hello", "ll"));
	}

}
