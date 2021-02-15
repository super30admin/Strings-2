#Time Complexity:O(m+n)
#Space Complexity:O(n)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result=[]                                   #Declaring a result array
        dict={}                                     #declaring a hash map
        for i in range(len(p)):                     #put all chars of the string p as keys into the hasmap with their count as values.
            if p[i] not in dict:
                dict[p[i]]=0
            dict[p[i]]+=1
        match=0
        for i in range(len(s)):                     #while iterating through string s
            if s[i] in dict:                        #if a character of s is in hashmap
                inp=s[i]                        
                dict[inp]-=1                        #decrement its count in hashmap by one
                if dict[inp]==0:                    #if the value reaches 0
                    match+=1                        #increment match by one
            if i>=len(p):                           #if the value of i is greater than length of p string
                out=s[i-len(p)]                     #move the last element from the sliding window
                if out in dict:                     #if it is in the hashmap
                    dict[out]+=1                    #increment its count value by one
                    if dict[out]==1:                #if the value is one
                        match-=1                    #decrement match value by one
            if match==len(dict):                    #if the match value is same as length of hashmap
                result.append(i-len(p)+1)           #append the index value of matched string start to the result.
        return result  