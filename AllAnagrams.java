// Time Complexity : O(N)
// Space Complexity : O(Min(M,N))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> pMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();
        
        List<Integer> res = new ArrayList<>();
        
        for(char ch : p.toCharArray())
            pMap.put(ch,pMap.getOrDefault(ch,0)+1);
        
        int np = p.length();
        
        for(int i=0;i<s.length();i++) {
            
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch,0)+1);
            
            if(i-np>=0){
                if(sMap.get(s.charAt(i-np)) == 1)
                    sMap.remove(s.charAt(i-np));
                else
                    sMap.put(s.charAt(i-np), sMap.get(s.charAt(i-np))-1);
            }
            
            if(pMap.equals(sMap))
                res.add(i-np+1);
            
        }
        
        return res;
    }
}
