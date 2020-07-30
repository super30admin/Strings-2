// Time Complexity : O(m+n) m and n are lengths of strings
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0;i<p.length();i++){
                map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
            }
        int match = 0;
        for(int i=0;i<s.length();i++){
            char a= s.charAt(i);
            if(map.containsKey(a)){
                map.put(a,map.get(a)-1);
                if(map.get(a)==0)
                    match++;
            }
            
            if(i >= p.length()){
                a = s.charAt(i-p.length());
                if(map.containsKey(a)){
                    map.put(a,map.get(a)+1);
                if(map.get(a)==1)
                    match--;
            }
            }
            
            if(match == map.size()){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}