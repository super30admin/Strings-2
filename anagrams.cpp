// Sliding window
// Time Complexity : O(mn); m length of p; n length of s 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

// 1. Maintain hashmap of chars in p. Iterate through s and once a char matches, increase the window to check if all elements of p are present
// 2. For this, decrement count of chars of p and remove entry once count=0
// If yes, add start index to result, if no then reset end

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> result;
        if(s.size()==0 || p.size()==0)
            return result;
        map<char,int> hashmap, hashmap_bkp;
        for(char c: p){
            if(hashmap.find(c) == hashmap.end())
                hashmap[c] = 1;
            else
                hashmap[c]++;
        }
        hashmap_bkp = hashmap;
        int start = 0, end=0, count=0;
        while(end<s.size()){
            if(hashmap.find(s[end]) != hashmap.end()){
                start = end;
                while(end-start<p.size() && hashmap.find(s[end]) == hashmap.end()){
                    hashmap[s[end]]--;
                    if(hashmap[s[end]] == 0)
                        hashmap.erase(s[end]);
                    end++;
                }
                if(hashmap.size() == 0)
                    result.emplace_back(start);
                else
                    end = start+1;
                hashmap = hashmap_bkp;
            }
            else{
                end++;
            }
        }
        return result;
    }
};