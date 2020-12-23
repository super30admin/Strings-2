class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        int match = 0;
        vector<int> res;
        unordered_map<char, int> map;
        for(char c : p) {
            map[c]++;
        }
        for(int i = 0; i < s.size(); i++) {
            //incoming
            if(map.find(s[i]) != map.end()) {
                map[s[i]]--;
                if(map[s[i]] == 0)
                    match++;
            }
            //outgoing
            if(i > p.size()-1 && map.find(s[i-p.size()]) != map.end()) {
                map[s[i-p.size()]]++;
                if(map[s[i-p.size()]] == 1) 
                    match--;
            }
            if(match == map.size())
                res.push_back(i-p.size()+1);
        }
        return res;
    }
};
