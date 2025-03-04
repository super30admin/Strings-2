'''
    Time Complexity: O(m+n)
    Space Complexity: O(1)
'''
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        n = len(s)
        m = len(p)
        hashmap = {}
        result = []

        for char in p:
            if char not in hashmap:
                hashmap[char] = 1
            else:
                hashmap[char] += 1

        curMatch = 0
        keys = len(hashmap.keys())

        for i in range(n):
            if s[i] in hashmap:
                hashmap[s[i]] -= 1
                    
                if hashmap[s[i]] == 0:
                    curMatch += 1
            
            if i >= m:
                if s[i-m] in hashmap:
                    hashmap[s[i-m]] += 1
                    
                    if hashmap[s[i-m]] == 1:
                        curMatch -= 1

            if curMatch == keys:
                result.append(i-m+1)

        return result