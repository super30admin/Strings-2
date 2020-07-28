//Time Comp: O(N+M)
//Space Comp: O(1)
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int>result;
        unordered_map<char, int>map;
        for(auto c: p) map[c]++;
        int i = 0;
        int j = 0;
        int count = p.size();
        while(j < s.size()){
            if(map[s[j++]]-- > 0) count--;
            while(count == 0){
                if(j - i == p.size()) result.push_back(i);
                if(map[s[i++]]++ == 0) count++;
            }
        }
        return result;
    }
};