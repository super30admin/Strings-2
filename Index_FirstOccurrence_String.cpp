//Time Complexity : O(n+m)
//Space Complexity : O(1)
#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int strStr(string haystack, string needle) {
        int m = haystack.size(), n = needle.size();
        for (int i = 0; i <= m - n; i++) {
            int j = 0;
            while(j<n) {
                if (haystack[i + j] != needle[j]) {
                    break;
                }
                j++;
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }
};
