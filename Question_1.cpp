#include <iostream>
using namespace std;
int strStr(string haystack, string needle) {
    int m = needle.size(), n = haystack.size();
    int lps[m];
    memset(lps,0,sizeof(lps));
    int j = 0;
    for(int i=1;i<=m-1;i++){
        while(j>0&&needle[j]!=needle[i]) j = lps[j-1];
        if(needle[j]==needle[i]) j++;
        lps[i]=j;
    }
    int ptr = 0;
    for(int i=0;i<=n-1;i++){
        while(ptr>0&&haystack[i]!=needle[ptr]){
            ptr = lps[ptr-1];
        }
        if(needle[ptr]==haystack[i]) ptr++;
        if(ptr==m) return i-m+1;
    }
    return -1;
}
int main() {
    string haystack = "hello";
    string needle = "ll";
    int result = strStr(haystack, needle);
    cout << "Needle found at index: " << result << endl; // Output: 2
    return 0;
}
// // Time Complexity: O(n+m) where n is the length of haystack and m is the length of needle
// // Space Complexity: O(m) for the lps array
// // Did this code successfully run on Leetcode: Yes
// // Any problem you faced while coding this: No
// // Your code here along with comments explaining your approach in three sentences only
// // Preprocessed the needle to create the longest prefix-suffix (lps) array, which helps in skipping unnecessary comparisons. Then iterated through the haystack, using the lps array to efficiently match characters from the needle. If a complete match of the needle is found, returned the starting index; otherwise, returned -1 if no match exists.