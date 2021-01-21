# Find All Anagrams in a String

# Time Complexity : O(Ns+Np) where N is the length of string
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes, with Runtime: 104 ms and Memory Usage: 15.1 MB
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# Approach
"""
Using Hashmap which contains character of given string p. 
A Sliding window technique is used where Incomiing character of given/input string s
if is present in hashmap the count of character in hashmap is reduced and if its zero 
variable match which is intialized to zero is incremented simultaneously check on
outgoing character is done and count in hashmap is incremented and if its equal to 1
match is reduced. If match is equal to the size of hashmap an anagram is found and
the count is incremented.

"""
def findAnagrams(self, s: str, p: str) -> List[int]:
        result=[]
        if(s==None or len(s)==0): # Base Case
            return result
        l, r , count = 0, 0, len(p)
        map_s = collections.defaultdict(int) # Hashmap for p
        for i in p : # Building Hashmap such that [a 1,b 1, c 1]
            map_s[i]+=1

        while r < len(s): 
            if map_s[s[r]]>0: # Incoming
                count-=1 
            map_s[s[r]]-=1
            r+=1
            if count==0: # Outgoing
                result.append(l)
            if r-l==len(p):
                if map_s[s[l]]>=0:
                    count+=1
                map_s[s[l]]+=1
                l+=1    
        return result

# Python Solution using ord() function
"""
Using ord() function which accepts a string of unit length as an argument and 
returns the Unicode equivalence of the passed argument. Two hashmaps are
maintained which keeps track of all 26 characters.

"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result=[]
        if(s==None or len(s)==0): # Base Case
            return result
        lp = len(p)
        map_s = [0] * 26
        map_p = [0] * 26
        for ch in p:
            map_p[ord(ch) - ord('a')] += 1
        for i in range(len(s)):
            map_s[ord(s[i]) - ord('a')] += 1
            if map_s == map_p:
                    result.append(i - lp + 1)
            if (i + 1) >= lp:
                map_s[ord(s[i - lp + 1]) - ord('a')] -= 1
            
        return result

