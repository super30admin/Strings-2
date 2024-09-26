public class ImplementStrstr {
    //tc : O(m*n); m = len of haystack; n = len of needle
    //sc = O(1)
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0 || needle == null)
            return 0;
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i < m; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                int k = i + 1;
                while (j < n && k < m) {
                    if (needle.charAt(j) == haystack.charAt(k)) {
                        j++;
                        k++;
                    }
                    else
                        break;
                }
                if (j == n) return i;
                if (k == m) return -1;
            }
        }
        return -1;
    }
}
