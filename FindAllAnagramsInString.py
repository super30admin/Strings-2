#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Nov 11 12:28:56 2019

@author: tanvirkaur
"""

# sliding window apprach is used : incoming character , outgoing charcters and the size of the sliding window is tracked. Time complexity = O(n+m), space complexity = constant
# error : Only printing the first value of the result: s : "abab" p:"ab" output= [0,1,2] but this code is showing only [0]
class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        match = 0
        dict1 = {}
        result = []
        if len(s) == 0 or len(p)> len(s):
            return result
        for char in p:
            if char in dict1:
                dict1[char] = dict1.get(char,0) + 1
            else:
                dict1[char] = 1
        # for incoming character we check if that character is there in hashmap or not.If it is in hashmap we decrement its value by 1 and if its value becomes zero we increment our match 
    
        for i in range(len(s)):
            if s[i] in dict1 and i< len(p):
                dict1[s[i]] = dict1[s[i]]-1
                if dict1[s[i]] == 0:
                    match += 1
            # outgoing character
            if (i >= len(p)):
                ch = s[i-len(p)]
                if ch in dict1:
                    dict1[ch] = dict1[ch] + 1
                    match += -1
                    
            if match == len(dict1):
                result.append(i-len(p)+1)
                
        return result
                

                    
# if i becomes greater than the length of p ,we remove the outgoing character and if the outgoing character is in hashmap we increment the hashmap and then we decrement the match
          