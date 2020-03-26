# Problem 1 - Custom sort string
## Time Complexity :
O(P+S)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
No. Time Limit Exceeded

## Any problem you faced while coding this :
Yes. I tried coding the same method discussed in class. But, cannot figure out what the error is. 

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def findAnagrams(self, s: str, p: str) -> List[int]:
              #Edge Case
              if len(s)<len(p):
                  return
              freqP=[0]*26
              freqWindow=[0]*26

              #Poppulate freqP
              for i in range(len(p)):
                  ch=p[i]
                  #print(freqP[ord(ch)-ord('a')])
                  freqP[ord(ch)-ord('a')]+=1
              start=end=0
              result=[]
              while end<len(s):
                  ch=s[end]
                  freqWindow[ord(ch)-ord('a')]+=1
                  if end-start+1 > len(p):
                      freqWindow[ord(s[start])-ord('a')]-=1
                      start+=1
              if freqWindow==freqP:
                  #CHecking anagram
                  result.append(start)
              end+=1
              return result
              
              
# Problem 1 - strStr()
## Time Complexity :
O()

## Space Complexity :
O()

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution 1: BRUTE FORCE.
    class Solution:
        def strStr(self, haystack: str, needle: str) -> int:
            if not needle:
                return 0
            if needle not in haystack:
                return -1
            for i in range(len(haystack)): 
                if haystack[i:(i+len(needle))] == needle:
                    return i
                    break

### Solution 2: KMP ALGORITHM
(Yet to do.)
