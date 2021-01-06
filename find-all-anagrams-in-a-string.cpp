//Time - O(n)
//Space - O(1)

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> ret;
        if(s == "" || p == "" || p.length()>s.length()) return ret;
        unordered_map<char,int> mp;
        
        for(auto c:p){
            mp[c]++;
        }
        
        int match = 0;
        
        for(int i=0;i<s.length();i++){
            
            if(mp.find(s[i]) != mp.end()){
                mp[s[i]]--;
                if(mp[s[i]] == 0){
                    match++;
                }
            }
            
            int outIdx = i-p.length();
            if(outIdx>=0){
                if(mp.find(s[outIdx])!=mp.end()){
                    mp[s[outIdx]]++;
                    if(mp[s[outIdx]]>0) match--;
                }
            }
            
            if(match == mp.size()){
                ret.push_back(i-p.length()+1);
            }
        }
        
        return ret;
    }
};