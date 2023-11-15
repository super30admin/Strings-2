#include<bits/stdc++.h>
using namespace std;

/*
Approach: Sliding window: We maintain a map of elem freq of p. Whenever we add an elem to sliding window then we cancel that out with the one in p (from map). If we cancel out all elems (freq=0 in map) then we say that the char has matched. Similarly, when we remove an elem from window, then we increase the freq in map. If the freq was previously then one char match has reduced so decrement. Also, we play with map for only those chars present in 'p'. Now if the chars matched == unique elems in 'p' then it is an anagram so store the start of window.
Time: O(m+n)    m=len of s, n=len of p
Works on leetcode: Yes
*/

void printArr(vector<int> arr) {
    for(int a: arr) {
        cout<<a<<" ";
    }
    cout<<endl;
}

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        unordered_map<char, int> hmap;
        for(char c: p) {
            hmap[c]++;
        }
        int matches=0;
        char c;
        vector<int> ans;
        int uniqueChars = hmap.size();
        for(int end=0,st=0; end<s.size(); end++) {
            c = s.at(end); 
            if(hmap.find(c) != hmap.end()) {
                hmap[c]--;
                if(hmap[c] == 0) {
                    matches++;
                }
            }
            if(end>=p.size()) {
                c = s.at(st);
                st++;
                if(hmap.find(c) != hmap.end()) {
                    hmap[c]++;
                    if(hmap[c] == 1) {
                        matches--;
                    }
                }
            }
            if(matches == uniqueChars) {
                ans.push_back(st);
            }
        }
        return ans;
    }
};

int main() {
    Solution S;
    printArr(S.findAnagrams("cbaebabacd","abc"));
}