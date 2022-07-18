import collections
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # Sliding window and hashmap
        # TC - O(n) SC- O(1) because max 26 letters

        n = len(s)
        m = len(p)
        result = []

        if n < m:
            return result

        p_count = collections.Counter(p)
        s_count = collections.Counter()

        # sliding window
        for i in range(n):
            s_count[s[i]] += 1
            if i >= m:
                if s_count[s[i - m]] == 1:
                    del s_count[s[i - m]]
                else:
                    s_count[s[i - m]] -= 1
            if p_count == s_count:
                result.append(i - m + 1)
        return result

    '''
        # Brute Force
        # TC O(n-m)*O(mlogm)*O(m) = O((n-m)*m*m*logm)
        n = len(s)
        m = len(p)

        p = sorted(p) #TC = O(mlog(m))
        for i in range(n-m+1): # TC O(n-m)
            if p == sorted(s[i:i+m]): # TC O(mlogm) for sorted() and O(m) for comparisions
                result.append(i) 
        return result
    '''
