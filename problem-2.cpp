// https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Time Complexity : O(n+m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Declare a hashset to get the frequency of p.
// On s, perform a sliding windows of size p, and check if the frequencies are matching.

class Solution {
    public:
        vector<int> findAnagrams(string s, string p) {
            vector<int> ans; vector<int> sFreq(26,0); vector<int> pFreq(26,0);
            int n = s.length(); int m = p.length();
            if (n < m) return ans;
            for(auto i:p){
                pFreq[i-'a']++;
            }
            for(int i=0; i<m; i++){
                sFreq[s[i] - 'a']++;
            }
            if(pFreq == sFreq) ans.push_back(0);
            for(int i=m; i<n; i++){
                sFreq[s[i] - 'a']++;
                sFreq[s[i-m] - 'a']--;
                if(pFreq == sFreq) ans.push_back(i-m+1);
            }
            return ans;
        }
    };