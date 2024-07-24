// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0; // If needle is empty, return 0
        if (haystack.length() < needle.length()) return -1;
        int start = 0;
        int first = 0;
        int second = 0;
        while(first<haystack.length() && second<needle.length()) {
            if(haystack.charAt(first) == needle.charAt(second)) {
                if(second == 0) start = first;
                if(second == needle.length()-1) return start;
                second++;
                first++;
            } else {
                second = 0;
                first = start+1;
                start = first;
            }
        }
        return -1;
    }
}*/

class Solution {
  public int strStr(String haystack, String needle) {
    int m = haystack.length();
    int n = needle.length();

    if (n == 0) return 0;
    if (m < n) return -1;

    for(int i = 0; i<=m-n; i++) {
      int j = 0;
      int start = i;
      while(j<n && haystack.charAt(i) == needle.charAt(j)) {
        i++;
        j++;
      }
      if(j==n) return start;
      i = start;
    }
    return -1;
  }
}