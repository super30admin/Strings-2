
// Time Complexity : O(np + ns)
// Space Complexity : O(n) it could be considered O(1) since only 26 chars?
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {     
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s==null || p==null || s.length()==0)
            return res;
        
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapP = new HashMap<>();
        
        for(int i=0; i<p.length(); i++){
            char c = p.charAt(i);
            mapP.put(c, mapP.getOrDefault(c, 0) + 1);
        }
        
        int lenP = p.length();

         for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

             mapS.put(c, mapS.getOrDefault(c, 0) + 1);
             if(i >= lenP){
                char ch = s.charAt(i-lenP);
                mapS.put(ch, mapS.get(ch)-1);
                if(mapS.get(ch)==0){
                    mapS.remove(ch);
                }
             }

             if(mapP.equals(mapS)){
                 res.add(i-lenP+1);
             }
         }
        return res;
    }
}