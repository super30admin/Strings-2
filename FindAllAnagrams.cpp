//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> result;
        
        map<char,int> mp;
        
        for(auto &c : p)
        {
            if(mp.find(c)==mp.end())
            {
                mp[c]=0;
            }
            mp[c]++;
        }
        
        int match=0;
        for(int i=0;i<s.size();i++)
        {
            char in=s[i];
            if(mp.find(in)!=mp.end())
            {
                mp[in]--;
                if(mp[in]==0)
                {
                    match++;
                }
            }
            
            if(i>=p.size())
            {
                char out= s[i-p.size()];
                if(mp.find(out)!=mp.end())
                {
                    mp[out]++;
                    if(mp[out]==1)
                    {
                        match--;
                    }  
                }
                                  
            }
            if(match == mp.size())
            {
                result.push_back(i-p.size()+1);
            }
        }
        
        return result;
    }
};