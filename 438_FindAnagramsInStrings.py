#Time Complexity: O(n), n = len(s)
# space complexity: O(1)
# Hashmap and Sliding window
# along with hashmap and windows, take "match" variable, which will maintain the count of matching character in each window
# make hashmap of charters of P to count the occurances
# take slinding window of len(p) in S
# check incoming and outgoing charcters of slnding window, 
# if incoming is present in hashmap, decrese the count by 1, and increase match var by 1
# if outgoing is present in hashmap, increase the count by 1, and 
# if hashMap[outgoing] == 1 --> meaning that, this element is become 0  to 1 so, decrese match var by 1
# count of match is equal to the len(hashmap), while ietrating over that window, it means anagram is found
#  return starting index of that anagram.
class Solution:
    def findAnagrams(self, s: str, p: str) :
        result = []
        if len(p) > len(s):
            return result
        hashMap = {}
        match = 0
        print(len(s))
        # making hashmap of p
        for i in p:
            if i in hashMap:
                hashMap[i] +=1
            else:
                hashMap[i] = 1


        for i in range(0,len(s)):
            # add i character the window
            inComing = s[i]
            if inComing in hashMap:
                hashMap[inComing] -= 1
                if hashMap[inComing] == 0:
                    match += 1
            # if i is more than len(p), then remove first character of the window 
            if i >=  len(p):
                outGoing = s[i - len(p)] # for ex, len(p) = 4, i == 5, then we have to remove charcter at 1st index. -> i - len(p) = 1
                if outGoing in hashMap:
                    hashMap[outGoing] += 1
                    if hashMap[outGoing] == 1:
                        match -= 1
                    
            if match == len(hashMap):
                result.append(i - len(p)+1) 
                # for example, S = "mississippi", p = "issip"
                #  i = 8, len(p) = 5, we got anagram at 6th index , it means at 6th index is last index of anagram in String S
                # we want starting index of anagram in string S
                # i - len(p) + 1 = 4 --> this is starting index of Anagram in S.

        return result
    
obj = Solution()
print(obj.findAnagrams("mississippi","issip"))
print(obj.findAnagrams("cbaebabacd","abc"))