//Using substring
//Time Complexity O(hn) - both the lengths as every time we are iterating needle in haystack
//Space Complexity: O(1)


class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())return 0;
        int low = 0;
    for(int cursor = low; cursor < haystack.length() - needle.length() + 1; cursor++){
            if(haystack.substring(cursor,cursor + needle.length()).equals(needle))return cursor;
        }
        return -1;
    }
}
