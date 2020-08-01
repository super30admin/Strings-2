// Time Complexity : O(m+n)
// Space Complexity : O(1) : Alphabets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Sliding window using hashmap
//TC : O(n+m)
//SC : O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //create result list
        List<Integer> result = new ArrayList<>();
        //check for null and empty case
        if(s == null || s.length() == 0) return result;
        //keep a match count; if match == map.size (complete string p found in s)
        //add ith index to result then
        int match = 0;
        //create hashmap and add character and its number of occurance as value
        HashMap<Character, Integer> map = new HashMap<>();
        
        //add all the characters and its number of occurance to map
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        //iterate through th s string
        for(int i = 0; i < s.length(); i++) {
            //get the incoming char in sliding window
            char incoming = s.charAt(i);
            //check if it exists in map/p string
            if(map.containsKey(incoming)) {
                //get the count from map
                int count = map.get(incoming);
                //decrease its count (found a occurance)
                count--; 
                //check if count of that char is 0
                //if 0, increase match
                if(count == 0) match++; 
                //update it in map
                map.put(incoming, count);
            }
            
            //get outgoing char (outgoing only when i >= p.length 
            //(till then no outgoing char))
            if(i >= p.length()) {
                //get the outgoing char in sliding window (at position:i - p.length())
                char outgoing = s.charAt(i - p.length());
                //check if it exists in map/p string
                if(map.containsKey(outgoing)) {
                    //get the count from map
                    int count = map.get(outgoing);
                    //increase the count (as the char does not exists in the sliding window)
                    count++; 
                    //update in map
                    map.put(outgoing, count);
                    //if count is become 1 (we know no occurance of char in sliding window)
                    //so decrease match
                    //it can be -ve (more occurance of char in sliding window) 
                    //so we decrease count only if count == 1 
                    //can go positive (in case of many occurance of same char in p)
                    //but we should change match only once 
                    //as we validate complete match using map.size
                    if(count == 1) match--;
                }
            }
            
            //if match count = map.size
            if(match == map.size()) {
                //get sliding window starting position
                //add to result list
                result.add(i - p.length() + 1);
            }
        } 
        //return result list
        return result;            
    }
}

