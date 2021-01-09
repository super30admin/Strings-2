// Time Complexity : O(n) where n is length of string s
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach: Add the count of characters in p to hashmap. iterate through the length 
// of the p in s and check if map contains the character. if it contains,decrease the count in map and increase the match variable if the count is 0
// If the match count equals the map size add the slow pointer to result. and continue the above process till the end of string s.
//
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : p.toCharArray()){//O(m)
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Integer> result = new ArrayList<>();
        if(p.length()>s.length())
            return result;
        int match=0;
        int slow = 0;
        int fast = 0;
        
        while(fast<p.length()){//O(m)
            if(map.containsKey(s.charAt(fast))){
                map.put(s.charAt(fast),map.get(s.charAt(fast))-1);
                if(map.get(s.charAt(fast))==0)
                    match++;
            }
            fast++;           
        }
        if(match==map.size()){   
            //System.out.println(slow);
            result.add(slow);
        }
        
        while(fast<s.length()){//O(n)
            if(map.containsKey(s.charAt(fast))){
                map.put(s.charAt(fast),map.get(s.charAt(fast))-1);
                if(map.get(s.charAt(fast))==0)
                    match++;
            }
            fast++;           
        if(map.containsKey(s.charAt(slow))){
                map.put(s.charAt(slow),map.get(s.charAt(slow))+1);        
            if(map.get(s.charAt(slow))==1)
                match--;
            }    
            slow++;
        if(match==map.size()){            
            result.add(slow);
        }        
        }
        
        return result;
    }
}