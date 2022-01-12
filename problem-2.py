# Leetcode excution: YES
# time complexity: O(n)
# space complexity: O(1)

class Solution:
    def findAnagrams(self, s: str, p: str) -> list:
        mapp={}
        result=[]
        # count and add the alphabets to the mapp dictionary with character as key and count  #of that character as value
        for x in p:
            if x in mapp:
                mapp[x]+=1
            else:
                mapp[x]=1
        slow=0
        match=0
        # we have number of matched casesa to be 0 and slow pointer at 0, we have i as our fast pointer
        # looping through the given s string 
        for i in range(len(s)):
            #if we have that element in the map then we decrease the count of that chracter
            # in the mapp and we treat that as the number of elements of that character we need to fulfil the condition
            if s[i] in mapp:
                mapp[s[i]]-=1
                # if the value reached 0 we increment match so that we say that one condition is satisfied
                if mapp[s[i]]==0:
                    match+=1
            # we do not move slow ponter until fast moves len(p)  character forward 
            if i>=len(p):
                # we then move slow and we record the character moving out of the window as it is not gonna be in the window anymore we increment the count of that character we need in the mapp
                if s[slow] in mapp:
                    mapp[s[slow]]+=1
                    # if that value reaches 1 we decreses the match since that condition doesn;t satisfies anbymore
                    if mapp[s[slow]]==1:
                        match-=1
                # we move slow at ever step afte that 
                slow+=1
                
            # print(match)
            # if mapp length is equal to the match then we just add the slow index to the resutl array 
            if match==len(mapp):
                result.append(slow)
                    
                
            
        return result