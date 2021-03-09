// time complexity : O(s + p)
// p = length of string p
// s = length of string s
// space complexity : O(length(p))
// worked on leetcode : YES
/**
Sliding window HashMap solution
// no need to sort
and O(m+n) algorithm
**/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        Map<Character, Integer> map = new HashMap();
        
        List<Integer> res = new ArrayList();
        if( p == null || p.length() == 0) {
            return res;
        }
        
        for(Character c :  p.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        
        int start = 0;
        int end = 0;
        int match  = 0;
        while(end < s.length()) {
            Character curr = s.charAt(end);
            
            // incoming  Element
            // if it is already present decrease the count
            // if count becomes zero we have matched this in our current window
            
            if(map.containsKey(curr)) {
                map.put(curr, map.get(curr)-1);
                
                if(map.get(curr) == 0 ) {
                    match++;
                }
            }
            
            
            // outgoing Element
            
            // if window size becomes greater than length of p
            // if out going char in map then increment the count as it is moved out
            // of window
            // if count becomes 1 then we are short of 1 count to reach requiremtn
            // decrease the match 
            if(end - start + 1 > p.length()) {
                Character out = s.charAt(start);
                // change the count of outgoing char if it presents in map
                if(map.containsKey(out)) {
                    map.put(out, map.get(out)+1);
                    
                     if(map.get(out) == 1) {
                        match--;
                    }
                }
                // increment start when we have larger window size
                start++;
                
            }
            
            // if match equals the size of map or length of p 
            // store start index in result array
            if(match == map.size()) {
                res.add(start);
            }
            
            
            // we always move end pointer
            end++;
        }
        
        return res;
    }
}


/**


// Not so good solution but works if nothing comes in mind
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> li  = new ArrayList();
        
        
        
        if(s == null || p == null || s.length()  == 0 || p.length() == 0 || p.length() > s.length() )           {
            return li;
        }
        
        int left = 0;
        int right ;
        char [] pArr = p.toCharArray();
        // sort char array
        Arrays.sort(pArr);
        String sortedp = String.valueOf(pArr);
       
        for(right = p.length() -1; right < s.length() ; right++ ) {
            String sub = s.substring(left, right+1);
            char [] subArr = sub.toCharArray();
            Arrays.sort(subArr);
            String sortedSub = String.valueOf(subArr );
            if(sortedp.equals(sortedSub) ) {
                li.add(left);
            }
            left++;
        
            
        }
        return li;
    }
    
    
  
    
    
}
**/
