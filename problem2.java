//Problem2 - https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

public class problem2 {
    public int strStr(String haystack, String needle) {

        int needleLength = needle.length();
        int haystackLength = haystack.length();

        if (needleLength == 0) {
            return 0;
        }

        int needlePointer = 0;
        int haystackPointer = 0;

        while (haystackPointer < haystackLength) {

            if (haystack.charAt(haystackPointer) == needle.charAt(needlePointer)) {
                needlePointer++;
            } else {
                haystackPointer = haystackPointer - needlePointer;
                needlePointer = 0;
            }

            haystackPointer++;

            if (needlePointer == needleLength) {

                return (haystackPointer - needleLength);

            }

        }

        return -1;

    }
}
