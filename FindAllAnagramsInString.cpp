// Time Complexity : O(N) N-->length of string s
// Space Complexity : O(M) M->length of string p
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//This problem is solved using sliding window approach and using extra space.

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        unordered_map<char,int> map;
        vector<int> res;
        for(auto ch:p){
            map[ch]++;
        }
        int match = 0;
        for(int i=0;i<s.length();i++){
         if(map.find(s[i])!=map.end()){
             map[s[i]]--;
             if(map[s[i]] == 0){
                 match++;
             }
         }
         if(i>=p.length()){
             if(map.find(s[i-p.length()])!=map.end()){
                 map[s[i-p.length()]]++;
                 if(map[s[i-p.length()]] ==1)
                    match--;
             }
         }
            if(match == map.size()){
              res.push_back(i-p.length()+1);
            }
        }
        return res;

    }
};
