/*
Approach-1
take sliding window of length = pattern
sort that
compare with sorted pattern
if similar , add starting Index of the window to list!
tc: mn log mn
sc: O(m) - m is lengthof bigger source string -
intermediate space used here to store the index
*/
/*
approach-2
prime factor, assign it to all the characters
calculate the running product for sliding winow, 
if it matches pattern, return startng Index of the window
tc: O(m+n)
sc: O(1)
*/

/*
Hashmap approach
build a HashMap for pattern
variable match - i supdated when freq of the character becomes 0 or 1 
and we'll have a sliding window going with length p.length!
TC: O(m+n)
SC: O(1)
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() == 0 || s == null || p.length()==0 ||  p ==null) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< p.length(); i++)
        {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        int left =0, right =0,match=0;
        
        while(right < s.length())
        {
            char in = s.charAt(right);
            char out = s.charAt(left);
            
            //in character
            if(map.containsKey(in)){
                
                int count = map.get(in);
                count--;
                
                if(count == 0)
                    match++;

                map.put(in, count);
            }
            
            //verify that it's not a breach!
            if(right-left+1 > p.length()){
                
                if(map.containsKey(out)) //out character
                {
                    int count = map.get(out);
                    count++;
                    
                    if(count ==1) 
                        match--;
                    
                    map.put(out, count);
                }
                left++;
            }
            
            if(match == map.size())
            {
                result.add(left);
            }
            right++;
        }
        return result;
    }
}