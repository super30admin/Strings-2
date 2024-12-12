//438. Find all Anagrams in a String - https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
//Time Complexity: O(m+n)
//Space Complexity: O(1) ~ 26 characters

class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        //initial map
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int match=0;
        for(int i=0; i<m; i++){
            char in = s.charAt(i);
            //map contains incoming character in the window
            if(map.containsKey(in)){
                int frq = map.get(in);
                frq--;
                map.put(in, frq);
                if(frq == 0){ //when there is a match between 's' and 'p'
                    match++;
                }
            }
            if(i >= n){
                char out = s.charAt(i-n); //outgoing character
                if(map.containsKey(out)){ //
                    int frq = map.get(out);
                    frq++;
                    map.put(out, frq);
                    if(frq == 1){
                        match--;
                    }
                }
            }
            if(match == map.size()){
                result.add(i-n+1);
            }
        }
        return result;
    }
}