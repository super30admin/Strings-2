class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        freq={}
        match=0
        result=[]
        for i in range(len(p)):
            freq[p[i]]=freq.get(p[i],0)+1
        for i in range(len(s)):
            if s[i] in freq:
                count=freq.get(s[i])
                count=count-1
                if count==0:
                    match=match+1
                freq[s[i]]=count
            if i>=len(p):
                x=i-len(p)
                if s[x] in freq:
                    count=freq.get(s[x])
                    count=count+1
                    if count==1:
                        match=match-1
                    freq[s[x]]=count
            if match==len(freq):
                result.append(i-len(p)+1)
        return result