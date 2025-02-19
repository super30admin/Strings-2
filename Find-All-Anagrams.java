Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

Given a string s and a non-empty string p, find all the start indices of p s anagrams in s

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


//Approach
// Time Complexity : O(m+n)
// Space Complexity : O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s==null || s.length()==0 || p.length()>s.length()){
            return new ArrayList<>();
        }
        HashMap<Character,Integer> map=new HashMap<>();
        List<Integer> result= new ArrayList<>();
        int match=0;
        int start=0;
        for(int i=0;i<p.length();i++){
            char c=p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                count--;
                if(count==0){
                    match++;
                }
                map.put(c,count);
            }
            if(i>=p.length() && map.containsKey(s.charAt(i- p.length()))){
                int count = map.get(s.charAt(i-p.length()));
                count++;
                if(count==1){
                    match--;
                }
                
                map.put(s.charAt(i-p.length()),count);
            }

            if(match==map.size()){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}