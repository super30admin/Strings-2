-------------------------------- Find anagrams of the string ---------------------------------------------
# Time Complexity : n!+m*(n-k) n is the length of the s, m is the number of anagrams present and k is the length of p
# Space Complexity : O(m)
# Did this code successfully run on Leetcode: No(Time Limit Exceeded)
# Any problem you faced while coding this : No
# 
# First found all the anagrams and iterate through all anagrams, and found needle in my haystack I appended all the starting positions 
# into my result array 

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s)<len(p):
            return []
        anagrams = set()
        strings = list(p)
        def ang(p, temp):
            if not p:
                anagrams.add(temp)
            
            for i in range(len(p)):
                ang(p[:i]+p[i+1:], temp+p[i])
            
        ang(p, '')
        
        res = set()
        for j in anagrams:
            needle = j
            haystack = s
            
            n = len(haystack)
            k = len(needle)
            
            if n<k:
                continue
            
            for i in range(n-k+1):
                if haystack[i:i+k] == needle:
                    res.add(i)
        return res
        

-------------------------------- Find anagrams of the string ---------------------------------------------
# Time Complexity : O(n+K)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# First I created a dict with count of values in p. And I iterated through s using 2 pointers where my start and end pointer is at start of 
#string. If the end is in dict, then I will decrement dict element count and increment end pointer. if my end-start is equal to the length of the string
#append start pointer index to res. If my end == start, then increment both, else increment start variable and if the start is present in the dict
#then increment the dict of start value.
       
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if not s:
            return []
        res = []
        dp = Counter(p)
        
        start = 0
        end = 0
        while end<len(s):
            if s[end] in dp and dp[s[end]]>0:
                dp[s[end]] -=1
                end +=1
                if end-start == len(p):
                    res.append(start)
            elif start == end:
                start +=1
                end+=1
            else:
                dp[s[start]] +=1
                start +=1
                   
        return res