class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        '''
        Time complexity = O(N)
        Space = O(N)
        '''
        s_count , p_count = [0]*26, [0]*26
        len_s, len_p = len(s) , len(p)
        result = []
        for i in p:
            p_count[ord(i)-ord('a')] += 1
        for i in range(len_s):
            if i < len_p:
                s_count[ord(s[i])-ord('a')] += 1
            else:
                s_count[ord(s[i-len_p])-ord('a')] -= 1
                s_count[ord(s[i])-ord('a')] += 1
            if s_count == p_count:
                result.append( i-len_p + 1 )
        return result
        
    def bruteForcefindAnagrams(self, s: str, p: str) -> List[int]:
        '''
        Time = O(NMlogM)
        Space = O(N)
        '''
        l = 0 
        r = len(p)
        sorted_p = sorted(p)
        result = []
        while r <= len(s):
            sorted_s = sorted(s[l:r])
            if sorted_s == sorted_p:
                result.append(l)
            l+= 1
            r += 1
        return result
