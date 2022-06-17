// Time Complexity : O(s.length+p.length) = O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length()<p.length()){
            return new ArrayList<>();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        int match = 0;
        for(int i=0;i<s.length();i++){
            //incoming characters
            char incomingC = s.charAt(i);
            if(map.containsKey(incomingC)){
                int count  = map.get(incomingC);
                count--;
                map.put(incomingC, count);
                if(count==0){
                    match++;
                }
            }
            
            //outgoing characters
            if(i>=p.length()){
                char outgoingC = s.charAt(i-p.length());
                if(map.containsKey(outgoingC)){
                    int count = map.get(outgoingC);
                    count++;
                    map.put(outgoingC, count);
                    if(count==1){
                        match--;   
                    }
                }
            }
            
            //if match is same as pattern
            if(match == map.size()){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}