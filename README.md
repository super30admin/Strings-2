# Strings-2


## Problem1 
Implement strStr() (https://leetcode.com/problems/implement-strstr/)

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Code: 
```c++
    int strStr(string haystack, string needle) {
        for (int i = 0; ; ++i) {
            for (int j = 0; ; ++j) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle[j] != haystack[i + j]) {
                    break;
                }
            }
        }
    }
```

## Problem2 

Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Code : 
```c++
    vector<int> findAnagrams(string s, string p) 
    {
        vector<int> freq_p(26), freq_s(26);
        for(auto &it:p) freq_p[it-'a']++;

        int low=0;
        vector<int> res;
        for(int high=0; high<s.size(); high++)
        {
            freq_s[s[high]-'a']++;
            if((high-low+1==p.size()) && (freq_p==freq_s))
                res.push_back(low);

            if(high-low+1 >= p.size())
            {
                freq_s[s[low]-'a']--;
                low++;
            }
        }
        return res; 
    }
```