
// Time - O(2n)
// Space - O(1)



class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;

        int m = haystack.length();
        int n = needle.length();

        int i = 0;
        int j = 0;

        int [] lps = lps(needle);

        while(i < m) {

            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if(j == n) { // if it reaches end return the string from first index
                    return i - n;
                }
            } else if(haystack.charAt(i) != needle.charAt(j) && j > 0) {
                j = lps[j - 1]; // decrement j
            } else if(haystack.charAt(i) != needle.charAt(j) && j == 0) {
                i++; // increment i
            }
        }
        return -1;
    }

    private int [] lps(String needle) {

        int [] lps = new int[needle.length()];

        int j = 0;
        int i = 1;
        while(i < needle.length()) {
            if(needle.charAt(i) == needle.charAt(j)) { // case 0  - if the char matches increment j pointer and point i to j and increment i

                j++;
                lps[i] = j;
                i++;
            }
            else if(needle.charAt(i) != needle.charAt(j) && j > 0) { // case 1 - start decrementing j till it reaches 0th index

                j = lps[j - 1];

            }
            else if(needle.charAt(i) != needle.charAt(j) && j == 0) { // case 2 - reset i to 0 and increment i

                lps[i] = 0;
                i++;

            }
        }

        return lps;


    }

}