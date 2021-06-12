// Time Complexity :O(s+p)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        unordered_map<char,int> hMap;
        for(auto c : p){
            hMap[c]++;
        }
        int slow = 0;
        int fast = 0;
        int match = 0;
        vector<int> result;
        while(fast < s.length() ){
            
            //in;
            char c = s[fast];
            if(hMap.count(c)){
                hMap[c]--;
                if(hMap[c] == 0)match++;
            }
            //else match--;
            
            if(fast >= p.length()){
                char c = s[slow];
                if(hMap.count(c)) {
                    hMap[c]++;
                    if(hMap[c] == 1) match--;
                }
                slow++;
            }
            cout<<match<<endl; 
            if(match == hMap.size()){
                result.push_back(slow);
            } 
            fast++;
        }
        return result;
    }
};