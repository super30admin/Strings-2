#438. Find All Anagrams in a String


# // Time Complexity : O(n)  # len of string s
# // Space Complexity : O(m) # len of hashmap  ie string p 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


#sliding window

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        n = len(s)
        m = len(p)
        match_count = 0
        hashmap = dict()
        res = []
        # create a hashmap of p
        for i in p:
            if i in hashmap:
                hashmap[i] += 1
            else:
                hashmap[i] = 1
       #sliding window
        for i in range(n): # O(n)
            # incoming char
            if s[i] in hashmap:
                hashmap[s[i]] -= 1
                if hashmap[s[i]] == 0:
                    match_count += 1
                
            # out going char
            if i >= m: # after expanding the initial window
                start = i - m # starting pointer of the window
                if s[start] in hashmap:
                    hashmap[s[start]] += 1
                    if hashmap[s[start]] == 1:
                        match_count -= 1
                    
            if match_count == len(hashmap):
                res.append( i -m +1 ) # start of the new window

        return res
