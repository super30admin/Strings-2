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
    int strStr(string haystack, string needle) {
        if(needle.size()==0) return 0;
        vector<int> lps;
        lps=lpsFinder(needle);
        
        int i=0;
        int j=0;
        
        while(i<haystack.size())
        {
            if(haystack[i]==needle[j])
            {
                i++;
                j++;
                if(j==needle.size())
                {
                    return i-needle.size();
                }
            }
            else if(haystack[i]!=needle[j] && j>0)
            {
                j=lps[j-1];
            }
            else if(haystack[i]!=needle[j] && j==0)
            {
                i++;
            }
        }
        return -1;
    }
    
    vector<int> lpsFinder(string needle)
    {
        vector<int> lps(needle.size());
        int n=needle.size();
        
        int i=1;
        int j=0;
        
        lps[0]=0;
        while(i<n)
        {
            if(needle[i]==needle[j])
            {
                j++;
                lps[i]=j;
                i++;
            }
            else if(needle[i]!=needle[j] && j>0)
            {
                j=lps[j-1];
            }
            else if(needle[i]!=needle[j] && j==0)
            {
                lps[i]=0;
                i++;
            }
        }
        
        for(auto &c :lps)
        {
            cout<<c<<endl;
        }
        return lps;
    }
};