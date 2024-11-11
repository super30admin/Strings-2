#Approach
# Maintain a ferquency map of the pattern. and reduce the frequency of the elements in hashmap decrementthe frequency id the all elemets in freq map reach to 0 then there is ana anagram



#Complexities
#Time: O(M+N)
#Space :O(M)



from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hashMap = {}
        matched = 0
        result = []
        for char in p:
            if char not in hashMap:
                hashMap[char] = 0
            hashMap[char] += 1

        for i in range(len(s)):
            if s[i] in hashMap:
                hashMap[s[i]] -= 1
                if hashMap[s[i]] == 0:
                    matched += 1

            if i >= len(p):
                if s[i - len(p)] in hashMap:
                    hashMap[s[i - len(p)]] += 1
                    if hashMap[s[i - len(p)]] == 1:
                        matched -= 1
            if (matched == len(hashMap)):
                result.append(i - len(p) + 1)
        return result

