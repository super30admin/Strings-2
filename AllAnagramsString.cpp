class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> answer;
        unordered_map<char, int> map;
        for(int i = 0; i < p.length(); i++){
            char c = p[i];
            map[c]++;
        }
        
        int match = 0;
        int slow = 0;
        for(int i = 0; i < s.length(); i++){
            // incoming
            char in = s[i];
            if(map.count(in)){
                map[in]--;
                if(map[in] == 0)
                    match++;
            }
            
            //outgoing
            if(i >= p.length()){
                char out = s[i - p.length()];
                if(map.count(out)){
                    map[out]++;
                    if(map[out] == 1)
                        match--;
                }
            }
            if(match == map.size())
                answer.push_back(i - p.length() + 1);
        }
        return answer;
    }
};