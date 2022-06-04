#Time Complexity: O(N)
#Space Complexity: O(1) SINCE THERE ARE 26 CHARACTERS
from collections import Counter
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        li = []
        plen = len(p)    
        slen = len(s)
        dic = {}
        for i in p:
            if i not in dic:
                dic[i] = 1
            else:
                dic[i] +=1
        match = 0     
        for i in range(slen):
            if s[i] in dic:
                dic[s[i]] -=1
                if dic[s[i]] == 0:
                    match +=1
                
            if i >= plen:
                char = s[i-plen]
                if char in dic:
                    dic[char] +=1
                    if dic[char] == 1:
                        match -=1
                
            if match == len(dic):
                li.append(i-plen+1)

        return li
            