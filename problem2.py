# problem2 
# https://leetcode.com/problems/find-all-anagrams-in-a-string/

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        m = len(s)
        n = len(p)  
        map_val = {}
        for ch in p:
            if ch in map_val:
                map_val[ch]+=1
            else:
                map_val[ch]=1
        match = 0
        final_arr = []
        for i in range(m):
            in_char = s[i]
            if in_char in map_val:
                map_val[in_char] -=1
                if map_val[in_char] == 0:
                    match+=1
            if i >= n:
                out_char = s[i-n]
                if out_char in map_val:
                    map_val[out_char]+=1
                    if map_val[out_char] == 1:
                        match-=1
            if match == len(map_val):
                final_arr.append(i-n+1)
        return final_arr