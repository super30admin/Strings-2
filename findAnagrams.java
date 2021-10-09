// Time Complexity: O(m+n) where m is size of p string
// Space Complexity: O(m) where m is size of p string
// Idea here is to track in map if p size window has equal number of matches, if match is same as map length
// we add initial value of that substring
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()) return new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0)+1);
        }
        List<Integer> result = new ArrayList<>();
        int match = 0;
        for(int i=0; i<s.length(); i++) {
            // incoming
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c, --count);
                if(count==0) match++;
            }
            // outgoing
            if(i>=p.length()){
                char oc = s.charAt(i-p.length());
                if(map.containsKey(oc)){
                    int oCount = map.get(oc);
                    map.put(oc, ++oCount);
                    if(oCount==1) match--;
                }
            }
            if(match==map.size()) result.add(i-p.length()+1);
        }
        return result;
    }
}