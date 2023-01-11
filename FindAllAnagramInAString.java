// Time Complexity: O(n)
// Space Complexity: O(1)

/*
 * track the elements in p string and traverse in the string s and 
 * if we find the element increse the count and if it matches the 
 * frequency and number of elements add it to result and maintain the window size.
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int k = p.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int match = 0;
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i  = 0; i < s.length(); i++){
            char in = s.charAt(i);
            //in
            if(map.containsKey(in)){
                int cnt = map.get(in) -1;
                map.put(in, cnt);
                if(cnt == 0) match++;
            }
            //out
            if(i >= k){
                char out = s.charAt(i - k);
                if(map.containsKey(out)){
                    int cnt = map.get(out) +1;
                    map.put(out, cnt);
                    if(cnt == 1) match--;
                }
            }

            if(map.size() == match){
                result.add(i-k+1);
            }
        }
        return result;
    }
}