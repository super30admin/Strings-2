//Time Complexity : O(m+n)
//Space Complexity : O(1)
//Did this code run successfully on leetcode: Yes
//Any problem you faced while runnning this code: No
class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        int match = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i =0; i <m; i++) {
            //incoming character
            if(map.containsKey(s.charAt(i))) {
                int freq = map.get(s.charAt(i));
                freq--;
                map.put(s.charAt(i),freq);
                if(freq == 0) match++;
            }
            //outgoing character
            if(i >= n) {
                if(map.containsKey(s.charAt(i-n))) {
                    int freq = map.get(s.charAt(i-n));
                    freq++;
                    map.put(s.charAt(i-n),freq);
                    if(freq == 1) match--;
                }
            }
            if(match == map.size()) result.add(i-n+1);
        }
        return result;
    }
}