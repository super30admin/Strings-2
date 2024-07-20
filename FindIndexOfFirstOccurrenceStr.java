/***
 TC - O(m * n)
 SC - O(1)
 */
class FindIndexOfFirstOccurrenceStr {
    public int strStr(String haystack, String needle) {

        if(haystack == null || haystack.length() == 0 || needle.length() > haystack.length())
            return -1;

        if(needle.length() == 0)
            return 0;

        int n = haystack.length();
        int m = needle.length();

        for(int i =0 ; i < n; i++) {
            for(int j =0; j < m;) {
                if(i + j == n)
                    return -1;

                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                else
                    j++;

                if(j == m)
                    return i;
            }
        }

        return -1;
    }
}