""""// Time Complexity : O(m+n)~O(n) as m<n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        d={}
        for i in p:
            if i not in d:
                d[i]=0
            d[i]+=1

        match=0
        result=[]
        for i in range(len(s)):
            #IN
            if s[i] in d:
                d[s[i]]-=1
                if d[s[i]]==0:
                    match+=1
            #OUT
            if i>=len(p):
                if s[i-len(p)] in d:
                    d[s[i-len(p)]]+=1
                    if d[s[i-len(p)]]==1:
                        match-=1
            if match==len(d):
                result.append(i-len(p)+1)
        return result

#By Prime-Product
# class Solution:
#     def findAnagrams(self, s: str, p: str) -> List[int]:
#         d = Counter(p)
#         primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
#                   103]
#         res = 1
#         for c in d:
#             res = res * primes[ord(c) - ord('a')]
#
#         match = 1
#         result = []
#         for i in range(len(s)):
#             # IN
#             if s[i] in d:
#                 d[s[i]] -= 1
#                 if d[s[i]] == 0:
#                     match *= primes[ord(s[i]) - ord('a')]
#             # OUT
#             if i >= len(p):
#                 if s[i - len(p)] in d:
#                     d[s[i - len(p)]] += 1
#                     if d[s[i - len(p)]] == 1:
#                         match //= primes[ord(s[i - len(p)]) - ord('a')]
#             if match == res:
#                 result.append(i - len(p) + 1)
#         return result




# BruteForce HashMap- TLE- TC-O(nm)
# class Solution:
#     def findAnagrams(self, s: str, p: str) -> List[int]:
#         d=Counter(p)

#         p1=0
#         p2=len(p)-1
#         result=[]
#         while p2<len(s):
#             if Counter(s[p1:p2+1])==d:
#                 result.append(p1)
#             p1+=1
#             p2+=1
#         return result


# BruteForce Sorting- TLE- TC-O(nmlog(m))
# class Solution:
#     def findAnagrams(self, s: str, p: str) -> List[int]:
#         x=''.join(sorted(p))
#         p1=0
#         p2=len(p)-1
#         result=[]
#         while p2<len(s):
#             if ''.join(sorted(s[p1:p2+1]))==x:
#                 result.append(p1)
#             p1+=1
#             p2+=1
#         return result

