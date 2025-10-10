// Time Complexity : O(m+n) where m and n are length of string s and p
// Space Complexity : O(1), as the character map contains at most 26 letters.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We use Hashing with sliding window
// We store the frequency of pattern string in HashMap
// For each incoming character in source string we decrease the frquency count in map and increase the match if count becomes 0
// For each outgoing character we increase the frequency in map and decrease the match if count has become 1
// We have found a valid anagram when the size of map matches the match value

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        int match = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        //store the freq of string pattern in hash map
        for(int i = 0; i < m; i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //process source string using sliding window
        for(int i =0 ; i < n; i++) {
            //in
            char in = s.charAt(i);
            if(map.containsKey(in)) {
                int cnt = map.get(in);
                cnt--;
                map.put(in, cnt);
                if(cnt == 0)  match++;
            }

            //out
            if(i >= m) {
                char out = s.charAt(i - m);
                if(map.containsKey(out)) {
                    int cnt = map.get(out);
                    cnt++;
                    map.put(out, cnt);
                    if(cnt == 1) match--;
                }

            }
            if(match == map.size()) {
                //found anangram
                res.add(i - m + 1);
            }
        }
        return res;
        
    }
}
