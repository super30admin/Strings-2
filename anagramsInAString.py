# Time:O(m+n) for 2 strings
# Space:O(m) for hashmap
# Leetcode: Yes
# Issues:None

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        m = len(s)
        n = len(p)

        hmap = {}                           # initialize anagram frequncy map
        for i in p:
            if i in hmap:
                hmap[i] +=1
            else:
                hmap[i] = 1

        res = []
        size = 0

        for i in range(m):                  # check sliding window incoming vs outgoing
            cin = s[i]
            if cin in hmap:
                hmap[cin] -= 1
                if hmap[cin] == 0:          # 1 -> 0  we found all values
                    size +=1

            if i >=n:                       # after n elements sliding window stops accepting 
                cout = s[i-n]
                if cout in hmap:
                    hmap[cout] += 1
                    if hmap[cout] == 1:     # 0 -> 1  we found all values
                        size -=1

            if size == len(hmap):           
                res.append(i-n+1)

        return res


        