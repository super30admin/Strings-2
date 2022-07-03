
// Time Complexity : O(n) n are the length of the string s.
// Space Complexity : O(m) m is the length of the p string. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
used sliding window method on the string s. Travese through s and check the character availablity in the map.
increment the match and also if the window length exceeds the p string length then reset the map by moving the window.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int match = 0;
        List<Integer>result = new ArrayList<>();
        for(int j=0;j<s.length();j++){
            //incoming chars
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                count--;
                if(count==0) match++;
                map.put(ch,count);
                
            }
            if(j>=p.length()){
                char out = s.charAt(j-p.length());
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    if(count==1) match--;
                    map.put(out,count);
                }
            }
            if(match == map.size()) result.add(j-p.length()+1);
        }
        return result;
    }
}