/*
 * TC: O(n+m), n:s.length and m=p.length
 * SC: O(m), size of my hashmap to store frequency of the characters in p.
 * 
 * Approach: Initally, i buuild my HashMap by iterating though the p and keep updating 
 * the frequency of the chars.now, i iterate though the s and whenevr i see a char present my map
 * then i decrease the frequency associate with the char and update my counter.
 * keep sliding my window of size m.each time i remoc=ve the char from the window ,the increment of the frequency is done and vice-versa.
 * at the end i will check if my match = size of map, i return i - p.length+1 which is the 
 * starting index of the anagram. keep doing this until end of s.
 */


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int match = 0;

        for(int i = 0; i< p.length(); i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0) match++;
            }
            if(i >= p.length()){
                char chAtStart = s.charAt(i - p.length());
                if(map.containsKey(chAtStart)){
                    map.put(chAtStart, map.get(chAtStart)+1);
                    if(map.get(chAtStart) == 1) match--;
                }
            }
        if(match == map.size()) result.add(i - p.length()+1);    
        }
    return result;    
    }
}