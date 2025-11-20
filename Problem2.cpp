// Problem name: Find all anagrams in a string
// Time Complexity : O(n)
// Space Complexity : O(1) map has only 26 chars
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We first make a frequency map of p and start our sliding window
// 2. if we encounter a character, that is in our map, we reduce it, if it
// becomes zero, we decrement our unique pointer as well
// 3. If we reach our window size, and our uniq is 0, then we push the index,
// increment the s[i] in our map if it exists, and if it is one, then increment
// our uniq as well, then move our i pointer
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<int> findAnagrams(string s, string p) {
    unordered_map<int, int> u;
    for (auto it : p) {
      u[it]++;
    }
    int uniq = (int)u.size();
    int i = 0;
    int j = 0;
    int k = (int)p.size();
    int n = (int)s.size();
    vector<int> res;
    while (j < n) {
      if (u.count(s[j]) > 0) {
        u[s[j]]--;
        if (u[s[j]] == 0) {
          uniq--;
        }
      }
      if (j - i + 1 == k) {
        if (uniq == 0) {
          res.push_back(i);
        }
        if (u.count(s[i]) > 0) {
          u[s[i]]++;
          if (u[s[i]] == 1) {
            uniq++;
          }
        }
        i++;
      }
      j++;
    }
    return res;
  }
};
