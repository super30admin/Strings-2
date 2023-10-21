# Time complexity: O(n)
# Space complexity: O(n)

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        s_len = len(s)
        p_len = len(p)
        dic2 = {}
        for i in p:
            if i in dic2:
                dic2[i] += 1
            else:
                dic2[i] = 1 
        #print(dic2)

        arr =[]
        dic1 = {}

        for i in range(s_len):
            if s[i] in dic1:
                dic1[s[i]] += 1
            else:
                dic1[s[i]] = 1
            # print(dic1)
            if i >= p_len:
                if dic1[s[i-p_len]] == 1:
                    del dic1[s[i-p_len]]
                else:
                    dic1[s[i-p_len]] -= 1
            if dic1 == dic2:
                arr.append(i-p_len+1)
        return arr
