// Problem2 : Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)
// Time - O(p + s) Space - O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        //edge case
        if(s.isEmpty()) return res;
        
        int[] pvalue = new int[26];
        int[] svalue = new int[26];
        
        //populate pvalue
        for(char c: p.toCharArray()){
            pvalue[c - 'a']++;
        }
        
        int start = 0, end = 0, n = s.length();
        while(end < n){
            char endChar = s.charAt(end);
            svalue[endChar - 'a']++;
            
            if(end - start + 1 > p.length()){
                svalue[s.charAt(start++) - 'a']--;
            }
            
            if(Arrays.equals(pvalue, svalue)){
                res.add(start);
            }
            end++;
        }
        
        
        return res;
    }
}