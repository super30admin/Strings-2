class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        indicesAnagram = []
        for i in range(len(s)):
            temp=""
            if i+len(p)<=len(s):
                temp = s[i:i+len(p)]
            pTemp = p
            while len(temp) == len(pTemp) and (len(pTemp)>0):
                countX = 0
                x = pTemp[0]
                countX = p.count(x)
                temp = temp.replace(x,"",countX)
                pTemp = pTemp.replace(x,"",countX)
            if len(temp) == len(pTemp):
                indicesAnagram.append(i)
        return indicesAnagram

''' 
Time Comlexity: O(n)
Space Complexity: O(1)
'''