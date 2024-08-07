##438. Find All Anagrams in a String############################################################################################
// Time Complexity : m+n
// Space Complexity : O(1) -> used to maintain the dictionary
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
We create a dictionary match string where count of each element is stored, now we apply sliding window on main string and when a match is found we reduce the count of element form dict and also make sure our match index is increased when any element count drops to zero. When the match count reaches the length of dict it means we have found match. When performing the sliding window we also make sure to add count to dict when any element is removed and also reduce match count when any element count change for 0 to 1 

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        l1=[]
        dict1={}
        for i in s:
            if i not in dict1:
                dict1[i]=0
            dict1[i]+=1
        for i in order:
            if i in dict1:
                cnt=dict1[i]
                for j in range(cnt):
                    l1.append(i)
                dict1.pop(i)
        for i in dict1:
            for j in range(dict1[i]):
                l1.append(i)
        return ''.join(l1)
