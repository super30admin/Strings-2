package Strings-2;
// TC: O(m)
// SC: O(1)
public class Problem1 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (n > m)
          return -1;
    
        int prime = 101;
        int positionFac = 1;
        for (int i = 0; i < n - 1; i++) {
          positionFac = (positionFac * 26) % prime;
        }
    
        int needleHash = 0;
        for (int i = 0; i < n; i++) {
          char c = needle.charAt(i);
          needleHash = (needleHash * 26 + (c - 'a' + 1)) % prime;
        }
        int currHash = 0;
        for (int i = 0; i < m; i++) {
          // outgoing character
          if (i >= n) {
            char outgng = haystack.charAt(i - n);
            currHash = currHash - (outgng - 'a' + 1) * positionFac;
          }
    
          // incoming character
          char incoming = haystack.charAt(i);
          currHash = (currHash * 26 + (incoming - 'a' + 1)) % prime;
    
          if (currHash < 0)
            currHash = currHash + prime;
    
          if (currHash == needleHash) {
            boolean found = true;
            if (i < n - 1)
              found = false;
            else {
              if (found) {
                for (int j = 0; j < n; j++) {
                  if (needle.charAt(j) != haystack.charAt(i - (n - 1) + j)) {
                    found = false;
                    break;
                  }
                }
              }
            }
    
            if (found) {
              return i - (n - 1);
            }
          }
        }
        return -1;
      }
}
