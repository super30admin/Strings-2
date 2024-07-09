"""
Time Complexity - O(m).Length of given string
Space Complexity - O(n) Length of pattern string

Works on Leetcode.
"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # if given string is smaller than the pattern return and empty array
        if len(p) > len(s):
            return []
        #create a hashMap 
        hashMap = {}
        #maintain a count for the number of matching characters
        cnt = 0
        n = len(p)
        result = []
        # store the characters of the pattern and their frequency in the hashMap
        for c in p:
            hashMap[c] = hashMap.get(c,0)+1
        #traverse the given string and maintain a window of size same as pattern
        for i in range(len(s)):
            #when a character removed from window increase the frequency of the character in the hashMap
            if i >= n and s[i-n] in hashMap:
                hashMap[s[i-n]] +=1
                #when frequency become 1 we do not have enough characters matching this character in the window
                #hence count of matching character decreases
                if hashMap[s[i-n]] == 1:
                    cnt-=1
                
            if s[i] in hashMap:
                #when character is included in the window, we reduce the frequency of the character in hashMap
                hashMap[s[i]]-=1
                #when we have required characters in the window for the pattern count for matching character increases by 1.
                if hashMap[s[i]] == 0:
                    cnt+=1
            #when count matches the number of characters in the hashMap, we add the start position of window to map
            if cnt == len(hashMap):
                result.append(i-n+1)
        return result


        