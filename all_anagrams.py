# Time Complexity :
# O(N)  - Size of the string s

# Space Complexity :
# O(1) - There is no auxillary space being allocated

# Did this code successfully run on Leetcode :
#Yes

#We store the frequency of each character in string p in a frequency map
#We then go over every sub-string of length of (p) in (s) and check if they are anagrams. If it is, we store the location
#Anagram check is happened by checking frequency of characters in the substrings.
#The freuency of every substring in s is built as a rolling freuency map - when we go through each new character, we reduce the frequency of the outgoing characgter and increase the frequency of the incoming character. In this way, the process of building the frequency map of a new substring is O(1)


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        p1 = 0
        p2 = len(p) -1
        return_locs = []
        freq1 = {}
        freq2= {}
        
        for i in range(0,26):
            freq2[chr(ord('a')+i)]  = 0

        for c1 in p :
            if c1 in freq1 :
                freq1[c1] += 1
            else :
                freq1[c1] = 1

        for c in s[p1:p2+1] :
            if c in freq2 :
                freq2[c] += 1
            else :
                freq2[c] = 1

        while (p2 < len(s)):
            if self.is_anagram(freq2,freq1):
                return_locs.append(p1)
            p1 += 1
            p2 += 1

            if p2 < len(s):
                freq2[s[p1-1]] -= 1
                freq2[s[p2]] += 1

        return return_locs

    def is_anagram(self,freq2,freq1):
        for key,values in freq1.items():
            if values != 0 and values != freq2[key]:
                return False
        return True
