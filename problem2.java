// 438 Find All Anagrams in a String
// solved on leetcode
// Time complexity : O(n)
// Space complexity : O(n)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap <Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList();
        for(int i=0;i<p.length();i++){
            char ch= p.charAt(i);
            
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        int match =0;
        
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            
            // incoming
            
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    match++;
                }
            }
            // outgoing
            
            if(i-p.length()>=0){
                char outGoing = s.charAt(i-p.length());
                if(map.containsKey(outGoing)){
                    map.put(outGoing,map.get(outGoing)+1);
                    if(map.get(outGoing)==1){
                        match--;
                    }
                }
            }
            
            if(match==map.size()){
                result.add(i-p.length()+1);
            }
        }
        
        return result;
    }
}