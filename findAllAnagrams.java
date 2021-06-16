// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < p.length() ; i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int match = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                map.put(in,count);
                if(count == 0) match++;
            }
            if(i >= p.length()){
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    map.put(out,count);
                    if(count == 1) match--;
                }
            }
            if(match == map.size()) result.add(i-p.length()+1);
        }
        return result;
    }
}
