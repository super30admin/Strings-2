// Time Complexity : O(n*m) where n is the length of String s and m is the length of string p
// Space Complexity : O(n+m) where n is the length of String s and m is the length of string p
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class FindAllAnagrams {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            Map<Character,Integer> pMap = new HashMap<>(); // Map for string p
            Map<Character,Integer> sMap = new HashMap<>(); // Sliding window map
            int sL = s.length();
            int pL = p.length();
            if(pL>sL) return result;
            for(char c : p.toCharArray())
            {
                pMap.put(c,pMap.getOrDefault(c,0)+1);
            }
            
            for(int i=0;i<sL;i++)
            { 
                char c =s.charAt(i);
                sMap.put(c,sMap.getOrDefault(c,0)+1);
                if(i>=pL)
                {
                    c = s.charAt(i-pL);
                    if(sMap.get(c)==1)
                    {
                        sMap.remove(c);
                    }else{
                        sMap.put(c,sMap.get(c)-1);
                    }  
                }
                    if(sMap.equals(pMap))
                    {
                        result.add(i-pL+1);
                    }
                
            }
            
            return result;
        }
    }
    
}
