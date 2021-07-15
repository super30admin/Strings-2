# Strings-2


## Problem1 
Implement strStr() (https://leetcode.com/problems/implement-strstr/)

//Time Complexity = O(m + n)
//Space Complexity = O(n)
//KMP algorithm 

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0; 
        
        int[] lps = lps(needle); 
        
        int i = 0;
        int j = 0;
        int n = needle.length();
        
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                
                if(j == n){
                    return i - n; 
                }
            }else if(haystack.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j-1]; 
            }else if(haystack.charAt(i) != needle.charAt(j) && j == 0){
                i++; 
            }
        }
        return -1; 
    }
    
    private int[] lps(String needle){
        int[] lps = new int[needle.length()]; 
        int i = 1; 
        int j = 0; 
        
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++; 
                lps[i] = j;
                i++;
            }else if(needle.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j-1]; 
            }else if(needle.charAt(i) != needle.charAt(j) && j == 0){
                lps[i] = 0; 
                i++; 
            }
        }
        return lps; 
    }
}
## Problem2 

Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

//Time Complexity = O(m)
//Space Complexity = O(26) - O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>(); 
        if(s.length() == 0 || p.length() == 0 || s.length() < p.length()) return result;
        
        HashMap<Character, Integer> map = new HashMap<>(); 
        int match = 0; 
        
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i); 
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        for(int i = 0; i < s.length(); i++){
            char in = s.charAt(i); 
            if(map.containsKey(in)){
                int count = map.get(in);
                count--; 
                map.put(in, count); 
                if(count == 0) match++; 
            }
            
            if(i >= p.length()){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++; 
                    map.put(out, count); 
                    if(count == 1) match--; 
                }
            }
            
            if(match == map.size()){
                result.add(i - p.length() + 1); 
            }
        }
        return result;
    }
}
