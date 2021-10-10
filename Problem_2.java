// Time Complexity : O(n+p)
// Space Complexity :O(p)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// check if present in hashmap, then move the window
// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0|| p.length() > s.length()) return result;
        HashMap<Character, Integer> hm = new HashMap<>();
        int total = 0;
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // insert to window
            if(hm.containsKey(c)){
                int count = hm.get(c);
                count--;
                hm.put(c,count);
                // System.out.println("updated count "+count);
                if(count == 0){
                    total++;
                }

            }
            // remove from window
            if( i >= p.length()){
                char cRemove = s.charAt(i-p.length());
                if(hm.containsKey(cRemove)){
                    int count = hm.get(cRemove);
                    count++;
                    hm.put(cRemove,count);
                    if(count == 1){
                        total--;
                    }
                }
            }
            if(total == hm.size()){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}