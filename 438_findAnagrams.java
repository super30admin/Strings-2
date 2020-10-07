    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/find-all-anagrams-in-a-string/
    Time Complexity for operators : o(n+m) .. n is the length of the small string which we have to find, m is longer one
    Extra Space Complexity for operators : o(n) .. hashmap
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : two for loops.
        # Optimized approach: 
                              
            # 1. 
                    A) At first, add all the elements in hashmap with its count
                    B) then take start and end points and iterate thru the another string
                    C) if hashmap contains character and end index then deduct the counter and if the
                       counter in hashmap is zero that means we found all occurances of that character thats why increase match
                    D) if (end-start+1 > p.length()), in that case check if character at start index is in hashamo oor not
                       if it is then add + to the counter value of that character and when counter becomes 1 decrease match, increase start
                    E) if match == hm.size() then add start index to result list.
                    F) At the end, increase end.
                    G) once while loop done,  return reulting list.
    */  

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        if(p.length()==0 || p == null)
            return new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        int start = 0;int end = 0; int match = 0;
        while(end < s.length()){
            char ch_end = s.charAt(end);
            char ch_start = s.charAt(start);
            
            if(hm.containsKey(ch_end)){
                hm.put(ch_end,hm.getOrDefault(ch_end,0)-1);
                
                if(hm.get(ch_end) == 0)
                    match += 1;
                    
            }
            
            if(end-start+1 > p.length()){
                if(hm.containsKey(s.charAt(start))){
                    hm.put(ch_start,hm.getOrDefault(ch_start,0)+1);
                    
                                    
                    if(hm.get(ch_start) == 1)
                        match -= 1;
                }

                
                start += 1;
            }
            if(match == hm.size()){
                list.add(start);
            }
            end += 1;
        }
        return list;
    }
}