#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
First we count each character in p, then we slide a window over s and update their frequency.
We use match to track how many characters have the exact matching count — it increases or decreases when frequency hits 0 or crosses zero.
If all characters match, we add that starting index to the result.
*/
class Solution{
public:
    vector<int> findAnagrams(string s, string p){
        int match = 0;
        int m = s.length();
        int n = p.length();
        unordered_map<char, int> map;
        vector<int> result;

        for(char c : p) map[c]++;

        for(int i=0; i<m; i++){
            char inS = s[i];
            if(map.find(inS) != map.end()){
                map[inS]--;
                if(map[inS] == 0) match++;
                else if(map[inS] < 0) match--;
            }
            if(i >= n){
                char outS = s[i - n];
                if(map.find(outS) != map.end()){
                    map[outS]++;
                    if(map[outS] == 1) match--;
                    else if(map[outS] <= 0) match++;
                }
            }
            if(match == map.size()) result.push_back(i-n+1);
        }
        return result;
    }
};
