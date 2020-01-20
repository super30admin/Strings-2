// Time Complexity - O(m+n) where m is the length of String p and n is the length of String s
// Space Complexity - O(1) since the maximum characters the hashmap will contain is 26 characters.
// This solution worked on LeetCode
// We need to find the anagram for string p in string s. We would be creating a hashmap of string p with character and integer as number of times it has occurred in p. We would be iterating in String s to find the index of anagram for p. For this we would be checking for the window of p.length so that for every incoming character there will be an outgoing character. The anagram is obtained will be tracked by match variable which will be incremented if the incoming map value is 0 and decremented if the map value is 1. This is why we decrement the map value once the incoming character is found in map and increment the map value once the outgoing character leaves the window.


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || p== null || s.length() == 0 || p.length() == 0 || s.length() < p.length())
            return result;
        HashMap<Character,Integer> map = new HashMap<>();
        int match =0;
        for(int i=0; i< p.length();i++){        // Add the characters of p string in HashMap
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for(int i=0;i< s.length();i++){  //Iterate over the s String to find anagrams 
            char incoming = s.charAt(i);        // incoming character at i
            if(map.containsKey(incoming)){          // if the map contains the character decrement it's value in map
                map.put(incoming,map.get(incoming) - 1);
                if(map.get(incoming) == 0) // if it becomes 0 it means the character has occurred same number of times as p string so increment the match
                    match++;                
            }
            if(i >= p.length()){                // for every incoming character there will be an outgoing character considering i is greater than the p.length
                char outgoing = s.charAt(i - p.length());
                if(map.containsKey(outgoing)){
                    map.put(outgoing,map.get(outgoing) + 1);
                    if(map.get(outgoing) == 1)
                        match--;
                }
            }
            if(match == map.size())     // if the match is equal to the size of map it means all the characters in map have occurred in s
                result.add(i - p.length() + 1);     // add the start index of the anagram 
        }
        return result;
    }
}
