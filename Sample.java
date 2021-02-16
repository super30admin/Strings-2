# String-2 problems

Problem 2:
(https://leetcode.com/problems/find-all-anagrams-in-a-string/)
// Time Complexity : O(m+n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Method #1: Check all subarrays of p length if anagram or not - O(m*n)
// Method #2: Sliding Window : maintain in and out pointers and Hashmap. - O(m+n) 
	
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int match=0;
        ArrayList<Integer> lst = new ArrayList<>();
        HashMap<Character, Integer> hmap= new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            hmap.put(c, hmap.getOrDefault(c,0)+1);
        }
        
        for(int i=0;i<s.length();i++){
            char in=s.charAt(i);
            if(hmap.containsKey(in)){
                int c=hmap.get(in);
                c--;
                hmap.put(in, c);
                if(c==0) match++;
                }
            if(i>=p.length()){
            char out=s.charAt(i-p.length());
            if(hmap.containsKey(out)){
                int c=hmap.get(out);
                c++;
                hmap.put(out, c);
                if(c==1) match--;
                }   
            }
            if(match==hmap.size()){
                lst.add(i-p.length()+1);
            }
        }
        return lst;
    }
    
}