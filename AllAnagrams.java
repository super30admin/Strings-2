// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach: create frequency map for p string. Maintain a variable match. Iterate through s string. For each char, check if it is in map, if yes decrement it's count
// if count==0, increment match. Keep sliding the window of size = p. If outgoing charcter is in map, increment it's count. If count =1, dec match. If 
// match==map.size, add window starting index to result.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        int match = 0;
        int m = p.length(), n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            char curr = p.charAt(i);
            if(!map.containsKey(curr)){
                map.put(curr, 0);
            }
            map.put(curr, map.get(curr)+1);
        }
        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr)-1);
                if(map.get(curr) == 0){
                    match++;
                }
            }
            if(i>=m){
                char prev = s.charAt(i-m);
                if(map.containsKey(prev)){
                    map.put(prev, map.get(prev) +1);
                    if(map.get(prev) == 1){
                        match--;
                    }
                }
            }
            if(match == map.size()){
                result.add(i-m+1);
            }
            System.out.println(curr+" "+map+" "+match);
        }
        return result;
    }
}