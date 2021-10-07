


// Time Complexity : O(n) but  practically O(m+n) where m - anagram string length
// Space Complexity : O(1) -> just 26 characters 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/*Approach:
1) we use the sliding window technique of incoming and outgoing characters in array
2) we maintain a hashmap of p which will have the occurecnes of all characters appearing in p
3) 3 vairables -> 1) match -> to indicate matching string
                  2) count ==1 -> mentions about 1 more character is required
                  3) count ==-1 -> mentions about 1 extra character is present
                  4) count == 0 -> match is present
4) if(count==0)
                {
                    match++;
                }
    if count is 0 we invoke the 4th case match is present
5) if(count ==1)
                    {
                        match--;
                    }
    if count is 1, we know 1 more character is required
6) res.add(i-p.length()+1); -> dealing with indexes

*/

import java.util.*;
class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
      
        
        List<Integer> res = new ArrayList<>();
        
        if(s==null || s.length()==0 ||  p==null || p.length()==0)
        {
            return res;
        }
        
        Map<Character,Integer> map = new HashMap<>();
        
        // include matches in string
        int match =0;
        
        
        for(int i=0;i<p.length();i++)
        {
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            
        }
        
        
        for(int i=0;i<s.length();i++)
        {
            char in = s.charAt(i);
            if(map.containsKey(in))
            {
                int count = map.get(in);
                count--;
                if(count==0)
                {
                    match++;
                }
                
                map.put(in,count);
            }
            if(i>=p.length())
            {
                char out = s.charAt(i-p.length());
                if(map.containsKey(out))
                {
                    int count = map.get(out);
                    count++;
                    if(count ==1)
                    {
                        match--;
                    }
                    map.put(out,count);
                }
                
            }
            if(map.size()==match)
            {
                res.add(i-p.length()+1);
            }
            
            
        }
        
        
        
        return res;
        
    }
}