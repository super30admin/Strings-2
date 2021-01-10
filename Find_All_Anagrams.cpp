// Time Complexity : O(N) where N is the length of s
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> result;
        if(s=="" || s.length()==0){
            return result;
        }
        unordered_map<char,int> map;
        for(int i=0;i<p.length();i++){
            char c = p[i];
            if(map.find(c)!=map.end()){
                map[c] = map[c]+1;
            }
            else{
                map.insert(pair<char,int>(c,1));
            }
        }
        int match = 0;
        for(int i=0;i<s.length();i++){
            char c = s[i];
            if(map.find(c)!=map.end()){
                int cnt = map[c];
                cnt--;
                if(cnt==0){
                    match++;
                }
                map[c] = cnt;
            }
            if(i>=p.length()){
                char o = s[i-p.length()];
                if(map.find(o)!=map.end()){
                    int cnt = map[o];
                    cnt++;
                    if(cnt>0){
                        match--;
                    }
                    map[o] = cnt;
                }
            }
            if(match==map.size()){
                result.push_back(i - p.length()+1);
            }
        }
        return result;
    }
};
