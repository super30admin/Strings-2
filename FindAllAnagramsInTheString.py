# Time Complexity:
# O(m+n) , where m,n are lenght of "s" and "p" strings

# Space Complexity:  
# O(1)   , this is because hashMap will contain 26 alphabets only irrespective of the the string size.

# Approach: 
# Use the hashmap, to maintain the index of the chars in the longest substring between the two pointers we will take.
# "start" pointer is the start of substr
# "i" is the end pointer of current substr under consideration

class Solution(object):      #TC = m+n, SC = O(1)
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        if not s or len(s)==0 or len(s)<len(p):
            return []

        result = []   # return the indices where anagrams were found
        match = 0

        # for building occurence of chars in string "p"
        hashMap = {}

        for i in range(len(p)):
            if p[i] in hashMap.keys():
                hashMap[p[i]] += 1
            else:
                hashMap[p[i]] = 1

        for i in range(len(s)):
            inChar = s[i]
            if inChar in hashMap.keys():
                cnt = hashMap[inChar]
                cnt -= 1
                if cnt ==0:
                    match += 1
                hashMap[inChar] = cnt

            if i >= len(p):
                outChar = s[i-len(p)]
                if outChar in hashMap.keys():
                    cnt = hashMap[outChar]
                    cnt += 1
                    if cnt==1:
                        match -=1
                    hashMap[outChar] = cnt

            if len(hashMap)== match:
                result.append(i-len(p)+1)

        return result
        