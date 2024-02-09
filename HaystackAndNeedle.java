public class HaystackAndNeedle {
    public int strStr(String haystack, String needle) {
//        return strStrUsingRabinKarp(haystack, needle);
        return strStrTwoPointers(haystack, needle);
    }

    // TC: O(M + N) where M is length of haystack and N is length of needle
    // SC: O(1)
    private int strStrUsingRabinKarp(String haystack, String needle) {
        long needleHash = 0;
        for (char ch : needle.toCharArray()) {
            needleHash = needleHash * 26 + (ch - 'a' + 1);
        }
        long currHash = 0l;
        int k = needle.length();
        long r = (long)Math.pow(26, k - 1);
        for (int i = 0; i < haystack.length(); i++) {
            if (i >= k) {
                char out = haystack.charAt(i - k);
                currHash = currHash - (out - 'a' + 1) * r;
            }
            char in = haystack.charAt(i);
            currHash = currHash * 26 + (in - 'a' + 1);
            if (currHash == needleHash) {
                return i - k + 1;
            }
        }
        return -1;
    }

    // TC: O(M * N) where M is length of haystack and N is length of needle
    // SC: O(1)
    private int strStrTwoPointers(String haystack, String needle) {
        int hPointer = 0, nPointer = 0, start = 0;
        while (hPointer < haystack.length() && nPointer < needle.length()) {
            if (haystack.charAt(hPointer) == needle.charAt(nPointer)) {
                hPointer++;
                nPointer++;
            } else {
                nPointer = 0;
                start++;
                hPointer = start;
            }
            if (nPointer == needle.length()) {
                return start;
            }
        }
        return -1;
    }
}
