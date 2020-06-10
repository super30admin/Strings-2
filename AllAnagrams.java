// Time Complexity :
/*              Approach 1: Using HashMap: O(m+n) where n is the length of the string 1 and m is the length of string 2
                Approach 2: Using integer array: O(m+n) where n is the length of the string 1 and m is the length of string 2
// Space Complexity : O(1) hashmap/array with 26 characters at max
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Store the shorter array to be checked in a hashmap or an integer array. Parse over
the other array. Parse it using an interval of P length. We simply check if the character is in map/array, if yes we reduce the count from the storage since
we have processed this. If the fast pointer exceeds, P's length , it implies we have a new character that is incoming to the window and a character
leaving a window. We check if the incoming character is in the storage, we reduce the count since we found a match. We check if the leaving character
is in the storage, we increment the count since we are resetting the count of the character we are seeing it again. If the match is equal to the storage
size, add the index to the result.
*/

// Approach 1: Using Hashmap
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if(p == null || p.length() == 0){return result;}
    HashMap<Character, Integer> store = new HashMap<>();                                                // Storing character and its counts
    for(int c = 0; c < p.length(); c++){
        store.put(p.charAt(c), store.getOrDefault(p.charAt(c), 0) + 1);                                         // Store the shorter array
    }
    int match = 0;                                                                      // keep a track of number of characters in the window are processed or not
    for(int j = 0; j < s.length(); j++){
        char c = s.charAt(j);
        if(store.containsKey(c)){
                store.put(c, store.get(c)-1);                                           // Character is in the storage and it is incoming character
                if(store.get(c) == 0)                                                   // Character has been processed in the window, match increments
                    match++;
            }
        if(j >= p.length()){
             char chr = s.charAt(j-p.length());                                         // If the outgoing character was in the storage
             if(store.containsKey(chr)){
                store.put(chr, store.get(chr)+1);                                       // It was a part of storage, we are resetting its count
                if(store.get(chr) == 1)
                    match--;                                                            // It is no longer a match
            }
        }
        if(store.size() == match){result.add(j-p.length()+1);}                                  // Add the start index of the array in the result
    }
        return result;
    }
}

// Approach 2: Using integer array
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if(p == null || p.length() == 0){return result;}
    int[] mapChar = new int[26];                                                        // Storing the character and its counts
    for(int c = 0; c < p.length(); c++){
        mapChar[p.charAt(c) - 'a']++;                                               // Add the P array into the data storage
    }
    int start=0, end =0;
    while(end < s.length()){
        if(mapChar[s.charAt(end) - 'a'] > 0){                                                       // If the character is in the storage, reduce its count
            mapChar[s.charAt(end) - 'a']--;
            end++;                                                                      // Time to process next character
        if(end-start == p.length()){                                                        // If the length of the window is equal to P's length
         result.add(start);                                                     // Add the start index in the result
        }
        }
        else
        if(start == end){                                                       // If both the pointers point to same location, no point, increment both
            start++;
            end++;
        }
        else 
        {
            mapChar[s.charAt(start++) - 'a']++;                                             // Rest of the cases, outgoing characters (not in window anymore), simply increment the count
        }
    }
        return result;
    }
}