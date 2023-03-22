// TC: O(n)  [O(m+n) n is larger, m is length of pattern, n is length of string, you traverse m to create a frequency map]
// SC: O(1) [Hashmap of lowercase alphabets]


// Create a freq map of the pattern
// Length of the pattern is the length of the sliding window
// Initially we only do incoming until i=m i.e. the length of the sliding window = length of pattern
// Then we move sliding window by one character, at the same time we remove the start character(outgoing) from the sliding window to maintain
// the length of sliding window 
// For incoming:
// Remove one count from map of the character, if it exists
// If count of that char becomes, 0, increment match, and update the count in the map
// For outgoing:
// Add one back of that character to the map, if it exists
// If count of that char becomes 1, decrement match, update the count in the map
// Finally:
// If size of match = match, get the start index of the anagram (i-m+1) .. m is length of string and +1 because of index

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>(); 
        HashMap<Character,Integer> map = new HashMap<>(); //frequency map
        int match=0;
        int m=p.length();
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1); //create frequency map
        }
        // traverse over string
        for(int i=0;i<s.length();i++){
            // take one count of the incoming character out from the map, if it exists
            char in=s.charAt(i);
            if(map.containsKey(in)){
                int count=map.get(in)-1; //remove 1 from map
                if(count==0) match++; //if that character is 0, increment match
                map.put(in,count); //update the new count
            }
            
            // from the 2nd sliding window
            // give one back to map of the outgoing character, if exists
            if(i>=m){
                char out=s.charAt(i-m);
                if(map.containsKey(out)){
                    int count=map.get(out)+1; //add one to map
                    if(count==1) match--; //if char count in map is 1, decrement match
                    map.put(out,count); //update
                }
            }
            
            if(map.size() == match){  // if mapsize is same as match
                result.add(i-m+1);    // start index of anagram i-length(pattern)+ 1(because, index)
            }
        }
        
        return result;
    }
}