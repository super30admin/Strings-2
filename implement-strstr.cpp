// Time Complexity : O(m+n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <string>
#include <vector>

int strStr(std::string haystack, std::string needle) {
    int i = 0;
    int j = 0;
    int n = haystack.length();
    int m = needle.length();

    if (m == 0) return 0;

    std::vector<int> lps = calculateLPS(needle);

    while (i < n) {
        if (haystack[i] == needle[j]) {
            i++;
            j++;
        }

        if (j == m) return i - j;

        if (i < n && haystack[i] != needle[j]) {
            if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
    }

    return -1;
}

std::vector<int> calculateLPS(std::string needle) {
    int j = 0;
    int i = 1;
    int m = needle.length();
    std::vector<int> lps(m, 0);

    while (i < m) {
        if (needle[i] == needle[j]) {
            lps[i] = ++j;
            i++;
        } else {
            if (j == 0) {
                lps[i] = j;
                i++;
            } else {
                j = lps[j - 1];
            }
        }
    }

    return lps;
}