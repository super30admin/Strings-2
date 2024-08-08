//time: O(s+p)
//space: O(p)
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if(p.length() > s.length()) return {};
        vector<int> result;
        unordered_map<char,int> umap;
        for(char c : p) {
            umap[c]++;
        }
        int p1 = 0, p2 = 0;
        int match = 0;
        while (p2 < s.length()) {
            if(p2 < p.length()) {
                if(umap.find(s[p2]) != umap.end()) {
                    umap[s[p2]]--;
                    if(umap[s[p2]] == 0) {
                        match++;
                    }
                }
                p2++;
            }
            else {
                //out
                if(umap.find(s[p1]) != umap.end()) {
                    umap[s[p1]]++;
                    if(umap[s[p1]] == 1) {
                        match--;
                    }
                }
                p1++;
                //in
                if(umap.find(s[p2]) != umap.end()) {
                    umap[s[p2]]--;
                    if(umap[s[p2]] == 0) {
                        match++;
                    }
                }
                p2++;
            }
            if(match == umap.size()) {
                result.push_back(p1);
            }
        }
        return result;
    }
};