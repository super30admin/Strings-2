# -*- coding: utf-8 -*-
"""
TC:O(P+S) where P is the length of p string and S is the length of S string
SC:O(1) as the space is constant (26+26 characters in total)
"""
import collections

class Solution:
    def findAnagrams(self, s: str, p: str):
       #edge case
        if len(s) < len(p) or len(s) == 0:
            return []
        
        p_freq = collections.Counter(p)
        p_counter = len(p_freq)
        begin = end = 0
        #resultant list
        ans = []
        
        while end < len(s):
            # find substring that contains string p's chars
            endchar = s[end]
            if endchar in p_freq:
                p_freq[endchar] -=1
                if p_freq[endchar] == 0: 
                    p_counter -=1
            end += 1
            
            while (p_counter == 0):
				# found the anagram, add to solution
                if end - begin == len(p):
                    ans.append(begin)
                
				# traverse from the left again to minimize the substring
                beginchar = s[begin]
                if beginchar in p_freq:
                    p_freq[beginchar] +=1
                    if p_freq[beginchar] > 0: 
                        p_counter += 1
                begin += 1
        
        return ans
        

S = Solution()
print(S.findAnagrams("cbaebabacd","abc"))