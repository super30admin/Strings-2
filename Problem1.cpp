// Problem name: Find the Index of the First Occurrence in a String
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We first calculate the patternHash for the pattern string and calculate
// maxP that can be contributed by the window's first character
// 2. Now we use the rolling hash algorithm to calculate the hash of incoming
// character and remove the value for the outgoing character, if the anywhere
// our running hash is equal to pattern hash, we return the index
// 3. There can be collisions with this, so we can also check the substring
// again to prevent spurious hits but it will take the complexity to O(mxn), or
// we use double hash to prevent it or better we use KMP algorithm here
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int strStr(string haystack, string needle) {
    int m = (int)haystack.size();
    int n = (int)needle.size();
    int MOD = 1e9 + 7;
    if (n > m)
      return -1;
    long long maxP = 1;
    long long patternHash = 0;
    for (int i = 0; i < n; i++) {
      int chV = needle[i] - 'a' + 1;
      patternHash = ((patternHash * 26) + chV) % MOD;
      maxP = (maxP * 26) % MOD;
    }

    long long hash = 0;
    for (int i = 0; i < m; i++) {
      // incoming char v
      int inV = haystack[i] - 'a' + 1;
      hash = ((hash * 26) + inV) % MOD;
      if (i >= n) {
        int outV = haystack[i - n] - 'a' + 1;
        hash = ((hash - maxP * outV) % MOD + MOD) % MOD;
      }
      if (hash == patternHash) {
        return i - n + 1;
      }
    }
    return -1;
  }
};
