# Strings-2


## Problem1 
Implement strStr() (https://leetcode.com/problems/implement-strstr/)

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().



import java.math.BigInteger;
class Solution {
    public int strStr(String haystack, String needle) {
        // long hash=0l;
        if(needle.length()>haystack.length())
            return -1;
        BigInteger hash = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(26); 
        for(int i=0;i<needle.length();i++)
        {
            char c=needle.charAt(i);
            // hash=hash*26+(c-'a'+1);
            hash=hash.multiply(k).add(BigInteger.valueOf(c-'a'+1));
        }
        // long kl=(long)Math.pow(26,needle.length()-1);
        // long hash2=0l;
        BigInteger hash2=BigInteger.ZERO;
        for(int i=0;i<haystack.length();i++)
        {
            if(i>=needle.length())
            {
                // char d=haystack.charAt(i-needle.length());
                // hash2=hash2-(d-'a'+1)*kl;
                hash2=hash2.mod(k.pow(needle.length()-1));
            }
            char c=haystack.charAt(i);
            // hash2=hash2*26+(c-'a'+1);
            hash2=hash2.multiply(k).add(BigInteger.valueOf(c-'a'+1));
            // if(hash==hash2){
            //     return i-needle.length()+1;
            // }
            if(hash.equals(hash2)){
                return i-needle.length()+1;
            }
        }
        return -1;
        
    }
}

## Problem2 

Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<Integer>();
        HashMap<Character,Integer> hmap=new HashMap<>();
        int match=0;
        int n=s.length();
        for(int i=0;i<p.length();i++){
            char c=p.charAt(i);
            hmap.put(c,hmap.getOrDefault(c,0)+1);
        }
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(hmap.containsKey(c)){
                int cnt=hmap.get(c)-1;
                hmap.put(c,cnt);
                if(cnt==0)
                    match++;
            }
            if(i>=p.length()){
                char out=s.charAt(i-p.length());
                if(hmap.containsKey(out)){
                    int cnt=hmap.get(out)+1;
                    hmap.put(out,cnt);
                    if(cnt==1)
                        match--;
                }
            }
            if(match==hmap.size())
                result.add(i-p.length()+1);
        }
        return result;
    }
}
