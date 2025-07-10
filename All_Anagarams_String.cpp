// Time Complexity : O(n+m)
// Space Complexity : O(1)
#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int>ans;
        if(s.length()==0 || p.length()==0 ){
            return ans;
        }
        unordered_map<char,int>mp;
        int m = p.length(),n=s.length();
        for(int i=0;i<m;i++){
            mp[p[i]]++;
        }
        int match=0;
        for(int i=0;i<n;i++){
            if(mp.find(s[i])!=mp.end()){
                mp[s[i]]--;
                if(mp[s[i]]==0)
                    match++;
            }
            if(i >= m){
                if(mp.find(s[i-m])!=mp.end()){
                    mp[s[i-m]]++;
                    if(mp[s[i-m]]==1){
                        match--;
                    }
                }
            }
            if(match==mp.size()){
                ans.push_back(i - m + 1);
            }
        }
        return ans;
    }
};