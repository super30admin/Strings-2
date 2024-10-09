'''
1. First maintain a hashMap of string p with its counts of characters.
2. Iterate over string s, if character is found in hashMap, decrement its count. If count becomes 0 that means one char matched. Update count it in hashMap.
3. If the index is window length is greater than length of p, then check if it was a matched character by getting its count in HM.
4. In case the matches value is equal to length of HM (not p because p may have dup chars) the index  p length away from cur ptr is beginning of the anagram.

TC: O(n)
SC: O(n)
'''

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        hashMap = {}
        res = []

        for i in range(len(p)):
            c = p[i]
            if c in hashMap:
                hashMap[c] += 1
            else:
                hashMap[c] = 1

        matches = 0
        for i in range(len(s)):
            incoming = s[i]
            if incoming in hashMap:
                times = hashMap[incoming]
                times -= 1
                if times == 0:
                    matches += 1
                hashMap[incoming] = times

            if i >= len(p):
                outgoing = s[i-len(p)]
                if outgoing in hashMap:
                    times = hashMap[outgoing]
                    times += 1
                    if times == 1:
                        matches -= 1
                    hashMap[outgoing] = times
            if matches == len(hashMap):
                res.append(i- (len(p)-1))
        return res