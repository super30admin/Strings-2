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

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle)==0:
            return 0
        def lpsfun(needle):
            lps=[0*i for i in range(len(needle))]
            i,j=1,0
            lps[0]=0
            while i<len(needle):
                if needle[i]==needle[j]:
                    j+=1
                    lps[i]=j
                    i+=1
                elif needle[i]!=needle[j] and j!=0:
                    j=lps[j-1]
                elif needle[i]!=needle[j] and j==0:
                    lps[i]=0
                    i+=1
            return lps
        a=lpsfun(needle)
        p,q=0,0
        while p<len(haystack):
            if haystack[p]==needle[q]:
                p+=1
                q+=1
                if q==len(needle):
                    return p-q
            elif haystack[p]!=needle[q] and q!=0:
                q=a[q-1]
            elif haystack[p]!=needle[q] and q==0:
                p+=1
        return -1
                
            
                
                    
        
        

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

# Time Complexity = O(s+p)
# Space Complexity = O(1)


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        phash={}
        whash={}
        res=[]
        for i in p:
            if i not in phash:
                phash[i]=1
            else:
                phash[i]+=1
        match=0
        for i in range(len(s)):
            if s[i] in phash:
                c=phash[s[i]]
                c-=1
                phash[s[i]]=c
                if c==0:
                    match+=1
            if i>len(p)-1:
                if s[i-len(p)] in phash:
                    c=phash[s[i-len(p)]]
                    c+=1
                    phash[s[i-len(p)]]=c
                    if c==1:
                        match-=1          
            if match==len(phash):
                res.append(i-len(p)+1)
        return res
            
                        
                        
                    
                
        