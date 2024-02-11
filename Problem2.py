'''

Time Complexity : O(slen+plen)
Space Complexity : O(slen+plen)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

We use two dictionaries, one for pcount. To keep track of elements and the other one to add and remove elements as we traverse thru the
s string. We compare both the dictionaries to see if they're equal and add the respective index

'''

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        plen = len(p)
        slen = len(s)

        if plen > slen: return []

        pCount = defaultdict(int)
        sCount = defaultdict(int)

        for i in range(plen):
            pCount[p[i]] = 1 + pCount.get(p[i],0)
            sCount[s[i]] = 1 + sCount.get(s[i],0)

        res = [0] if pCount == sCount else []

        j = 0
        for i in range(plen,slen):
            sCount[s[i]] = 1 + sCount.get(s[i],0)
            sCount[s[j]] -= 1

            if sCount[s[j]] == 0:
                sCount.pop(s[j])

            j += 1

            if sCount == pCount:
                res.append(j)


        return res



