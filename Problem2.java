// Time Complexity - O(m+n) where m is the length of String p and n is the length of String s
// Space Complexity - O(1) since the maximum characters the hashmap will contain is 26 characters.
// This solution worked on LeetCode


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || p== null || s.length() == 0 || p.length() == 0 || s.length() < p.length())
            return result;
        HashMap<Character,Integer> map = new HashMap<>();
        int match =0;
        for(int i=0; i< p.length();i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for(int i=0;i< s.length();i++){
            char incoming = s.charAt(i);
            if(map.containsKey(incoming)){
                map.put(incoming,map.get(incoming) - 1);
                if(map.get(incoming) == 0)
                    match++;
            }
            if(i >= p.length()){
                char outgoing = s.charAt(i - p.length());
                if(map.containsKey(outgoing)){
                    map.put(outgoing,map.get(outgoing) + 1);
                    if(map.get(outgoing) == 1)
                        match--;
                }
            }
            if(match == map.size())
                result.add(i - p.length() + 1);
        }
        return result;
    }
}
