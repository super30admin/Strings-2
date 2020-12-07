class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        from collections import defaultdict
        dic=defaultdict(int)
        match=0
        res=[]
        for i in range(len(p)):
            dic[p[i]]+=1
        # print(dic)
        for j in range(len(s)):
            if s[j] in dic:
                dic[s[j]]-=1
                if dic[s[j]]==0:
                    match+=1
            # print(dic)
            if j>=len(p):
                out=s[j-len(p)]
                if out in dic:
                    dic[out]+=1
                    if dic[out]==1:
                        match-=1
            if match==len(dic):
                res.append(j-len(p)+1)
        return res
    # time-o(n+m) space-O(1)