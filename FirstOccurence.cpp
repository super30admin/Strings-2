#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We take two pointers i and j one for the haystack and other for needle
while the difference of their lengths is greater than i we check if the 
letters are equal or not and then if they are equal at every stage we return i
else return -1
*/
class Solution{
public:
    int strStr(string haystack, string needle){
        int x = haystack.length();
        int y = needle.length();
        int i = 0, j = 0;
        while(i <= x-y){
            if(haystack[i] == needle[j]){
                int k = i;
                while(haystack[k] == needle[j]){
                    k++;
                    j++;
                    if(j == y) return i;
                }
            }
            i++;
            j=0;
        }
        return -1;
    }
};
