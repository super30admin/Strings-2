
/**
 * Finds the first index of the needle string in the haystack string.
 * Iterates through haystack and checks substrings of needle's length for equality.
 * Returns the starting index if found, otherwise returns -1.
 */
// Time Complexity: O((N - M + 1) * M), where N = haystack length and M = needle length
// Space Complexity: O(1), ignoring substring's internal space since it can be optimized
public class FindIndexOfFIrstOccuranceOfString {
    public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length(); 
        int needleLength = needle.length(); 

        for(int i = 0; i <= haystackLength - needleLength ; i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                if(haystack.substring(i,i+needle.length()).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
}
