// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        int sl = s.length();
        int pl = p.length();

        unordered_map<char, int> mp;
        for (char c:p){
            mp[c]++;
        }
        vector<int> res;
        int count = 0;
        for (int i = 0; i<sl; i++) {
            char in = s[i];
            // in
            if (mp.find(in) != mp.end()) {
                mp[in]--;
                if (mp[in] == 0) count++;
            }
            // out
            if (i>=pl) {
                char out = s[i-pl];
                if (mp.find(out) != mp.end()) {
                    mp[out]++;
                    if (mp[out] == 1) count--;
                }
            }
            if (mp.size() == count){
                res.push_back(i-pl +1);
            }
        }
        return res;
    }
};