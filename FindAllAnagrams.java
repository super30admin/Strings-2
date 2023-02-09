// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Create a frequency map of the pattern string
// Keep track of a variable match and then go over the string s
// Use sliding window concept and consider the outgoing and incoming elements, and update the hashmap and matches accordingly

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int match = 0;
        for(int i=0;i<s.length();i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                map.put(in, map.get(in)-1);
                if(map.get(in)==0)
                    match++;
            }
            if(i-p.length()>=0){
                char out = s.charAt(i-p.length());
                if(map.containsKey(out))
                    {map.put(out,map.get(out)+1);
                    if(map.get(out)==1)
                        match--;}
            }
            if(match==map.size())
                result.add(i+1-p.length());
    }
    return result;
    }
}