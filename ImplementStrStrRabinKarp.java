
public class ImplementStrStr {
	public int strStr(String haystack, String needle) {

		int nlen = needle.length();
		if (needle == null || nlen == 0)
			return 0;

		long needleHash = hash(needle);
		long haysHash = hash(haystack.substring(0, nlen));

		for (int i = nlen - 1; i < haystack.length(); i++) {
			if (i >= nlen) {
				haysHash = haysHash - (((long) Math.pow(26, nlen - 1)) * (haystack.charAt(i - nlen) - 'a' + 1));
				haysHash = (haysHash * 26) + (haystack.charAt(i) - 'a' + 1);
			}

			if (needleHash == haysHash) {
				return i - nlen + 1;
			}
		}

		return -1;
	}

	private long hash(String str) {
		long hash = 0;
		int n = str.length() - 1;
		for (int i = 0; i < str.length(); i++) {
			hash = hash + (((long) Math.pow(26, n--)) * (str.charAt(i) - 'a' + 1));
		}
		return hash;
	}

	public static void main(String[] args) {
		System.out.println(new ImplementStrStr().strStr("",""));
	}

}
