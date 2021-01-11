class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        #check valid anagaram at each index of s>>TLE>>O(np)
#         res=[]
#         def valid(s):
#             parray=[0]*27
#             for i in p:
#                 parray[ord(i)-97]+=1
            
#             for i in s:
#                 if parray[ord(i)-97]>0:
#                     parray[ord(i)-97]-=1 
#             for i in range(27):
#                 if parray[i]>0:
#                     return False
#             return True
            
#         for i in range(len(s)-len(p)+1):
#             if valid(s[i:i+len(p)]):
#                 res.append(i)
#         return res

# #sliding window
# #O(n+p)
# #O(1)>default map of 26 chars
#         if len(s)<len(p):
#             return []
#         ps=collections.defaultdict(int)
#         for i in p:
#             ps[i]+=1
#         i=0
#         j=0
#         res=[]
#         ss=collections.defaultdict(int)
#         while(j<len(s)):
#             if j-i<len(p):
#                 #if window maintained, jth char intake
#                 ss[s[j]]+=1
#             #if length of window breaches, discard ith char and mov forward
#             if j-i>=len(p):
#                 ss[s[i]]-=1
#                 if ss[s[i]]==0:
#                     del ss[s[i]]
#                 #intake jth char
#                 ss[s[j]]+=1
#                 i+=1
#             #check if counter maps are equal
#             if ss==ps:
#                 res.append(i)
            
#             j+=1
#         return res


        #maintain window and do variable match
        #hashmap of pattern only
        #O(p+s)
        #O(26)>O(1)
        Pmap={}
        match=0
        res=[]
        for i in p:
            Pmap[i]=Pmap.get(i,0)+1
        for i in range(len(s)):
            c=s[i]
            #incoming char in Pmap>change repective count in Map
            if c in Pmap:
                icount=Pmap[c]
                icount-=1
                #if count become szero>that char is matched
                if icount==0:
                    match+=1
                Pmap[c]=icount
            #window breached>remove extra char from front
            if i>=len(p):
                outgoing=s[i-len(p)]
                if outgoing in Pmap:
                    #change respective count
                    ocount=Pmap[outgoing]
                    ocount+=1
                    #if count is greater than 0> means that char is absent in window>
                    #Reduce matched
                    if ocount>0:
                        match-=1
                    Pmap[outgoing]=ocount
            #if matched frequency matches unique chars in map
            if match==len(Pmap):
                res.append(i-len(p)+1)
        return res
            
        
    