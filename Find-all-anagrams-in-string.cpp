// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using hashmap to store the freq of the chars in p. Iterate the string s using
// sliding window and keep checking the incoming and outgoing element if they are present in the
// map and calculate the match count. 

// 438. Find All Anagrams in a String

#include<bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> findAnagrams(string s, string p)
    {
        int n = p.length();
        vector<int> result;
        if (p.length() > s.length())
            return result;
        unordered_map<char, int> mp;
        int start = 0, end = 0;
        int match = 0;
        for (auto i : p)
        {
            mp[i]++;
        }
        for (int i = 0; i < s.length(); i++)
        {
            char in = s[i];
            // in
            if (mp.find(in) != mp.end())
            {
                int count = mp[in];
                count--;
                if (count == 0)
                {
                    match++;
                }
                mp[in] = count;
            }
            // out
            if (i >= n)
            {
                char out = s[i - n];
                if (mp.find(out) != mp.end())
                {
                    int count = mp[out];
                    count++;
                    if (count == 1)
                    {
                        match--;
                    }
                    mp[out] = count;
                }
            }
            if (match == mp.size())
            {
                result.push_back(i - n + 1);
            }
        }
        return result;
    }
};