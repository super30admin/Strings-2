// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using hashmap to store the freq of the chars in p. Iterate the string s using
// sliding window and keep checking the incoming and outgoing element if they are present in the
// map and calculate the match count. 

// 28. Find the Index of the First Occurrence in a String

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int strStr(string haystack, string needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        while(i <= m - n){
            if(haystack[i] == needle[0]){
                int k = i;
                int j = 0;
                while(haystack[k] == needle[j]){
                    k++;
                    j++;
                    if(j == n){
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }
};