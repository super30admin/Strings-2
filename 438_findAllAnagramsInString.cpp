// Time Complexity : O(M+N) where M is the length of haystack and N is the length of needle
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> result;
        if(p.empty() || p.size() == 0 || s.empty() || s.size() == 0 )
            return result;
        unordered_map<char, int> map;
        int match = 0;
        for(int i=0; i<p.size(); i++){
            if(map.find(p[i]) != map.end()){
                map[p[i]] += 1;
            }
            else{
                map.insert({p[i], 1});
            }
        }
        for(int i=0; i<s.size(); i++){
            if(map.find(s[i]) != map.end()){
                int cnt = map[s[i]];
                cnt--;
                if(cnt == 0)
                    match++;
                map[s[i]] = cnt;
            }
            if(i >= p.size()){
                char out = s[i-p.size()];
                if(map.find(out) != map.end()){
                    int cnt = map[out];
                    cnt++;
                    if(cnt == 1)
                        match--;
                    map[out] = cnt;
                }
            }
            if(match == map.size())
                result.push_back(i-p.size()+1);
        }
        return result;
    }
};
