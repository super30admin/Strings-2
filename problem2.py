class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # list1=[]
        # w=len(p)
        # if len(p) > len(s): return []
        # for i in range(len(s)):
        #     if i+w<=len(s):
        #         k=sorted(s[i:i+w])
        #         if k==sorted(p):
        #             list1.append(i)
        # return list1
        result = []
        if len(p) > len(s): return result
        d1, d2 = [0] * 26, [0] * 26
        for i in range(len(p)):
            d1[ord(s[i]) - 97] += 1
            d2[ord(p[i]) - 97] += 1
        # print(d1,d2)
        if d1 == d2: result.append(0)
        for i in range(1, len(s) - len(p) + 1):
            d1[ord(s[i + len(p) - 1]) - 97] += 1
            d1[ord(s[i - 1]) - 97] -= 1
            if d1 == d2: result.append(i)
        return result