#Time complexity is: O(p) where p is the length of p 
#Space complexity is:O(1)
#No issues faced while coding
#Code ran successfully on leetcode

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        #creating a hashmap and result set
        self.map={}
        self.result=[]
        #calculating the frequencies of all the characters in p
        for c in p:
            if(c not in self.map):
                self.map[c]=1
            else:
                self.map[c]+=1
        #initializing match value to 0
        self.match=0
        for i in range(0,len(s)):
            #incoming value
            inc=s[i]
            if(inc in self.map):
                #We will calculate the new count and we will update that
                cnt=self.map[inc]-1
                self.map[inc]=cnt
                #if count is 0, then we will imcrement match value
                if(cnt==0):
                    self.match+=1
            
            
            if(i>=len(p)):
                #outgoing value
                out=s[i-len(p)]
                if(out in self.map):
                    #We will calculate the count and update that in the hashmap
                    cnt=self.map[out]+1
                    self.map[out]=cnt
                    #if count is 1, then only we will reduce the match value
                    if(cnt==1):
                        self.match-=1
            #if the match value is equal to length of the map, we will append the starting index in the resultant array
            if(self.match==len(self.map)):
                self.result.append(i-len(p)+1)
        #finally we will return the result
        return self.result