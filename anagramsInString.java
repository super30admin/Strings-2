//tc : O(max(s.length,p.length));
//sc : O(p.length);
//run successfull
//no problems

//used hashmaps to save number of repeated characters 
//used two pointers to check with the repetation of an anagram

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, 1 + map.getOrDefault(c, 0));
        }
        int len = p.length();
        int currLen = 0;
        int start = 0, end = 0;
        List<Integer> list = new ArrayList<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                if (map.get(c) == 0) {
                    char t = s.charAt(start);
                    map.put(t, 1 + map.get(t));
                    currLen--;
                    start++;
                } else {
                    map.put(c, map.get(c) - 1);
                    end++;
                    currLen++;
                }
            } else {
                while (currLen > 0) {
                    char t = s.charAt(start);
                    start++;
                    map.put(t, 1 + map.get(t));
                    currLen--;
                }
                end++;
                start = end;
                currLen = 0;
            }
            if (currLen == len) {
                list.add(start);
                char t = s.charAt(start);
                start++;
                map.put(t, 1 + map.get(t));
                currLen--;
            }
        }

        return list;
    }
}