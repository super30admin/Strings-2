
/*
 TC-O(N*M) and SC-O(1)
* */
public class HaystackNeedleSubString {

    public int strStr(String haystack, String needle) {
        int i = haystack.length();
        int j = needle.length();

        // If needle is empty, return 0 (per problem statement)
        if (j == 0) {
            return 0;
        }

        // If needle is longer than haystack, return -1
        if (j > i) {
            return -1;
        }

        // Outer loop: Slide the window of size `needle.length()` over `haystack`
        for (int m = 0; m <= i - j; m++) { // `m` goes from 0 to i - j
            boolean match = true;

            // Inner loop: Compare the substring of haystack with needle
            for (int n = 0; n < j; n++) {
                if (haystack.charAt(m + n) != needle.charAt(n)) {
                    match = false; // If any character doesn't match, set match to false and break
                    break;
                }
            }

            // If a match is found, return the starting index `m`
            if (match) {
                return m;
            }
        }

        // If no match is found, return -1
        return -1;

    }
}
