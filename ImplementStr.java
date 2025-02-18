// brute force solution is to match it with every starting letter and then search for the rest of the word lengthg
// two pointers to start matching from back to front?
// constraints: length is limited to 100,000 -> exhaustive solution type?

// edge cases:
// what to return when the string is empty? -> return 0
// TC: O(1) SC: O(1)

class Solution {

  public int strStr(String haystack, String needle) {
    int m = haystack.length();
    int n = needle.length();
    int i = 0;
    if (m == 0) return 0;

    while (i < m) {
      int j = 0;
      int temp = i;

      while (temp < m && j < n) {
        if (haystack.charAt(temp) != needle.charAt(j)) break;
        j++;
        temp++;
      }

      if (j == n) return i;
      i++;
    }

    return -1;
  }
}

// solution 2: KMP Algorithm
// TC: O(n) SC:O(m)

class Solution {

  public int strStr(String haystack, String needle) {
    int i = 0;

    int j = 0;

    int n = haystack.length();

    int m = needle.length();

    if (m == 0) return 0;

    int[] lps = lps(needle);

    while (i < n) {
      if (haystack.charAt(i) == needle.charAt(j)) {
        i++;

        j++;
      }

      if (j == m) return i - j;

      if (i < n && haystack.charAt(i) != needle.charAt(j)) { //reset j
        if (j > 0) { //reset j
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }

    return -1;
  }

  private int[] lps(String needle) {
    // len of prev longest prefix

    int j = 0;

    int i = 1;

    int[] lps = new int[needle.length()];

    lps[0] = 0;

    while (i < needle.length()) {
      if (needle.charAt(i) == needle.charAt(j)) {
        lps[i] = ++j;

        i++;
      } else {
        if (j == 0) {
          lps[i] = j;

          i++;
        } else {
          j = lps[j - 1];
        }
      }
    }

    return lps;
  }
}
