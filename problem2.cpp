// Time Complexity :O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we store the characters of p in map and maintain a count of unique characters.
// we traverse over string s and do sliding window of p.length, we check if matched == count. and store the index accordingly


class Solution {
public:
    
    vector<int> findAnagrams(string s, string p) {
        int k = 0;
        unordered_map<char,int>map;
        int m = p.size();
        for(int i = 0;i<m;i++)
        {
            map[p[i]]++;
            if(map[p[i]]==1) k++;
        }
        int matched = 0;
        vector<int>ans;
        int n = s.size();
        for(int i = 0;i<n;i++)
        {
            map[s[i]]--;
            if(map[s[i]]==0) matched++;
            if(i>=m)
            {
                map[s[i-m]]++;
                if(map[s[i-m]]==1) matched--;
            }
            if(matched == k) ans.push_back(i-m+1);
        }
        return ans;
    }
};