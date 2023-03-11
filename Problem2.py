#Time Complexity :- O(n)
#Space Complexity :- O(1)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hashMap = {}
        match = 0
        finalList = []

        for i in range(len(p)):
            if p[i] not in hashMap:
                hashMap[p[i]] = 0
            hashMap[p[i]] +=1
        
        for i in range(len(s)):
            if s[i] in hashMap:
                hashMap[s[i]]-=1
                if hashMap[s[i]] == 0:
                    match+=1
            if i>= len(p):
                if s[i-len(p)] in hashMap:
                    hashMap[s[i-len(p)]]+=1
                    if hashMap[s[i-len(p)]] ==1:
                        match-=1
            if match == len(hashMap):
                finalList.append(i-len(p)+1)
        return finalList



        