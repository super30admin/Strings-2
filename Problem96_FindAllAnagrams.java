//Time Complexity: O(m+n)
//Space Complexity: O(1) -> HashMap of p -> length of p string

class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        //edge case
        if(s == null || s.length() == 0 || s.length() < p.length())
            return result;
        
        HashMap<Character, Integer> map = new HashMap<>();
        //initially creating map of 'p' string to check 
        //if anagrams of 'p' is present in 's'
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        int match =0;
        //for incoming character in the window size of 'p'
        for(int i = 0; i < s.length(); i++)
        {
            //for each char in s
            char in = s.charAt(i);
            //if the character is present in the map with a value
            //get the current value and subtract 1 from it
            if(map.containsKey(in))
            {
                map.put(in, map.get(in) - 1);
                //if value -> 0; found a match
                if(map.get(in) == 0)
                    match++;
            }
        
            //for outgoing character of the 's' from the window
            //if window size is > 'p' -> outgoing character
            if(i >= p.length())
            {
                char out = s.charAt(i-p.length());  //index of outgoing character
                //if map contains the outgoing key
                if(map.containsKey(out))
                {
                    //since its no more in the picture, +1
                    //and remove the character from match(match--)
                    map.put(out, map.get(out) + 1);
                    if(map.get(out) == 1)
                        match--;
                }
            }
            //if match and p.length is same
            //found anagram; add to the result list
            if(match == map.size())
                result.add(i-p.length()+1);
        }    
        return result;
    }
}
