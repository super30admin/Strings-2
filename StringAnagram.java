// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       List<Integer> res = new LinkedList<>();
        int[] smap = new int[26];
        int[] pmap = new int[26];
        for(int i=0;i<p.length();i++){
            pmap[p.charAt(i)-'a']++;
        }
        int fast=0;
        int slow=0;
        while(fast<s.length()){
            smap[s.charAt(fast)-'a']++;
            if(fast-slow+1==p.length()){
                
                if(Arrays.equals(smap,pmap)){
                    
                    res.add(slow);
                    
                    // smap[s.charAt(slow)-'a']++;
                }
            smap[s.charAt(slow)-'a']--;
            slow++;
            }
            
            fast++;
        }
        return res;
    }
}