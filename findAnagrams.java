//time O(n) where n is length of the source string
//space O(m) => size of pattern can be O(1)
//approach use a sliding window approach and initiate a char freq map of pattern string. While sliding the window keep track of incoming char and outgoing char and update the map acc. Also keep a variable called match to keep track of how many char have been matched.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            Character c = p.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        int m = s.length();
        int n = p.length();
        int match = 0;
        for (int i = 0; i < m; i++) {
            //in
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                int count  = map.get(c);
                count--;
                if (count == 0) {
                    match++;
                }
                map.put(c, count);
            }
            
            //out
            if (i >= n) {
                Character out = s.charAt(i - n);
                if(map.containsKey(out)) {
                    int count  = map.get(out);
                    count++;
                    if (count == 1) {
                        match--;
                    }
                    map.put(out, count);

                }
            }
            if(match == map.size()) {
                result.add(i - n + 1);
            }
        }
        
        return result;
    }
}
