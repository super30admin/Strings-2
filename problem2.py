#Find All Anagrams in a String

# // Time Complexity :  O(max(s,p)) 
# // Space Complexity : O(1)- as the max elements will only be 26 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def findAnagrams(self, s: str, p: str):
    if (len(p)>len(s)): return []
    pmap={}
    smap={}
    for i in range(len(p)):                 #copy the length of p elements to two hashmaps
        pmap[p[i]]=1+pmap.get(p[i],0)
        smap[s[i]]=1+smap.get(s[i],0)
    
    res=[0] if smap==pmap else []           #if two hashmaps equal to each other, you know that the first index started the anagram
    left=0
    for i in range(len(p), len(s)):         
        smap[s[i]]=1+smap.get(s[i],0)       #increment the right index to the hashmap
        smap[s[left]] -=1                   #decrement the left index from the hashmap
        if(smap[s[left]]==0):               #if its 0, remove fom the hashamp
            smap.pop(s[left])
        
        left+=1
        if(smap==pmap):                     #after adding the right and removing the left, if they equal each other, you know theyre anagrams
            res.append(left)                #append the left index to the list
            
    return res