/*
* The approach is to store the pattern characters and its frequency in a map
* Iterate over the string s for every incoming character, check if the character exists in the map
    - if it does, reduce the frequency 
        - if freq is equal to 0 that means we found a character match, so increase the match count
        - if freq is in negative that means we there are more than needed characters in the window, so either keep it as it or reduce the match count
        - once the window size has increased the length of the pattern, that means we have extra characters in the window, so take out the (current index - pattern length) elements
        - if the character taken out is in the map, increase the freq and reduce the match count
        - if the match count at any point is equal to the size of the map, that means we have found the anagram of the pattern in the string and the index of it is the current index - pattern length + 1
- TC: O(n + m) -> n - length of s-> iterate over s and m -> iterate over pattern string to add it to the map
- SC: O(1) -> map of characters
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int match = 0;

        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    match++;
                }
            }

            if (i >= p.length()) {
                char out = s.charAt(i - p.length());
                if (map.containsKey(out)) {
                    map.put(out, map.get(out) + 1);
                    if (map.get(out) == 1)
                        match--;
                }
            }
            if (match == map.size()) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}