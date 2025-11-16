class Solution {
    public int strStr(String haystack, String needle) {
        
        int[] lps = new int[needle.length()];

        preprocess(lps, needle);

        int i=0, j=0;

        while (i<haystack.length()) {

            char cI = haystack.charAt(i);
            char cJ = needle.charAt(j);

            if (cI == cJ) {
                j++;
                i++;
                if (j == needle.length()) {
                    return i-j;
                }
            } else if (cI != cJ && j>0) {
                j = lps[j-1];
            } else {
                i++;
            }


        }

        return -1;


    }

    public void preprocess(int[] lps, String needle) {

        int i=1, j=0;

        while (i<needle.length()) {

            char cI = needle.charAt(i);
            char cJ = needle.charAt(j);

            if (cI == cJ) {
                j++;
                lps[i] = j;
                i++;
            } else if (cI != cJ && j>0) {
                j = lps[j-1];
                lps[i] = j;
            } else if (cI != cJ && j == 0) {
                lps[i] = 0;
                i++;
            }

        }

    }
}
