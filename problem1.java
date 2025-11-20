// Time Complexity : O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
we are using sliding and hashmap to solve the problem
We start by making the hashmap of the "p" string
then we star the for loop on "s" for the sliding window,
for every in coming char we check if it is in the map or not if yes, we
take the count of the char and reduce it by one, if the count becomes "0" increase the
match counter meaning we have found all the occurance of that particular char in our current string

one have itterated over the length of the "p" string we start removing the letters from start
so we check if "i-nth" char is in map or not if yes we increase the count by 1 and check if the count is 1 or not, if yes we reduce the
match count by one

on each itteration we also check if match == map size if yes we add the starting index for the current calculating string
to result by using (i-n+1)


*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return new ArrayList<>();
        }
        int n = p.length();
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int match = 0;
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            // in
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int cnt = map.get(in) - 1;
                if (cnt == 0) {
                    match++;
                }
                map.put(in, cnt);
            }
            // out
            if (i >= n) {
                char out = s.charAt(i - n);
                if (map.containsKey(out)) {
                    int cnt = map.get(out) + 1;
                    if (cnt == 1) {
                        match--;
                    }
                    map.put(out, cnt);
                }
            }
            if (match == map.size()) {
                result.add(i - n + 1);
            }
        }
        return result;
    }
}