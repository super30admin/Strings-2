"""
Problem : 2

Time Complexity : O(max(m,n))
Space Complexity : O(1) as maximum size of hashmap would be 26

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Sliding window and Deque - 
Counting the occurences of each character of pattern string in a hashmap, Creating a window of size of the pattern string length, 
whenver a character comes in the window, decreasing its counter in the hashamp if it exists, if the counter becomes 0 means, we have all
the required occurences of the character then increasing the counter by 1, which denotes the the number of unique character we have in the window
adding new character in the window, updating the counter and count, and removing the character at the start of the window and updating the counter
and count, if the count matches the the number of uniqur characters we have in the pattern string, then adding the start index of the window in the
result array and returning result in the end

Prime Multiplication - 
Assigning a prime number for every character, creating a window and sliding it, instead of updating the counter, maintaining a multiplication of prime number
correspinding to each number in the window, if a character is removed, dividing the multiplication by its prime number, if a character is added in the window,
multiplying by its prime number, if the multiplication matches the product of prime numbers for the pattern string, then a match has been found and adding the index
of the start of the window to the result

"""

# Find All Anagrams in a String

# Approach - 1
# Sliding Window

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        hmap={}
        ssize=len(s)
        psize=len(p)

        for i in range(psize):
            if p[i] not in hmap:
                hmap[p[i]]=0
            hmap[p[i]]+=1
        # q=collections.deque()
        result=[]
        count=0
        for i in range(ssize):
            inChar=s[i]
            if inChar in hmap:
                hmap[inChar]-=1
                if hmap[inChar]==0:
                    count+=1
            
            if i>=psize:
                outChar=s[i-psize]
                if outChar in hmap:
                    hmap[outChar]+=1
                    if hmap[outChar]==1:
                        count-=1
            if count==len(hmap):
                result.append(i-psize+1)
        return result

# Approach - 2
# Double Ended Queue

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        hmap={}
        n=len(s)
        m=len(p)

        for i in range(m):
            if p[i] not in hmap:
                hmap[p[i]]=0
            hmap[p[i]]+=1
        q=collections.deque()
        result=[]
        count=0
        for i in range(n):
            q.append(s[i])
            if s[i] in hmap:
                hmap[s[i]]-=1
                if hmap[s[i]]==0:
                    count+=1

            if i>=m:
                l=q.popleft()
                if l in hmap:
                    hmap[l]+=1
                    if hmap[l]==1:
                        count-=1

            if count==len(hmap):
                result.append(i-m+1)
         
        return result

# Approach - 3
# Prime Multiplication/Hashing

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        result=[]
        m=len(p)
        n=len(s)
        if m>n:
            return result
        
        prime=[2,3,5,7,11,13,17,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103]

        patProduct=1

        for i in range(m):
            patProduct*=prime[ord(p[i])-ord('a')]
        strProduct=1
        for i in range(n):
            inChar=s[i]
            strProduct*=prime[ord(inChar)-ord('a')]

            if i>=m:
                outChar=s[i-m]
                strProduct/=prime[ord(outChar)-ord('a')]

            if patProduct==strProduct:
                result.append(i-m+1)
         
        return result