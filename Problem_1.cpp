28. Find the Index of the First Occurrence in a String

//bruteforce solution

class Solution {
public:
    int strStr(string haystack, string needle) {
        int m = haystack.size();
        int n = needle.size();
        int i=0;

        if (m<n) return -1;
 
        while(i <= (m-n)) { // TC O(nm) SC O(1)
            if(haystack[i] == needle[0]) {
                int k = i; // k is on haystack
                int j = 0; // j is on pattern/needle
                while(haystack[k] == needle[j]) {
                        j++;k++;
                    if(j == n) return i;
                }
            }
            i++;
        }
        return -1;
    }
};

