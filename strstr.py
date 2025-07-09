# TimeComplexity:O(m+n)
# SpaceComplexity:O(1)
# Approach:
#     BruteForce:O(mxn) at each idx compare needle string with usbstring in haystack
#     Optimal:use hash value .trickypart is finding hash function because we need extact string not anangrams so curr_val*10+incoming val would be good hash function 



class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #get hash value if needle and for haystack find hash val of len of needle adn do incomminga nd outgoing stuff
        if len(needle)>len(haystack):return -1
        k=26
        hval_needle=0
        hval_haystack=0
        n=len(needle)
        for i in needle:
            hval_needle=hval_needle*10+ (ord(i)-ord('a')+1)
        for l in range(n):
            ch=haystack[l]
            hval_haystack=hval_haystack*10+(ord(ch)-ord('a')+1)
        for idx in range(n,len(haystack)):
            
            ch=haystack[idx]
            if hval_haystack==hval_needle:
                return idx-n
            #outgoing
            out=idx-n
            hval_haystack-= (ord(haystack[out])-ord('a')+1)*(10**(n-1))
            #incoming
            hval_haystack=hval_haystack*10+(ord(ch)-ord('a')+1)
        if hval_haystack==hval_needle:
            return len(haystack)-n
        return -1

        


