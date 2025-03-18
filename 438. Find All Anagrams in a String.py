
from collections import Counter
#space: O(n) for the dictionary of the pattern
#time: O(n) for iterating the string
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        #create a dictionary
        pmap= Counter(p)
        l_s=len(s)
        l_p=len(p)

        mach=0
        final=list()
        #iterate the string, if character is in dict, update dict
        for i in range(l_s):
            #update dict to +1
            if s[i] in pmap:
                pmap[s[i]]-=1
            # if the dict is 0, update m+=1
                if pmap[s[i]]==0:
                    mach+=1

            #if i > len(p)
            if i >= l_p:
                if s[i-l_p] in pmap:
                    #update dict to +1 for the element which is popped out of window
                    pmap[s[i-l_p]]+=1
                    #if the count equals 1 then the it unmatches
                    if pmap[s[i-l_p]] ==1:
                        mach-=1
            if mach == l_p:
                final.append(i-l_p+1)
        return final
        
